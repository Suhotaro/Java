package Main;

import java.util.concurrent.ConcurrentHashMap;

public class TimedCache
{
    long time;
    byte []buf;

    public TimedCache() {}

    public TimedCache(long time, byte []buf)
    {
        this.time = time;
        this.buf = buf;
    }

    public void setTime( long time) { this.time = time; }
    public long getTime() { return time; }

    public void setBuf( byte[] buf ) { this.buf = buf; }
    public byte[] getBuf() { return buf; }
}
