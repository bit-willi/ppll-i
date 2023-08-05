package org.example;

public class Main {

    public static void main(String[] argv) {
        Shell shell = new Shell(argv);
        shell.run();
        shell.dump();
    }
}
