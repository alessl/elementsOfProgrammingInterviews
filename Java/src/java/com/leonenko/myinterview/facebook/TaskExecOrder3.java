package com.leonenko.myinterview.facebook;

import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 5/27/2017.
 */
public class TaskExecOrder3 {

    public static void main(String[] args) {
        runTasks(getTasksNoCycle());
        // runTasks(getTasksWithCycle());
    }

    private static Map<Integer, Task> getTasksNoCycle() {
        Task t1 = new Task(1);
        Task t2 = new Task(2);
        t2.addDependency(t1);

        Task t3 = new Task(3);
        t3.addDependency(t1);
        t3.addDependency(t2);

        Task t4 = new Task(4);
        Task t5 = new Task(5);
        t5.addDependency(t4);

        Task t6 = new Task(6);
        t6.addDependency(t5);
        t6.addDependency(t1);

        Task t7 = new Task(7);
        t7.addDependency(t3);

        Task t8 = new Task(8);
        Task t9 = new Task(9);

        Map<Integer, Task> tasks = new HashMap<>();
        tasks.put(t1.getId(), t1);
        tasks.put(t2.getId(), t2);
        tasks.put(t3.getId(), t3);
        tasks.put(t4.getId(), t4);
        tasks.put(t5.getId(), t5);
        tasks.put(t6.getId(), t6);
        tasks.put(t7.getId(), t7);
        tasks.put(t8.getId(), t8);
        tasks.put(t9.getId(), t9);
        return tasks;
    }

    private static Map<Integer, Task> getTasksWithCycle() {
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

        t2.addDependency(t5);

        Task t6 = new Task(6);
        t6.addDependency(t5);

        Task t7 = new Task(7);

        Map<Integer, Task> tasks = new HashMap<>();
        tasks.put(t1.getId(), t1);
        tasks.put(t2.getId(), t2);
        tasks.put(t3.getId(), t3);
        tasks.put(t4.getId(), t4);
        tasks.put(t5.getId(), t5);
        tasks.put(t6.getId(), t6);
        tasks.put(t7.getId(), t7);
        return tasks;
    }

    private static void runTasks(Map<Integer, Task> tasks) {
        System.out.printf("Tasks: %s%n", tasks);
        Map<Integer, Integer> taskOrder = new HashMap<>();
        for (Task task : tasks.values()) {
            if (!taskOrder.containsKey(task.id)) {
                getOrder(task, taskOrder, tasks);
            }
        }
        executeAll(groupTasksByExecOrder(tasks, taskOrder));
        System.out.println();
    }

    private static List<List<Task>> groupTasksByExecOrder(
            Map<Integer, Task> tasks, Map<Integer, Integer> taskOrder) {
        return new ArrayList<>(
                taskOrder.entrySet()
                        .stream()
                        .collect(groupingBy(Map.Entry::getValue, mapTasks(tasks)))
                        .values());
    }

    private static Collector<Map.Entry<Integer, Integer>, ?, List<Task>> mapTasks(
            Map<Integer, Task> tasks) {
        return mapping(Map.Entry::getKey, mapping(tasks::get, toList()));
    }

    private static int getOrder(
            Task task, Map<Integer, Integer> taskOrder, Map<Integer, Task> tasks) {
        int maxDepOrder = 0;
        for (int depId : task.getDependencies()) {
            int depOrder = taskOrder.containsKey(depId)
                    ? taskOrder.get(depId) : getOrder(tasks.get(depId), taskOrder, tasks);
            maxDepOrder = Math.max(maxDepOrder, depOrder);
        }
        taskOrder.put(task.id, maxDepOrder + 1);
        return maxDepOrder + 1;
    }

    private static void executeAll(List<List<Task>> tasksByExecOrder) {
        int batchIndex = 0;
        for (List<Task> batchOfTasks : tasksByExecOrder) {
            System.out.printf("Executing task batch-%s%n", batchIndex++);
            for (Task t : batchOfTasks) {
                t.run();
            }
        }
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
