package com.ali.HostelManagement;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File obj = new File("Hello.txt");
        try {
            if (obj.createNewFile()) {
                System.out.println("File name: " + obj.getName());
                System.out.println("Absolute path: " + obj.getAbsolutePath());
                System.out.println("Writeable: " + obj.canWrite());
                System.out.println("Readable: " + obj.canRead());
                System.out.println("File size in bytes: " + obj.length());
            } else {
                System.out.println("The file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
