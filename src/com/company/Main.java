package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        int res = -1;
        FileSizeClass fileSizeClass = new FileSizeClass(args);
        res = fileSizeClass.getSize();
        System.out.println("Program return " + res);
    }
}
