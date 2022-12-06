package com.bf.JUC.thread.completableFuture;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-05 14:10
 **/
public class MainTest {
    private Instant start;

    public static void main(String[] args) {

        MainTest main = new MainTest();
        main.start();
    }

    public void start() {
        String req1 = "http://localhost:8080/testing";
        String req2 = "http://127.0.0.1:8095/testing2";
        String req3 = "http://127.0.0.1:8096/testing2";

        ExecutorService exec = Executors.newCachedThreadPool();

        start = Instant.now();
        CompletableFuture<String> comp1 = CompletableFuture.supplyAsync(() -> doReq(req1), exec);
        CompletableFuture<String> comp2 = CompletableFuture.supplyAsync(() -> doReq(req2), exec);
        CompletableFuture<String> comp3 = CompletableFuture.supplyAsync(() -> doReq(req3), exec);

        List<CompletableFuture<String>> completables = Arrays.asList(comp1, comp2,comp3);

        System.out.println("Waiting completables");

        List<String> r = getAllCompleted(completables, 3, TimeUnit.SECONDS);
        Instant end = Instant.now();
        System.out.println(" Took: " + DurationFormatUtils.formatDurationHMS(Duration.between(start, end).toMillis()));

        System.out.println(r.size());
        r.forEach(System.out::println);
        exec.shutdown();
    }

    public String doReq(String request) {
        if (request.contains("localhost")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "response1";
        }

        if (request.contains("8096")) {
            try {
                Thread.sleep(2800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "response3";
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "response2";
    }

    public <T> List<T> getAllCompleted(List<CompletableFuture<T>> futuresList, long timeout, TimeUnit unit) {
        CompletableFuture<Void> allFuturesResult = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        try {
            allFuturesResult.get(timeout, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return futuresList.stream()
                .filter(future -> future.isDone() && !future.isCompletedExceptionally()) // keep only the ones completed
                .map(CompletableFuture::join) // get the value from the completed future
                .collect(Collectors.<T>toList()); // collect as a list
    }
}
