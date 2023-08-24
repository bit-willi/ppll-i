package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Grammar {
    private String grammar_path;
    private StringBuffer source;
    private Table table;

    public Grammar(String grammar_path) {
        super();

        this.source = new StringBuffer();
        this.grammar_path = grammar_path;

        this.table = new Table();
    }

    private void loadSource() {
        try {
            FileInputStream fstream = new FileInputStream(this.grammar_path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null)   {
                this.source.append(strLine);
                this.source.append('\n');
            }

            fstream.close();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: File not found %s: %s", this.grammar_path, e.getMessage());
        } catch (IOException e) {
            System.out.printf("ERROR: IOException : %s", this.grammar_path, e.getMessage());
        }
    }

    private Character nextCharacter() {
        if (this.source.length() == 0) {
            return null;
        }

        Character c = this.source.charAt(0);
        this.source.deleteCharAt(0);

        return c;
    }

    public void tokenize() {
        this.loadSource();

        ArrayList<String> vt = new ArrayList<>();
        ArrayList<String> vn = new ArrayList<>();

        Character c = this.nextCharacter();
        StringBuffer sb = new StringBuffer();
        Integer ruleCount = 1;

        /**
         * 0 - Vt
         * 1 - Vn
         * 2 - Pipe
         * 3 - Arrow
         */
        Integer buffType = 0;

        while(c != null) {
            //System.out.printf("%c - %s \n",c, c.toString().equals(System.getProperty("line.separator")));

            if (Character.isUpperCase(c)) {
                sb.append(c);
                buffType = 0;
            }

            if (c.equals('\'') && buffType == 0) {
                sb.append(c);
                buffType = 0;
            }

            if (Character.isLowerCase(c)) {
                sb.append(c);
                buffType = 1;
            }

            //TODO: Make an array with special symbols
            if (c.equals('(') || c.equals(')') || c.equals('&')) {
                sb.append(c);
                buffType = 1;
            }

            if (c.equals('-')) {
                c = this.nextCharacter();

                if (c.equals('>')) {
                    //System.out.println('e');
                }
            }

            if ((Character.isSpaceChar(c) || c.equals('\n')) && sb.length() > 0) {
                if (buffType == 0) {
                    vt.add(sb.toString());
                }

                if (buffType == 1) {
                    vn.add(sb.toString());
                }

                sb.delete(0, sb.length());
            }

            c = this.nextCharacter();
        }

        System.out.println(vt);
        System.out.println(vn);

        //for (int i = 0; i < this.source.length(); i++) {
            //Character s = this.source.charAt(i);
            //System.out.println(s);
        //}
    }

    public Table getGrammarTable() {
        return this.table;
    }

    public void run() {
        this.table.insertInTable("E", "id", "1");
        this.table.insertInTable("E", "(", "1");
        this.table.insertInTable("E'", ")", "3");
        this.table.insertInTable("E'", "+", "2");
        this.table.insertInTable("T", "id", "4");
        this.table.insertInTable("T", "(", "4");
        this.table.insertInTable("T'", ")", "6");
        this.table.insertInTable("T'", "+", "6");
        this.table.insertInTable("T'", "*", "5");
        this.table.insertInTable("T'", "\n", "6");
        this.table.insertInTable("F", "id", "8");
        this.table.insertInTable("F", "(", "7");
    }
}
