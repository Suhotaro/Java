package com.company;

import BasicInterfaces.BasicInterface;
import Monitor.src.RunMonitor;
import Compator.RunHumanComparator;
import Figures.RunFigure;



public class Main {

    public static void main(String[] args) {

/*
        BasicInterface binterface = new BasicInterface();
        binterface.run();
*/


        /* Task 5.1 */
/*
        RunHumanComparator hcmpr = new RunHumanComparator();
        hcmpr.run();
*/


        /* Task 5.2 */
/*
        RunFigure rfigure = new RunFigure();
        rfigure.run();
*/

        /* Task 5.3 5.4 5.5*/
        RunMonitor monitor = new RunMonitor();
        monitor.run();
    }
}
