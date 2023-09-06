package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setCredentials("Petrov Petr Petrovich");
        student.setGroup("101A");
        student.setAdmission(LocalDate.of(2001, 11, 1));
        System.out.printf("\tname: %s%n\tgroup: %s%n\tadmission: %s",
                student.getCredentials(), student.getGroup(), student.getAdmission());
    }
}
