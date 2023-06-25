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
                if (tempMap.containsKey(subject.name())) {
                    tempMap.put(subject.name(),
                                tempMap.get(subject.name()) + subject.score());
                } else {
                    tempMap.put(subject.name(), subject.score());
                }
            }
        }
        for (String key : tempMap.keySet()) {
            label.add(new Label(key, tempMap.get(key) / (double) pupils.size()));
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestStud = null;
        Map<String, Label> tempMap = new LinkedHashMap<>();
        double tempScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempScore += subject.score();
                if (tempMap.containsKey(pupil.name())) {
                    tempMap.put(pupil.name(),
                            new Label(pupil.name(), tempScore));
                } else {
                    tempMap.put(pupil.name(), new Label(pupil.name(), tempScore));
                }
            }
            tempScore = 0D;
        }
        for (String key : tempMap.keySet()) {
            if (Objects.isNull(bestStud) || bestStud.compareTo(tempMap.get(key)) == -1) {
                bestStud = tempMap.get(key);
            }
        }
        return bestStud;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label bestSub = null;
        Map<String, Label> tempMap = new LinkedHashMap<>();
        double tempScore;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (tempMap.containsKey(subject.name())) {
                    tempScore = tempMap.get(subject.name()).score();
                    tempMap.put(subject.name(),
                                new Label(subject.name(), tempScore  + subject.score()));

                } else {
                    tempMap.put(subject.name(), new Label(subject.name(), subject.score()));
                }
            }
        }
        for (String key : tempMap.keySet()) {
            if (Objects.isNull(bestSub) || bestSub.compareTo(tempMap.get(key)) == -1) {
                bestSub = tempMap.get(key);
            }
        }
        return bestSub;
    }
}
