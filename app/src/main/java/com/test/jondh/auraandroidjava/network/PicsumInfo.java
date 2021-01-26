package com.test.jondh.auraandroidjava.network;

public class PicsumInfo {
    private String id;
    private String author;
    private int width;
    private int height;
    private String url;
    private String download_url;

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public String getDownloadUrl() {
        return download_url;
    }

    @Override
    public String toString() {
        return "PicsumInfo{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                ", download_url='" + download_url + '\'' +
                '}';
    }
}
