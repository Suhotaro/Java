package WaitNotify;

import java.util.Arrays;
import java.util.Random;

public class WaitNotify {
    public void run()
    {
        Random r = new Random();
        int[] arr = new int[10000000];
        Arrays.fill(arr,r.nextInt(Integer.MAX_VALUE));

        CalcThread ct = new CalcThread(arr);
        ct.start(); // ��������� ������� � ��������� ������

        synchronized (ct)
        {
            try {
                ct.wait(); // ���� ���������� ������
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Result is " + ct.getResult()); // ���������
        }
    }
}

class CalcThread extends Thread { // ������� ��������������
    long res;
    int[] arr;

    public CalcThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        synchronized (this) {
            for (int i : arr) {
                res += i;
            }
            res /= arr.length;
            notify(); // �������� �� ��������� ������
        }
    }

    public long getResult() {
        return res;
    }
}
