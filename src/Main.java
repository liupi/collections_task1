import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = readFile().stream()
                .filter(e -> !e.isBlank())
                .map(str -> {
                    String[] arr = str.trim().split(" ");
                    return new Employee(arr[0], arr[1]);
                }).toList();

        System.out.println("Size of collection: " + employees.size());

        System.out.println("\nPrint employees using foreach loop:");
        employees.forEach(System.out::println);

        System.out.println("\nPrint employees using standard loop:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nPrint employees using Iterator interface:");
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            System.out.println(next);
        }

    }

    private static List<String> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/employees.txt"))) {
            return br.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file.");
        }
    }

}