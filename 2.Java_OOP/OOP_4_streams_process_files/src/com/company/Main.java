package com.company;
import MyFile.MyFile;
import FindFiles.FindFiles;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        /*
        MyFile mfile = new MyFile();
        mfile.run();
        */


        FindFiles find_files = new FindFiles();
        find_files.run();
    }
}
