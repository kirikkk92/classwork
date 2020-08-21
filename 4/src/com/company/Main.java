package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Author[] authors = new Author[7];
        Book[] books = new Book[7];

        Author au1 = new Author("au1", (short) 45);
        Author au2 = new Author("au2", (short) 18);
        Author au3 = new Author("au3", (short) 22);
        Author au4 = new Author("au4", (short) 32);
        Author au5 = new Author("au5", (short) 31);
        Author au6 = new Author("au6", (short) 28);
        Author au7 = new Author("au7", (short) 79);

        Book b1 = new Book("b1",300);
        Book b2 = new Book("b2",20);
        Book b3 = new Book("b3",30);
        Book b4 = new Book("b4",55);
        Book b5 = new Book("b5",70);
        Book b6 = new Book("b6",40);
        Book b7 = new Book("b7",99);

        authors [0] = au1;
        authors [1] = au2;
        authors [2] = au3;
        authors [3] = au4;
        authors [4] = au5;
        authors [5] = au6;
        authors [6] = au7;

        books[0] = b1;
        books[1] = b2;
        books[2] = b3;
        books[3] = b4;
        books[4] = b5;
        books[5] = b6;
        books[6] = b7;

        b1.setAuthors(Arrays.asList(au1,au2));
        b2.setAuthors(Arrays.asList(au2));
        b3.setAuthors(Arrays.asList(au3));
        b4.setAuthors(Arrays.asList(au4));
        b5.setAuthors(Arrays.asList(au5));
        b6.setAuthors(Arrays.asList(au6));
        b7.setAuthors(Arrays.asList(au7));

        au1.setBooks(Arrays.asList(b1));
        au2.setBooks(Arrays.asList(b1,b2));
        au3.setBooks(Arrays.asList(b3));
        au4.setBooks(Arrays.asList(b4));
        au5.setBooks(Arrays.asList(b5));
        au6.setBooks(Arrays.asList(b6));
        au7.setBooks(Arrays.asList(b7));



    }
}
