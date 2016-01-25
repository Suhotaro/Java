package MatrixMul;

public class MatrixCommon {
    Matrix m;

    public MatrixCommon(Matrix m) {
        this.m = m;
    }

    public void run()
    {
        int [][] A = m.getA();
        int [][] B = m.getB();
        int [][] Res = m.getR();

        for (int k = 0; k < A.length; k++)
        {
            int res = 0;
            for (int i = 0; i < B.length; i++)
            {
                for (int j = 0; j < B[i].length; j++)
                {
                /*
                int n1 = A[string][j];
                int n2 = B[j][i];
                */
                    res += A[k][j] * B[j][i];
                }

                Res[k][i] = res;
                res = 0;
            }
        }
    }
}
