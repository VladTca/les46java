import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Task> allTasks = getProgrammers().stream()
                .flatMap(p -> p.tasks().stream())
                .toList();
        allTasks.forEach(System.out::println);

        System.out.println("=========================");

        List<Task> allTasks2 = getProgrammers().stream()
                .filter(p -> p.city().equalsIgnoreCase("Berlin"))
                .flatMap(p -> p.tasks().stream())
                .filter(p -> p.daysInProcessing() > 5 && !p.status().equalsIgnoreCase("done"))
                .toList();
        allTasks2.forEach(System.out::println);


    }

    static List<Programmer> getProgrammers() {
        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("Programmer1", "Berlin", getTasks()));
        programmers.add(new Programmer("Programmer2", "Munchen", getTasks()));
        programmers.add(new Programmer("Programmer3", "Berlin", getTasks()));
        programmers.add(new Programmer("Programmer4", "Hamburg", getTasks()));
        programmers.add(new Programmer("Programmer5", "Berlin", getTasks()));

        return programmers;
    }

    private static List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Task1", "done", 5));
        tasks.add(new Task(2, "Task2", "In progress", 3));
        tasks.add(new Task(3, "Task3", "done", 2));
        tasks.add(new Task(4, "Task4", "In progress", 1));
        tasks.add(new Task(5, "Task5", "done", 10));
        tasks.add(new Task(6, "Task6", "In progress", 6));
        tasks.add(new Task(7, "Task7", "done", 5));
        return tasks;
    }
}