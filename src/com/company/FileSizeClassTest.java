package com.company;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class FileSizeClassTest {

    @org.junit.Test
    public void fileSize() throws Exception {
        String arg[] = new String[1];
        arg[0] = "/Users/malyshev_pavel/Documents/1 семестр/ЭКЗАМЕН МАТАН.zip";
        File file = new File("/Users/malyshev_pavel/Documents/1 семестр/ЭКЗАМЕН МАТАН.zip");
        FileSizeClass fileSizeClass = new FileSizeClass(arg);
        assertEquals(815326.396484375, (double) fileSizeClass.fileSize(file) / 1024, 1e-5);

    }

    @Test
    public void getSize() throws Exception {
        String arg[] = new String[5];
        arg[0] = "/Users/malyshev_pavel/Documents/1 семестр/ЭКЗАМЕН МАТАН.zip";
        arg[1] = "/Users/malyshev_pavel/Documents/1 семестр/История (Мичурин)";
        arg[2] = "/Users/malyshev_pavel/Documents/1 семестр/ФизикаАлина (Козловский)";
        arg[3] = "-h";
        arg[4] = "-c";

        FileSizeClass fileSizeClass = new FileSizeClass(arg);

        assertEquals("Test full", 0, fileSizeClass.getSize());

    }

    @org.junit.Test
    public void humanPrint() throws Exception {
        String arg[] = new String[1];
        arg[0] = "/Users/malyshev_pavel/Documents/1 семестр/История (Мичурин)";
        File file = new File("/Users/malyshev_pavel/Documents/1 семестр/История (Мичурин)");
        FileSizeClass fileSizeClass = new FileSizeClass(arg);
        assertEquals("Test human", "107.2839527130127 MB", fileSizeClass.humanPrint((double) fileSizeClass.fileSize(file), 1024));

    }

}