package com.bf.io.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author bofei
 * @date 2018/9/4 14:26
 */
public class FindJavaFiles {

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get("F:/path0");

        long l = System.currentTimeMillis();
        Files.walkFileTree(startingDir, new FindJavaVisitor());
//        walkFiles();
        System.out.println(System.currentTimeMillis() - l);
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
//            if (file.toString().endsWith(".java")) {
                System.out.println(path.toString() + " " + System.currentTimeMillis());
//            }

            return FileVisitResult.CONTINUE;
        }



    }
    public static void walkFiles(){
        Path path = Paths.get("F:\\path0");
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.out.println(exc);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}