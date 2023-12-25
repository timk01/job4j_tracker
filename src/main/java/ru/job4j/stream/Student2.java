package ru.job4j.stream;

import java.util.Objects;
import java.util.StringJoiner;

public class Student2 implements Comparable<Student2> {
    private int score;

    public Student2(int score) {
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
        Student2 student = (Student2) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student2.class.getSimpleName() + "[", "]")
                .add("score=" + score)
                .toString();
    }

    @Override
    public int compareTo(Student2 o) {
        return Integer.compare(this.score, o.score);
    }
}
