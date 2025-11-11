package org.example.lesson2_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public Map<String, Integer> getGrades() { return new HashMap<>(grades); }

    public void setCourse(int course) { this.course = course; }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }//Средний балл

    @Override
    public String toString() {
        return String.format("Студент: %s, Группа: %s, Курс: %d, Средний балл: %.2f", name, group, course, getAverageGrade());
    }
    @Override
    public boolean equals(Object o) {
        if (this == 0) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Object.equals(name, student.group);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}
