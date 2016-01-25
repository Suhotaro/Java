package MatrixMul;

import java.util.Arrays;

public class MatrixMul {

    public void run() {

        Matrix m = new Matrix(6);
        m.show_matrixes();
        //m.show_res();


        MatrixThread []mt = {
                new MatrixThread(m, 0),
                new MatrixThread(m, 1),
                new MatrixThread(m, 2),
                new MatrixThread(m, 3),
                new MatrixThread(m, 4),
                new MatrixThread(m, 5),
        };

        long tm1 = System.currentTimeMillis();

        for (MatrixThread t : mt)
            t.start();

        for (MatrixThread t : mt)
        {
            try {
                t.join();
            }
            catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }

        //m.show_matrixes();
        m.show_res();

        System.out.println("Time1 = " + (System.currentTimeMillis() - tm1));


        /*
        long tm2 = System.currentTimeMillis();

        Matrix A = new Matrix(6);
        MatrixCommon mc = new MatrixCommon(A);
        mc.run();
        A.show_res();

        System.out.println("Time1 = " + (System.currentTimeMillis() - tm2));
        */
    }
}

class Matrix
{
    int size;
    int [][]A;
    int [][]B;
    int [][]Res;

    public Matrix(int size)
    {
        this.size = size;

        A = new int [size][size];
        B = new int [size][size];
        Res = new int [size][size];

        int tmp = 1;
        int tmp2 = size*size;
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
            {
                A[i][j] = tmp++;
                B[i][j] = tmp2--;
            }
    }

    public int[][] getA() {
        return A;
    }

    public int[][] getB() {
        return B;
    }

    public int[][] getR() {
        return Res;
    }

    public void show_matrixes(){
        System.out.println("A:");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.print('\n');
        }

        System.out.print("\n");

        System.out.println("B:");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public void show_res(){
        System.out.println("Res:");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(Res[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
