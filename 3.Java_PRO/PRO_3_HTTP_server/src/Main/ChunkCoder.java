package Main;

import org.omg.DynamicAny._DynArrayStub;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ChunkCoder extends InputStream
{
    private final static int defaultChunkSize = 30;
    private int chunkSize;

    private int num_chunks;
    private int current_chunk;

    private int tail;
    private int offset;
    private int data_len;

    private boolean flag = false;

    byte[] data;

    ByteArrayOutputStream byte_array;
    List<String> headers;

    public ChunkCoder(int chunkSize, byte[] data, List<String> headers)
    {
        if (chunkSize <= 0)
            this.chunkSize = this.defaultChunkSize;
        this.chunkSize = chunkSize;

        this.headers = headers;
        this.data = data;

        this.data_len = data.length;
        this.num_chunks = data.length / chunkSize;
        this.current_chunk = 1;
        this.tail = data.length % chunkSize;
        this.offset = 0;

        this.byte_array = new ByteArrayOutputStream();
    }

    /*------------------------  Getters Setters  ------------------------*/
    public int getChunkSize() { return this.chunkSize; }
    public void setChunkSize(int chunkSize)
    {
        if (chunkSize <= 0)
            this.chunkSize = this.defaultChunkSize;
        this.chunkSize = chunkSize;
    }

    public List<String> getHeadersList() { return this.headers; }
    public void setHeadersList(List<String> headers) { this.headers = headers; }

    public int getCurrentChunk() { return this.current_chunk; }
    public void setCurrentChunk(int num_chunk) { this.current_chunk = num_chunk; }


    /*---------------------------  Privates  ----------------------------*/
    private int do_copy(byte[] b)
    {
        byte []tmp = byte_array.toByteArray();
        for (int i = 0; i < tmp.length; i++ ) {
            b[i] = tmp[i];
        }
        byte_array.reset();

        return tmp.length;
    }


    /*---------------------------  Overrides  ---------------------------*/
    @Override
    public int read(byte b[]) throws IOException
    {
        if (flag) {
            flag = false;
            return 0;
        }

        System.out.println("chunk: " + current_chunk);
        int length = 0;

        if (current_chunk <= num_chunks)
        {
            String head = Integer.toHexString(chunkSize) + "\r\n";

            byte_array.write(head.getBytes());
            byte_array.write(data, offset, chunkSize);
            byte_array.write("\r\n".getBytes());
            offset += chunkSize;

            current_chunk += 1;
        }
        else if (tail > 0)
        {
            String head = Integer.toHexString(tail) + "\r\n";
            byte_array.write(head.getBytes());
            byte_array.write(data, offset, tail);
            byte_array.write("\r\n".getBytes());

            byte_array.write("0\r\n\r\n".getBytes());
            headers.add("Transfer-Encoding: chunked\r\n");

            current_chunk = 0;

            length = do_copy(b);
            byte_array.reset();

            flag = true;

            return length;
        }
        else
        {
            byte_array.write("0\r\n\r\n".getBytes());
            headers.add("Transfer-Encoding: chunked\r\n");

            current_chunk = 0;

            length = do_copy(b);
            byte_array.reset();

            flag = true;

            return length;
        }

        length = do_copy(b);
        byte_array.reset();

        System.out.println(new String(b));

        return length;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException
    {
        /* To be implemented */
        return 0;
    }

    @Override
    public int read() throws IOException
    {
        /* To be implemented */
        return 0;
    }
}
