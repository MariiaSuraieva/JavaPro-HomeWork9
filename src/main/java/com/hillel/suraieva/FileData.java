package com.hillel.suraieva;

public class FileData {
    String name, path;
    int sizeBytes;

    public FileData(String name, String path, int sizeBytes) {
        this.name = name;
        this.path = path;
        this.sizeBytes = sizeBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(int sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", sizeBytes=" + sizeBytes +
                '}'+"\n";
    }
}
