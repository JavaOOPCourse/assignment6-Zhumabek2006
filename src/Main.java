import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("1", new Student("Alice", 3.5, 20));
        students.put("2", new Student("Bob", 3.8, 22));
        students.put("3", new Student("Charlie", 3.5, 21));
        students.put("4", new Student("David", 4.0, 19));
        students.put("5", new Student("Eve", 3.9, 23));

        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("=== All Students ===");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println("\nFind by ID 3: " + students.get("3"));

        // TODO: Удали одного студента по ID
        students.remove("2");
        System.out.println("After removing ID 2, student count: " + students.size());

        // TODO: Обнови GPA у одного студента
        if (students.containsKey("5")) {
            students.get("5").setGpa(4.0);
        }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> studentList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentList);
        System.out.println("\nSorted by GPA (ascending):");
        studentList.forEach(System.out::println);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by Name (ascending):");
        studentList.forEach(System.out::println);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> topStudents = new ArrayList<>(students.values());
        topStudents.sort(Comparator.comparing(Student::getGpa).reversed());
        for (int i = 0; i < Math.min(3, topStudents.size()); i++) {
            System.out.println(topStudents.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaMap = new HashMap<>();
        for (Student s : students.values()) {
            gpaMap.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaMap.get(s.getGpa()).add(s.getName());
        }
        for (Map.Entry<Double, List<String>> entry : gpaMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + " -> " + String.join(", ", entry.getValue()));
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course java = new Course("Java OOP");
        Course math = new Course("Calculus");
        
        courseMap.put(java, Arrays.asList(students.get("1"), students.get("3")));
        courseMap.put(math, Arrays.asList(students.get("4"), students.get("5")));

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        List<Student> task5List = new ArrayList<>(students.values());
        task5List.sort(
            Comparator.comparing(Student::getGpa).reversed()
                      .thenComparing(Student::getName)
        );
        task5List.forEach(System.out::println);
    }
}



