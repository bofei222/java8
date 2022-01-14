package com.bf;

import java.io.IOException;
import java.nio.file.*;

/**
 * @description:
 * @author: bofei
 * @date: 2021-03-31 23:32
 **/
public class DirectoryWatcherExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("D:/test");

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                        "Event kind:" + event.kind()
                                + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }
    }
}
