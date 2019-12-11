package com.strafeup.task2.part2.entity;

import java.util.Comparator;
import java.util.Objects;

public class Book {
    private String name;
    private Author author;
    private Publisher publisher;
    private int year;
    private int size;
    private double price;

    public Book(String name, Author author, Publisher publisher, int year, int size, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author.toString() +
                ", publisher=" + publisher +
                ", year=" + year +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
                size == book.size &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                publisher == book.publisher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publisher, year, size, price);
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
