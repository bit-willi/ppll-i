package org.example;

public class CoreLlI {
    private Table ruleTable;
    private String inBuffer;

    public CoreLlI(Table ruleTable, String inBuffer) {
        this.ruleTable = ruleTable;
        this.inBuffer = inBuffer;
    }

    public void run() {
        System.out.println("Hello from core!");
    }
}
