package com.strafeup.task2.part2.entity;

import java.util.Objects;

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Author: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
