package com.example.project;

import java.io.File;
import java.util.Objects;

public class Flags {

    private boolean humanFlag;
    private boolean longFlag;
    private boolean reverseFlag;
    private File file;

    public File Arguments(String[] args) {

        File output = null;
        if (args.length < 1) throw new NullPointerException("Enter the arguments");

        for (String flag : args) {
            switch (flag) {
                case ("-h"):
                    setHumanFlag(true);
                    break;
                case ("-l"):
                    setLongFlag(true);
                    break;
                case ("-o"):
                    if (flag.equals(args[args.length - 2])
                            && !"-o".equals(args[args.length - 3]))
                        throw new NullPointerException("Enter output file name");
                    output = new File(args[args.length - 2]);
                    break;
                case ("-r"):
                    setReverseFlag(true);
                    break;
                default:
                    if (flag.equals(args[args.length - 1]))
                        setFile(new File(flag));
                    else if (output != null && flag.equals(args[args.length - 2]))
                        break;
                    else
                        throw new IllegalArgumentException("Unexpected argument");
            }
        }
        if (this.file == null)
            throw new IllegalArgumentException("Enter name of directory or file");
        if (!getFile().exists())
            throw new IllegalArgumentException("Non-existent directory or file name");
        return output;
    }

    File getFile() {
        return Objects.requireNonNull(this.file);
    }

    public void setFile(File file1) {
        this.file = file1;
    }

    boolean getReverseFlag() {
        return this.reverseFlag;
    }

    boolean getLongFlag() {
        return this.longFlag;
    }

    public boolean getHumanFlag() {
        return this.humanFlag;
    }

    public void setHumanFlag(boolean bol) {
        this.humanFlag = bol;
    }

    public void setReverseFlag(boolean bol) {
        this.reverseFlag = bol;
    }

    public void setLongFlag(boolean bol) {
        this.longFlag = bol;
    }
}
