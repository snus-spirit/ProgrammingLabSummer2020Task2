package com.example.project;

import java.io.*;

public class Main {
    public static void main(String[] args) {
       // args = new String[] {"-l", "C:\\Users\\kk\\Desktop\\31"};
        Flags flags = new Flags();
        File output = flags.Arguments(args);
        try(PrintWriter pw = (output == null) ? new PrintWriter(System.out)
                : new PrintWriter(output, "Cp1251")) {
            Printer.printLs(pw, flags);
        } catch (Exception ex) {
            System.out.println("Unexpected exception");
        }
    }
}