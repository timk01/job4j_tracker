package ru.job4j.stream;

import java.util.Objects;
import java.util.StringJoiner;

public class Student implements Comparable<Student> {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("score=" + score)
                .toString();
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }
}
