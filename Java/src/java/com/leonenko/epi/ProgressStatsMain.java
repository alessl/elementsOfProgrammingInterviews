package com.leonenko.epi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgressStatsMain {

    public static void main(String[] args) throws IOException, URISyntaxException {
        var currDir = Paths.get(
                "/Users/leo/Documents/IdeaProjects/LeoInterview2017/" +
                        "Java/src/java/com/leonenko/epi/");

        var questionStatistics = Map.<Boolean, List<Path>>of(false, new ArrayList<>(),
                true, new ArrayList<>());

        Files.walkFileTree(currDir, new FileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                var fileName = file.getFileName().toFile().getName();

                if (fileName.endsWith("_TODO.java")) {
                    questionStatistics.get(false).add(file);
                } else if (fileName.endsWith(".java")) {
                    questionStatistics.get(true).add(file);
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });

        var finished = questionStatistics.get(true);
        var unfinished = questionStatistics.get(false);

        System.out.println(questionStatistics);
        System.out.println("Finished: " + finished.size());
        System.out.println("Unfinished: " + unfinished.size());
        System.out.println("Total: " + (finished.size() + unfinished.size()));
    }



}
