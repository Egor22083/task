package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, TaskException{
        String fullPath = "";
        List<String> filesArr = new ArrayList<>();
        boolean append = false;

        for (String arg : args) {
            if (arg.contains(".txt")) {
                filesArr.add(arg);
            }
        }
        if (filesArr.isEmpty()) {
            throw new TaskException("Не указаны читаемые файлы");
        }

        String filePath = "";
        if (Arrays.asList(args).contains("-o")) {
            filePath = args[Arrays.asList(args).indexOf("-o") + 1] + "/";
            if (filePath.equals("-p") || filePath.equals("-a") || filePath.equals("-s") || filePath.equals("-f") || filePath.equals("-o") || filesArr.contains(args[Arrays.asList(args).indexOf("-o") + 1])) {
                throw new TaskException("Не указан путь для результатов после параметра -o");
            }
        }
        if (Arrays.asList(args).contains("-p")) {
            String prefPath = args[Arrays.asList(args).indexOf("-p") + 1];
            if (prefPath.equals("-p") || prefPath.equals("-a") || prefPath.equals("-s") || prefPath.equals("-f") || prefPath.equals("-o")  || filesArr.contains(args[Arrays.asList(args).indexOf("-p") + 1])) {
                throw new TaskException("Не указан префикс для результатов после параметра -p");
            }
            filePath = filePath + prefPath;
        }
        fullPath = filePath;

        List<Integer> intArr = FileListener.searchInt(filesArr);
        List<Float> floatArr = FileListener.searchFloat(filesArr);
        List<String> stringArr = FileListener.searchStr(filesArr);

        if (Arrays.asList(args).contains("-a")) {
            append = true;
        }
        try (BufferedWriter writerInt = new BufferedWriter(new FileWriter(fullPath + "integers.txt", append));
             BufferedWriter writerFloat = new BufferedWriter(new FileWriter(fullPath + "floats.txt", append));
             BufferedWriter writerStr = new BufferedWriter(new FileWriter(fullPath + "strings.txt", append))) {
            for (Integer item : intArr) {
                writerInt.write(item.toString());
                writerInt.newLine();
            }
            for (Float item : floatArr) {
                writerFloat.write(item.toString());
                writerFloat.newLine();
            }
            for (String item : stringArr) {
                writerStr.write(item);
                writerStr.newLine();
            }
        } catch (IOException e) {
            throw new TaskException("Ошибка при записи в целевые файлы");
        }

        if (Arrays.asList(args).contains("-s")) {
            if (Arrays.asList(args).contains("-f")) {
                throw new TaskException("Указаны одновременно параметры -s, -f");
            }
            System.out.println(StatisticsCount.shortStat(intArr, floatArr,stringArr));
        } else if (Arrays.asList(args).contains("-f")) {
            System.out.println(StatisticsCount.longStat(intArr, floatArr,stringArr));
        }
    }
}