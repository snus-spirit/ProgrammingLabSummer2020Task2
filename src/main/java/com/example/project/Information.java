package com.example.project;

import java.text.SimpleDateFormat;
import java.io.File;
import java.util.Date;

public class Information {
    private String name;
    private long size;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private long modification;

    Information(File file) {
        name = file.getName();
        size = file.length();
        canRead = file.canRead();
        canWrite = file.canWrite();
        canExecute = file.canExecute();
        modification = file.lastModified();
    }
    public String getName(){
        return this.name;
    }
    public String getSize(boolean humanType){
        String[] chars = new String[]{"Б", "КБ", "МБ", "ГБ"};
        double fSize = size;
        int counter = 0;
        if (humanType) {
            while (fSize > 1024){
                fSize /= 1024;
                counter++;
            }
        }
        return (fSize + chars[counter]);
    }
    public String getModification(boolean humanType){
        if (humanType) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            return sdf.format(modification);
        }
        return Long.toString(modification);

    }

    public String getPermissions(boolean humanType) {
        return "";
    }
}
