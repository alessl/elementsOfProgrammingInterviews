package com.leonenko.myinterview.facebook;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 5/27/2017.
 */
public class TaskExecOrder2 {

    public static void main(String[] args) {
        runTasks(getTasksNoCycle());
        runTasks(getTasksWithCycle());
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
        TaskGraph graph = createGraph(tasks);
        if (hasCycle(graph)) {
            return;
        }
        List<List<Task>> tasksByExecOrder = getTasksByExecOrder(graph, tasks);
        executeAll(tasksByExecOrder);
        System.out.println();
    }

    private static boolean hasCycle(TaskGraph graph) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int rootTaskId : graph.getRoots()) {
            if (hasCycle(graph, rootTaskId, visited, new HashSet<>(), stack)) {
                System.out.printf("Detected a cycle: %s", stack);
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(
            TaskGraph graph,
            int taskId,
            Set<Integer> visited,
            Set<Integer> visiting,
            Deque<Integer> stack) {
        visiting.add(taskId);
        stack.push(taskId);
        for (int nextTaskId : graph.getNext(taskId)) {
            if (!visiting.contains(nextTaskId) && !visited.contains(taskId)) {
                if (hasCycle(graph, nextTaskId, visited, visiting, stack)) {
                    return true;
                }
            } else if (visiting.contains(nextTaskId)) {
                buildCycle(stack, nextTaskId);
                return true;
            }
        }
        visiting.remove(taskId);
        visited.add(taskId);
        stack.pop();
        return false;
    }

    private static void buildCycle(Deque<Integer> stack, int nextTaskId) {
        while (stack.peekLast() != nextTaskId) {
            stack.removeLast();
        }
        stack.push(nextTaskId);
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

    private static List<List<Task>> getTasksByExecOrder(
            TaskGraph graph, Map<Integer, Task> tasks) {
        List<List<Task>> tasksByExecOrder = new ArrayList<>();
        for (Set<Integer> parallelTaskIds : getTopSort(graph)) {
            List<Task> batchOfTasks =
                    parallelTaskIds
                            .stream()
                            .map(tasks::get)
                            .collect(toList());
            tasksByExecOrder.add(batchOfTasks);
        }
        return tasksByExecOrder;
    }

    private static List<Set<Integer>> getTopSort(TaskGraph graph) {
        Map<Integer, Set<Integer>> topSort = new TreeMap<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for (int rootTaskId : graph.getRoots()) {
            visit(graph, rootTaskId, visited, 0, topSort);
        }
        return new ArrayList<>(topSort.values());
    }

    private static void visit(
            TaskGraph graph,
            int taskId,
            Map<Integer, Integer> visited,
            int time,
            Map<Integer, Set<Integer>> topSort) {
        visited.put(taskId, time);
        topSort.computeIfAbsent(time, HashSet::new)
                .add(taskId);
        for (int nextTaskId : graph.getNext(taskId)) {
            Integer previousVisitTime = visited.get(nextTaskId);
            if (previousVisitTime == null || previousVisitTime <= time) {
                if (previousVisitTime != null && previousVisitTime <= time) {
                    topSort.get(previousVisitTime)
                            .remove(nextTaskId);
                }
                visit(graph, nextTaskId, visited, time + 1, topSort);
            }
        }
    }

    private static TaskGraph createGraph(Map<Integer, Task> tasks) {
        TaskGraph graph = new TaskGraph();
        for (Task task : tasks.values()) {
            graph.addEdges(task);
        }
        return graph;
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

    private static final class TaskGraph {
        private Set<Integer> roots = new HashSet<>();
        private Map<Integer, Set<Integer>> edges = new HashMap<>();

        private void addEdges(Task task) {
            if (task.hasNoDependencies()) {
                roots.add(task.getId());
            }
            for (int dependencyTaskId : task.getDependencies()) {
                edges.computeIfAbsent(dependencyTaskId, HashSet::new)
                        .add(task.getId());
            }
        }

        Set<Integer> getNext(int taskId) {
            if (!edges.containsKey(taskId)) {
                return Collections.emptySet();
            }
            return edges.get(taskId);
        }

        Set<Integer> getRoots() {
            return roots;
        }
    }
}
