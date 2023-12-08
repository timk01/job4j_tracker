package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("Learn java", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        System.out.println();
        List<Job> jobs2 = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs2);
        Collections.sort(jobs2);
        System.out.println(jobs2);
        Collections.sort(jobs2, new SortByNameJob());
        System.out.println(jobs2);

        System.out.println();
        jobs.sort(new SortDescByNameJob());
        System.out.println(jobs);
    }
}

