package com.company;

import java.io.File;


public class FileSizeClass {
    static boolean c = false;
    static boolean h = false;
    static boolean si = false;
    String arguments[];


    public FileSizeClass(String[] args) {
        for (String arg : args) {
            if (arg.equals("-h")) {
                h = true;
            }
            if (arg.equals("-c")) {
                c = true;
            }
            if (arg.equals("--si")) {
                si = true;
            }
        }
        arguments = args;
    }

    public int getSize() {
        String result = "";
        Double total_size = 0.0;
        Double file_size = 0.0;
        int base = 1024;

        if (si) {
            base = 1000;
        }

        for (String file_name : arguments) {
            if (!file_name.equals("-h") && !file_name.equals("-c") && !file_name.equals("--si")) {
                File file = new File(file_name);

                if (!file.exists()) {
                    System.out.println("ERROR: File " + file_name + " doesn't exist");
                    return 1;
                }

                file_size = (double) fileSize(file);

                if (c) {
                    total_size = total_size + file_size;
                }

                if (h) {
                    result = result + "\nFile " + file_name + " size: " + humanPrint(file_size, base);
                } else {
                    result = result + "\nFile " + file_name + " size: " + file_size / base;
                }
            }

        }

        System.out.println(result);

        if (c) {
            if (h) {
                System.out.println("Total size: " + humanPrint(total_size, base));
            } else {
                System.out.println("Total size: " + total_size / base);
            }
        }

        return 0;
    }

    public long fileSize(File file) {
        long size = 0;

        if (file.isFile()) {
            size = file.length();
        } else {
            for (File item : file.listFiles()) {
                if (item.isFile()) {
                    size = size + item.length();
                } else {
                    size = size + fileSize(item);
                }
            }
        }
        return size;
    }

    public String humanPrint(Double fileSize, int base) {
        Double kilobytes = fileSize / base;
        Double megabytes = kilobytes / base;
        Double gigabytes = megabytes / base;

        if (gigabytes >= 1.0) {
            return gigabytes + " GB";
        } else if (megabytes >= 1.0) {
            return megabytes + " MB";
        } else if (kilobytes >= 1.0) {
            return kilobytes + " KB";
        } else {
            return fileSize + " B";
        }
    }
}
