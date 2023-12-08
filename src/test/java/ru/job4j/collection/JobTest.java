package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

public class JobTest {
    @Test
    public void whenComparatorByDescName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isNegative();
    }

    @Test
    public void whenComparatorByAscName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    public void whenComparatorByDescPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    public void whenComparatorByAscPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isNegative();
    }


    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isNegative();
    }

    @Test
    public void whenComparatorByDescEqualNamesAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    public void whenComparatorByDescEqualPriorityAndDescEqualNames() {
        Comparator<Job> cmpPriorityName = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpPriorityName.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isEven();
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    public void whenComparatorByAscPriorityAndDescName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isNegative();
    }

    @Test
    public void whenComparatorByAscEqualsPriorityAndDescName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isNegative();
    }
}