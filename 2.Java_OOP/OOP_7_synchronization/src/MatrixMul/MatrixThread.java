package MatrixMul;

public class MatrixThread extends Thread {

    Matrix m;
    int string;

    public MatrixThread (Matrix m, int string)
    {
        this.m = m;
        this.string = string;
    }

    public void run () {
        int[][] A = m.getA();
        int[][] B = m.getB();
        int[][] R = m.getR();

        int res = 0;
        for (int i = 0; i < B.length; i++)
        {
            for (int j = 0; j < B[i].length; j++)
            {
                /*
                int n1 = A[string][j];
                int n2 = B[j][i];
                */
                res += A[string][j] * B[j][i];
            }

            R[string][i] = res;
            res = 0;
        }
     }
}
