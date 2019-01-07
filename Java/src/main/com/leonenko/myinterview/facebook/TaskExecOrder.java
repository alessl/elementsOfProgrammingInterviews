package com.leonenko.myinterview.facebook;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 5/27/2017.
 */
public class TaskExecOrder {

    public static void main(String[] args) {
        Queue<Task> tasks = getTasks();
        runTasks(tasks);
    }

    private static Queue<Task> getTasks() {
        Task t1 = new Task(1);
        Task t2 = new Task(2);
        t2.addDependency(t1);

        Task t3 = new Task(3);
        t3.addDependency(t1);
        t3.addDependency(t2);

        Task t4 = new Task(4);
        Task t5 = new Task(5);
        t5.addDependency(t3);
        t5.addDependency(t4);

        Task t6 = new Task(6);
        t6.addDependency(t5);

        Task t7 = new Task(7);
        t7.addDependency(t3);

        Task t8 = new Task(8);
        Task t9 = new Task(9);

        return new LinkedList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9));
    }

    private static void runTasks(Queue<Task> allTasks) {
        Set<Integer> finishedTasks = new HashSet<>();
        while (allTasks.size() > finishedTasks.size()) {
            System.out.println(
                    "Remaining tasks: "
                            + allTasks.stream()
                                .filter(t -> !finishedTasks.contains(t.getId()))
                                .collect(toList()));
            for (Task t : getReadyToRunTasks(allTasks, finishedTasks)) {
                t.run();
                finishedTasks.add(t.getId());
            }
        }
    }

    private static List<Task> getReadyToRunTasks(
            Queue<Task> allTasks, Set<Integer> finishedTasks) {
        List<Task> readyTasks = new ArrayList<>();
            for (Task t : allTasks) {
            if (isReadyToRun(finishedTasks, t) && !finishedTasks.contains(t.getId())) {
                readyTasks.add(t);
            }
        }
        return readyTasks;
    }

    private static boolean isReadyToRun(Set<Integer> finishedTasks, Task t) {
        return t.hasNoDependencies() || finishedTasks.containsAll(t.getDependencies());
    }

    private static final class Task {
        private final int id;
        private final Map<Integer, Task> dependencies = new HashMap<>();

        Task(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }

        Set<Integer> getDependencies() {
            return dependencies.keySet();
        }

        boolean hasNoDependencies() {
            return dependencies.isEmpty();
        }

        void addDependency(Task dependencyTask) {
            dependencies.put(dependencyTask.getId(), dependencyTask);
        }

        void run() {
            System.out.println("Run task " + id);
        }

        @Override
        public String toString() {
            return id + (dependencies.isEmpty() ? "" : ":" + dependencies.keySet());
        }
    }
}
