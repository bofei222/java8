package com.bf.JUC.notify;

/**
 * @description:
 * @author: bofei
 * @date: 2021-08-25 19:48
 **/
public class BookReader implements Runnable{

    Book book;

    public BookReader(Book book) {
        super();
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (book) {
            System.out.println(Thread.currentThread().getName()+" is waiting for the book to be completed: "+book.getTitle());
            try {
                book.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+": Book has been completed now!! you can read it");
        }
    }

}