package org.example;

import java.util.List;

public class StatisticsCount {
    public static String shortStat(List<Integer> intArr, List<Float> floatArr, List<String> stringArr) {

        return "Int-элементов: " + intArr.size() + " Float-элементов: " + floatArr.size() + " String-элементов: " + stringArr.size();
    }

    //Полная статистика для чисел дополнительно содержит минимальное и максимальное значения, сумма и среднее.

    //Полная статистика для строк, помимо их количества, содержит также размер самой короткой строки и самой длинной.

    public static String longStat(List<Integer> intArr, List<Float> floatArr, List<String> stringArr) {
        Integer maxI = intArr.getFirst();
        Integer minI = intArr.getFirst();
        int sumI = 0;
        int averageI = 0;
        for (Integer i : intArr) {
            if (minI > i) {
                minI = i;
            }
            if (maxI < i) {
                maxI = i;
            }
            sumI = sumI + i;
        }
        averageI = sumI / intArr.size();

        Float maxF = floatArr.getFirst();
        Float minF = floatArr.getFirst();
        float sumF = 0.0f;
        float averageF = 0.0f;
        for (Float i : floatArr) {
            if (minF > i) {
                minF = i;
            }
            if (maxF < i) {
                maxF = i;
            }
            sumF = sumF + i;
        }
        averageF = sumF / floatArr.size();

        int minS = stringArr.getFirst().length();
        int maxS = stringArr.getFirst().length();
        for (String i : stringArr) {
            if (minS > i.length()) {
                minS = i.length();
            }
            if (maxS < i.length()) {
                maxS = i.length();
            }
        }
        return "Int-элементов: " + intArr.size() + " Float-элементов: " + floatArr.size() + " String-элементов: " + stringArr.size() + "\n" +
                "Максимальный Int-элемент: " + maxI + " Минимальный Int-элемент: " + minI + " Сумма Int-элементов: " + sumI + " Среднее значение Int-элементов: " + averageI + "\n" +
                "Максимальный Float-элемент: " + maxF + " Минимальный Float-элемент: " + minF + " Сумма Float-элементов: " + sumF + " Среднее значение Float-элементов: " +  averageF + "\n" +
                "Самый длинный String-элемент: " + maxS + " Самый короткий String-элемент: " + minS;
    }
}
