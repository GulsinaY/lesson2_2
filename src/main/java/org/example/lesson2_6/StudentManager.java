package org.example.lesson2_6;

import java.util.Set;

public class StudentManager {
    public static void removeUnderperformingStudent(Set<Student> students) {
        students.removeIf(student -> student.getAverageGraede() < 3.0);
    }//Удаление студентов
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }//Перевод на след.курс
    public static void printStudents(Set<Student> int course) {
        System.out.println("Студенты " + course + " курса:");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }//Студенты курса
    public static void displayAllStudents(Set<Student> students) {
        System.out.println("Все студенты:");
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        List<String> subjects = Arrays.asList(
                "математика", "физика", "патологическая анатомия",
                "физколоидная химия", "фармакология"
        );//Предметы

        //Студенты:
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("математика", 4);
        grades1.put("физика", 3);
        grades1.put("патологическая анатомия", 5);
        grades1.put("физколоидная химия", 4);
        grades1.put("фармакология", 3);
        students.add(new Student("Кильдияров Ф.Х.", "Фарм102А", 1, grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("математика", 2);
        grades2.put("физика", 2);
        grades2.put("патологическая анатомия", 3);
        grades2.put("физколоидная химия", 2);
        grades2.put("фармакология", 3);
        students.add(new Student("Лозовая Е.К.", "Фарм102А", 1, grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("математика", 5);
        grades3.put("физика", 4);
        grades3.put("патологическая анатомия", 5);
        grades3.put("физколоидная химия", 5);
        grades3.put("фармакология", 4);
        students.add(new Student("Синельников П.Т.", "Фарм102А", 1, grades3));

        Map<String, Integer> grades4 = new HashMap<>();
        grades4.put("математика", 3);
        grades4.put("физика", 3);
        grades4.put("патологическая анатомия", 2);
        grades4.put("физколоидная химия", 3);
        grades4.put("фармакология", 2);
        students.add(new Student("Браженко Г.Н.", "Фарм102А", 1, grades4));

        Map<String, Integer> grades5 = new HashMap<>();
        grades5.put("математика", 4);
        grades5.put("физика", 4);
        grades5.put("патологическая анатомия", 4);
        grades5.put("физколоидная химия", 5);
        grades5.put("фармакология", 4);
        students.add(new Student("Лиходед Т.М.", "Фарм102А", 1, grades5));

        System.out.println("Список студентов курса:");
        displayAllStudents(students);

        printStudents(students, 1);// Студенты 1 курса

        removeUnderperformingStudents(students);
        System.out.println("Студенты с средним баллом < 3:");
        displayAllStudents(students);

        promoteStudents(students);
        System.out.println("Переведены на следующий курс:");
        displayAllStudents(students);

        printStudents(students, 2);// Студенты 2 курса
    }
}
