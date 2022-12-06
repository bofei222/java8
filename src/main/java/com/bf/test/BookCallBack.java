package com.bf.test;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:10
 **/
public class BookCallBack implements CallBack{

    private String bookName;
    private String author;

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void execute() {
        this.bookName = "The little prince";
        this.author = "Antoine";
        System.out.println("---------callback实现类 bookName=="+ this.bookName +"      author==="+this.author);
    }

}
