package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        double count = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum = 0D;
        double count = 0D;
        List<Label> scoreByPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            scoreByPupil.add(new Label(pupil.name(), sum / count));
            sum = 0D;
            count = 0D;
        }
        return scoreByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMap.put(subject.name(),
                            tempMap.getOrDefault(subject.name(), 0) +  subject.score());
            }
        }
        for (String key : tempMap.keySet()) {
            label.add(new Label(key, tempMap.get(key) / (double) pupils.size()));
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestStud;
        List<Label> scoreByPupil = new ArrayList<>();
        double tempScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempScore += subject.score();
            }
            scoreByPupil.add(new Label(pupil.name(), tempScore));
            tempScore = 0D;
        }
        scoreByPupil.sort(Comparator.naturalOrder());
        bestStud = scoreByPupil.get(scoreByPupil.size() - 1);
        return bestStud;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label bestSub;
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMap.put(subject.name(),
                        tempMap.getOrDefault(subject.name(), 0) +  subject.score());
            }
        }
        for (String key : tempMap.keySet()) {
            label.add(new Label(key, tempMap.get(key)));
        }
        label.sort(Comparator.naturalOrder());
        bestSub = label.get(label.size() - 1);
        return bestSub;
    }
}
