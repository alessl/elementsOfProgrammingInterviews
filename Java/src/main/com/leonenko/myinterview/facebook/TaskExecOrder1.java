package com.leonenko.myinterview.facebook;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 5/27/2017.
 */
public class TaskExecOrder1 {

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

    private static void runTasks(Queue<Task> tasks) {
        System.out.printf("Tasks: %s%n", tasks);
        List<List<Task>> tasksByExecOrder = getTasksByExecOrder(tasks);
        executeAll(tasksByExecOrder);
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

    private static List<List<Task>> getTasksByExecOrder(Queue<Task> tasks) {
        List<List<Task>> tasksByExecOrder = new ArrayList<>();
        Set<Integer> finishedTasks = new HashSet<>();
        while (!tasks.isEmpty()) {
            List<Task> batchOfTasks = new ArrayList<>();
            int numTasks = tasks.size();
            while (numTasks-- > 0) {
                Task t = tasks.poll();
                if (isReadyToRun(finishedTasks, t)) {
                    batchOfTasks.add(t);
                } else {
                    tasks.add(t);
                }
            }
            for (Task t : batchOfTasks) {
                finishedTasks.add(t.getId());
            }
            tasksByExecOrder.add(batchOfTasks);
        }
        return tasksByExecOrder;
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
