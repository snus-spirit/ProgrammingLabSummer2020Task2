package com.example.project;

import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.text.SimpleDateFormat;

public class fileInformation {

    private File name;
    private long size;
    private String lastModified;
    private int permissions = 0b000;

    fileInformation(File file) {
        setName(file);
        setSize(file.isDirectory()? getDirectorySize(file) : file.length());
        setPermissions(file);
        setLastModified(file);//Есть ли смысл писать чз сеттеры или лучше напрямую?
        /*
        this.name = file.getName();
        this.size = file.isDirectory()? getDirectorySize(file) : file.length();
        if (file.canRead()) this.permissions |= 0b001;
        if (file.canWrite()) this.permissions |= 0b010;
        if (file.canExecute()) this.permissions |= 0b100;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        this.lastModified = dateFormat.format(file.lastModified());
        */
    }

    private Long getDirectorySize(File directory) {
        long size = 0;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) getDirectorySize(file);
            else size += file.length();
        }
        return size;
    }

    private String transformSize(){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        long hSize = this.size;
        String[] postfix = new String[]{"Б", "К", "М", "Г"};
        while (hSize >= 1024){
            hSize /= 1024;
            counter++;
        }
        sb.append(hSize).append(postfix[counter]);
        return sb.toString();
    }

    private String transformPermissions() {
        StringBuilder sb = new StringBuilder();
        sb.append((this.permissions & 0b100) != 0 ? "r" : "-");
        sb.append((this.permissions & 0b010) != 0 ? "w" : "-");
        sb.append((this.permissions & 0b001) != 0 ? "x" : "-");
        return sb.toString();
    }

    int getPermissions(){
        return this.permissions;
    }

    String getLastModified(){
        return this.lastModified;
    }

    long getSize(){
        return this.size;
    }

    File getName(){
        return this.name;
    }

    void setName(File value){
        this.name = value;
    }

    void setPermissions(File file){
        if (file.canRead()) this.permissions |= 0b001;
        if (file.canWrite()) this.permissions |= 0b010;
        if (file.canExecute()) this.permissions |= 0b100;
    }

    void setSize(long value){
        this.size = value;
    }

    void setLastModified (File file) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        this.lastModified = dateFormat.format(file.lastModified());
    }

    public String toString(boolean humanType){
        if (humanType)
            return transformPermissions() + " " + this.lastModified + " " + transformSize() + " " + this.name.getName();
        else return this.permissions + "-- " + this.lastModified + " " + this.size + " " + this.name.getName();
    }

    @Override
    public String toString() {
        return this.permissions + "-- " + this.lastModified + " " + this.size + " " + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        fileInformation lll = (fileInformation) obj;
        return lll.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.size * this.name.length());
    }
}
