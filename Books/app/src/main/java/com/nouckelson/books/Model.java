package com.nouckelson.books;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;
    private String author;
    private int logo;
    public Model() { }

    public Model(String name, String author, int logo) {
        this.name = name;
        this.author = author;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
