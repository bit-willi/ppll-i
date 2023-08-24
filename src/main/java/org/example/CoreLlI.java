package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoreLlI {
    private Table ruleTable;
    private StringBuffer inBuffer;

    public CoreLlI(Table ruleTable, String inBuffer) {
        this.inBuffer = new StringBuffer();
        this.ruleTable = ruleTable;
        this.loadSource(inBuffer);
    }

    private void loadSource(String inBuffer) {
        try {
            FileInputStream fstream = new FileInputStream(inBuffer);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null)   {
                this.inBuffer.append(strLine);
                this.inBuffer.append('\n');
            }

            fstream.close();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: File not found %s: %s", this.inBuffer, e.getMessage());
        } catch (IOException e) {
            System.out.printf("ERROR: IOException : %s", this.inBuffer, e.getMessage());
        }
    }

    public void run() {
        System.out.println("core");
        System.out.println(this.inBuffer);
    }
}
