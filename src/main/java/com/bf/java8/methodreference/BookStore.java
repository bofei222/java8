package com.bf.java8.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author bofei
 * @Date 2019/7/8 10:29
 * @Description
 */
public class BookStore {
    private List<Book> books = new ArrayList<>();

    public List<Book> list(Predicate<Book> filter) {
        List<Book> result = new ArrayList<>();
        books.forEach(book -> { if (filter.test(book)) result.add(book); });
        return result;
    }
    // 省略部分代码

    public static void main(String[] args) {
//        List<Book> books = bookStore.list(BookFilter::booksOfMartinFowler);
    }
}

class BookFilter {
    public static boolean booksOfMartinFowler(Book book) {
        return "Martin Fowler".equals(book.author);
    }
}