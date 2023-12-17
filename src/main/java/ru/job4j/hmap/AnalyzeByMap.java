package ru.job4j.hmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int overallScore = 0;
        int totalElements = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                overallScore += subject.score();
                totalElements++;
            }
        }
        return !pupils.isEmpty() ? (double) overallScore / totalElements : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        int overallScore = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                overallScore += subject.score();
            }
            labelList.add(new Label(pupil.name(), (double) overallScore / subjects.size()));
            overallScore = 0;
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> temp = countOverallScoreBySubject(pupils);
        for (String subject : temp.keySet()) {
            labelList.add(new Label(subject, (double) temp.get(subject) / pupils.size()));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        int overallScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                overallScore += subject.score();
            }
            labelList.add(new Label(pupil.name(), overallScore));
            overallScore = 0;
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> temp = countOverallScoreBySubject(pupils);
        for (String subject : temp.keySet()) {
            labelList.add(new Label(subject, temp.get(subject)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    private static Map<String, Integer> countOverallScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.merge(
                        subject.name(),
                        subject.score(),
                        (oldScore, newScore) -> oldScore + subject.score()
                );
            }
        }
        return temp;
    }
}