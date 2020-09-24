package com.example.project;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Printer {

    public static void printLs(Writer stream, Flags flags) throws IOException {
        if (flags.getFile().isFile()) {
            stream.append(new fileInformation(flags.getFile()).toString());
        } else {
            File[] files = arraySort(Objects.requireNonNull(flags.getFile().listFiles()), flags.getReverseFlag());
            if (flags.getLongFlag()) {
                for (File line : files) {
                    stream.append(new fileInformation(line).toString(flags.getHumanFlag()));
                    if (!line.equals(files[files.length - 1])) stream.append("\n");
                }
            } else {
                for (File line : files) {
                    stream.append(line.getName());
                    if (!line.equals(files[files.length - 1])) stream.append(" ");
                }
            }
        }
    }

    static File[] arraySort(File[] files, boolean reverseFlag) {
        Arrays.sort(files);
        if (reverseFlag) Collections.reverse(Arrays.asList(files));
        return files;
    }
}
