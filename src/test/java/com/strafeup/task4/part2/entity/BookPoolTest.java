package com.strafeup.task4.part2.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BookPoolTest {

    BookPool bookPool;

    @Parameterized.Parameter(0)
    public Book[] expected;

    @Parameterized.Parameter(1)
    public Book[] expected1;

    @Parameterized.Parameter(2)
    public Book[] expected2;

    @Parameterized.Parameter(3)
    public Book[] expected3;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Book[] books1 = new Book[]{
                new Book("2", new Author("Author1"), Publisher.PUBLISHER_3, 2011, 223, 0.59),
                new Book("5", new Author("Author1"), Publisher.PUBLISHER_1, 2009, 287, 0.15),
                new Book("9", new Author("Author1"), Publisher.PUBLISHER_1, 2018, 26243, 0.35),
                null, null, null, null, null, null, null
        };
        Book[] books2 = new Book[]{new Book("4", new Author("Author0"), Publisher.PUBLISHER_1, 2013, 243, 0.78),

                new Book("5", new Author("Author1"), Publisher.PUBLISHER_1, 2009, 287, 0.15),
                new Book("6", new Author("Author0"), Publisher.PUBLISHER_1, 2010, 217, 0.13),
                new Book("9", new Author("Author1"), Publisher.PUBLISHER_1, 2018, 26243, 0.35),
                null, null, null, null, null, null
        };
        Book[] books3 = new Book[]{new Book("0", new Author("Author0"), Publisher.PUBLISHER_3, 2015, 263, 0.21),
                new Book("1", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 221, 0.53),
                new Book("2", new Author("Author1"), Publisher.PUBLISHER_3, 2011, 223, 0.59),
                new Book("4", new Author("Author0"), Publisher.PUBLISHER_1, 2013, 243, 0.78),
                new Book("7", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 228, 0.60),
                new Book("8", new Author("Author2"), Publisher.PUBLISHER_3, 2015, 251, 0.98),
                new Book("9", new Author("Author1"), Publisher.PUBLISHER_1, 2018, 26243, 0.35),
                null, null, null

        };
        Book[] books4 = new Book[]{new Book("4", new Author("Author0"), Publisher.PUBLISHER_1, 2013, 243, 0.78),
                new Book("5", new Author("Author1"), Publisher.PUBLISHER_1, 2009, 287, 0.15),
                new Book("6", new Author("Author0"), Publisher.PUBLISHER_1, 2010, 217, 0.13),
                new Book("9", new Author("Author1"), Publisher.PUBLISHER_1, 2018, 26243, 0.35),
                new Book("1", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 221, 0.53),
                new Book("7", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 228, 0.60),
                new Book("0", new Author("Author0"), Publisher.PUBLISHER_3, 2015, 263, 0.21),
                new Book("2", new Author("Author1"), Publisher.PUBLISHER_3, 2011, 223, 0.59),
                new Book("3", new Author("Author2"), Publisher.PUBLISHER_3, 2009, 205, 0.26),
                new Book("8", new Author("Author2"), Publisher.PUBLISHER_3, 2015, 251, 0.98),

        };

        return Arrays.asList(new Object[][]{
                {books1, books2, books3, books4},
        });
    }


    @Before
    public void setUp() {
        Book[] books = new Book[]{new Book("0", new Author("Author0"), Publisher.PUBLISHER_3, 2015, 263, 0.21),
                new Book("1", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 221, 0.53),
                new Book("2", new Author("Author1"), Publisher.PUBLISHER_3, 2011, 223, 0.59),
                new Book("3", new Author("Author2"), Publisher.PUBLISHER_3, 2009, 205, 0.26),
                new Book("4", new Author("Author0"), Publisher.PUBLISHER_1, 2013, 243, 0.78),
                new Book("5", new Author("Author1"), Publisher.PUBLISHER_1, 2009, 287, 0.15),
                new Book("6", new Author("Author0"), Publisher.PUBLISHER_1, 2010, 217, 0.13),
                new Book("7", new Author("Author2"), Publisher.PUBLISHER_2, 2011, 228, 0.60),
                new Book("8", new Author("Author2"), Publisher.PUBLISHER_3, 2015, 251, 0.98),
                new Book("9", new Author("Author1"), Publisher.PUBLISHER_1, 2018, 26243, 0.35),
        };
        bookPool = new BookPool(books);
    }

    @Test
    public void getBooksByAuthor() {
        assertArrayEquals(expected, bookPool.getBooksByAuthor("Author1"));
    }

    @Test
    public void getBooksByPublisher() {
        assertArrayEquals(expected1, bookPool.getBooksByPublisher("PUBLISHER_1"));
    }

    @Test
    public void getBooksPublishedAfterCertainYear() {
        assertArrayEquals(expected2, bookPool.getBooksPublishedAfterCertainYear(2010));
    }

    @Test
    public void sortByPublisher() {
        assertArrayEquals(expected3, bookPool.sortByPublisher());
    }
}