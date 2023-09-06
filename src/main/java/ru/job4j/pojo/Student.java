package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String credentials;
    private String group;
    private LocalDate admission;

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getAdmission() {
        return admission;
    }

    public void setAdmission(LocalDate admission) {
        this.admission = admission;
    }
}
