package org.example;

import java.util.ArrayDeque;

public class Shell {
    private ArrayDeque<String> argv;
    private String grammar_path;
    private String in_buffer_path;

    public Shell(String[] args) {
        super();

        this.argv = new ArrayDeque<String>();

        for (String arg : args) {
            this.argv.add(arg);
        }
    }

    public void run() {
        while(this.argv.size() > 0) {
            String flag = this.argv.remove();

            switch (flag) {
                case "-h":
                    this.showUsage();
                    System.exit(0);
                    break;

                case "-grammar":
                    if (this.argv.size() == 0) {
                        System.out.printf("ERROR: No grammar file provided for flag %s\n", flag);
                        System.exit(0);
                    }

                    String arg = this.argv.remove();
                    this.grammar_path = arg;
                    break;

                default:
                    this.in_buffer_path = flag;
                    break;
            }
        }
    }

    public void dump() {
        System.out.println("--- DUMP ---");
        System.out.println(this.grammar_path);
        System.out.println(this.in_buffer_path);
        System.out.println("--- DUMP END ---");
    }

    public String getGrammarPath() {
        return this.grammar_path;
    }

    public String getInBufferPath() {
        return this.in_buffer_path;
    }

    public void showUsage() {
        System.out.printf("Usage: java -jar bin.jar [OPTIONS] [IN_BUFFER_PATH]\n");
        System.out.printf("OPTIONS:\n");
        System.out.printf("\t-grammar <path> Path to grammar declaration file\n");
        System.out.printf("\t-h Print this message\n");
    }
}
