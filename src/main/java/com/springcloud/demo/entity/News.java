package com.springcloud.demo.entity;


public class News {


    private String title;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
