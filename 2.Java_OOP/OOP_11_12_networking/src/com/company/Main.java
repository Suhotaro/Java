package com.company;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;


import java.net.*;
import java.util.Properties;

import Database.DatabaseRun;
import Net.*;
import NetHTMLRun.NetHTMLRun;
import Server.ServerRun;



public class Main {

    public static void main(String[] args) {


/*
        Properties prop = System.getProperties();
        prop.list(System.out);
*/

/*
        Net net = new Net();
        net.run2();
*/

/*
        NetHTMLRun net_html_run = new NetHTMLRun();
        net_html_run.run();
*/

/*
        ServerRun server_run = new ServerRun();
        server_run.run();
*/

        DatabaseRun database_run = new DatabaseRun();
        database_run.run();
    }
}
