public class Main {

    public static int min (int ... v)
    {
        if (v.length == 0)
            return 0;

        if (v.length == 1)
            return v[0];

        int min = v[0];
        for (int i = 1; i < v.length; i++)
        {
            if (v[i] < min)
                min = v[i];
        }

        return min;
    }

    public static void show (int [][]a)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {

        int [][]A =
        {
                {1, 1, 1, 0, 0,},
                {1, 1, 1, 0, 0,},
                {1, 1, 1, 1, 1,},
                {0, 0, 1, 1, 1,},
                {0, 0, 1, 1, 0,},

             /*
            {0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            */
        };

        show(A);

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[i].length; j++)
            {
                if (A[i][j] != 0)
                {
                    if (i - 1 < 0 && j - 1 < 0)
                        A[i][j] = 0 + A[i][j];
                    else if (i - 1 < 0)
                        A[i][j] = 1 + A[i][j-1];
                    else if (j - 1 < 0)
                        A[i][j] = 1 + A[i-1][j];
                    else
                        A[i][j] = 1 + min(A[i-1][j], A[i-1][j-1], A[i][j-1]);
                }
            }


        show(A);


        int num = 105;
        double dev = num;
        int sum = 0;

        while (sum == 0 || sum > 10) {
            while (true) {
                dev /= 10;
                if (dev < 1) {
                    sum += dev * 10;
                    break;
                }

                sum += ((dev - (int) dev) * 10) + 0.5f;
                dev = (int)dev;
            }

            if (sum >= 10) {
                dev = sum;
                sum = 0;
            }
        }

        System.out.println(sum);

        String[] s=
                {
                        "acc",
                        "aaa",
                        "aaba",
                };


        Solution solution = new Solution();
        String ans = solution.longestCommonPrefix(s);
        System.out.print(ans);


    }
}

class Solution {
    public String getCommonPrefix(String s1, String s2)
    {
        if (s1 == "" || s2 == "")
            return "";


        String prefix = new String();

        if (s1.length() > s2.length() )
        {
            for (int i = 0; i < s2.length(); i++)
            {
                if (s1.charAt(i) == s2.charAt(i))
                    prefix += s1.charAt(i);
                else
                    break;
            }
        }
        else
            for (int i = 0; i < s1.length(); i++)
            {
                if (s1.charAt(i) == s2.charAt(i))
                    prefix += s1.charAt(i);
                else
                    break;
            }

        return prefix;
    }


    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1)
            return strs[0];

        String common_prefix = new String();

        for (int i = 0; i < strs.length - 1; i++)
        {
            String tmp = new String();
            tmp = getCommonPrefix(strs[i], strs[i + 1]);
            if (tmp.equals("") || tmp == null)
                return "";

            if (i == 0)
            {
                common_prefix = tmp;
                continue;
            }


            if (tmp.charAt(0) != common_prefix.charAt(0))
                return "";

            common_prefix = getCommonPrefix(tmp, common_prefix);
        }

        return common_prefix;
    }
}