package com.company;

import ThreadArrSum.ThreadArrSum;
import Volatile.Volatile;
import ATM.ATM;
import WaitNotify.WaitNotify;
import Doc.Doc;
import MatrixMul.MatrixMul;
import FileCopy.FileCopy;

enum T{Red, Wite, Blak};
enum D{Red, FT};

public class Main {

    public static void main(String[] args) {

        /*
        Volatile vt_run = new Volatile();
        vt_run.run();
        */

        /*
        ATM atm = new ATM();
        atm.run();
        */

        /*
        WaitNotify wn = new WaitNotify();
        wn.run();
        */

        /*
        Doc doc = new Doc();
        doc.run();
        */

        /*
        ThreadArrSum tas = new ThreadArrSum();
        tas.run();
        */

        /* HW */
        /*
        MatrixMul mm = new MatrixMul();
        mm.run();
        */

        /*
        FileCopy fc = new FileCopy();
        fc.run();
        */

        T c = T.Red;
        D d = D.Red;



        if (c  == T.Blak )
        {
            System.out.println("BLACK: " + c);
        }
        else if( c == T.Red )
        {
            System.out.println("RED: " + c);
        }

        A qwer = new A();

        System.out.println("addres: " + qwer);
        System.out.println("addres: " + qwer.toString());
        System.out.println("addres: " + qwer.hashCode());


    }
}

class A
{


    public A() {;}

    public void run ()
    {
        ;
    }


}