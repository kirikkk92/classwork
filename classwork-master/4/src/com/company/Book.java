package com.company;

import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }
}
