import java.util.LinkedList;

public class hashString {

    private static int LENGHT = 100;

    private String source;
    private String pattern;
    private long p = 1111;
    private LinkedList<Long> pow = new LinkedList<Long>();
    private LinkedList<Long> hash_source = new LinkedList<Long>();
    private LinkedList<Long> hash_pattern = new LinkedList<Long>();

    public hashString(String source, String pattern){
        this.source = source;
        this.pattern = pattern;

        calculateHash();
    }


    public boolean equalsSimple()
    {
        if (source.length() != pattern.length())
            return false;

        for (int i = 0; i < source.length(); i++)
        {
            if (source.charAt(i) != pattern.charAt(i))
                return false;
        }

        return true;
    }


    public boolean equalsHashEqualLength()
    {
        if (source.length() != pattern.length())
            return false;

        if (getHash(hash_source, 0, source.length()) * pow.get(pattern.length()) ==
            getHash(hash_pattern, 0, pattern.length()) * pow.get(source.length()))
                return true;

        return false;
    }


    public int equalsHashByPattern()
    {
        long pattern_hash = getHash(hash_pattern, 0, pattern.length());

        for (int i = 0; i + pattern.length() - 1 < source.length(); i++)
        {
            if ( getHash(hash_source, i, i + pattern.length()) == pattern_hash * pow.get(i) )
                return i;
        }

        return -1;
    }


    private void calculateHash()
    {
        pow.add((long)1);for (int i = 1; i < LENGHT; i++)
        {
            pow.add(pow.get(i - 1) * this.p);
        }

        hash_source.add((long)source.charAt(0));
        for(int i = 1; i < source.length(); i++)
            hash_source.add((long)(hash_source.get(i - 1) + pow.get(i) * source.charAt(i)));

        hash_pattern.add((long)pattern.charAt(0));
        for(int i = 1; i < pattern.length(); i++)
            hash_pattern.add((long)(hash_pattern.get(i - 1) + pow.get(i) * pattern.charAt(i)));
    }

    private long getHash(LinkedList<Long> hash,int L, int R)
    {
        long result = hash.get(R - 1);
        if (L>0) result -= hash.get(L - 1);
        return result;
    }
}
