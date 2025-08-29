package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileListener {
    private static boolean isFloat(String str) {
        return str.matches("(-?[0-9]+[.][0-9]+[fF]?)|(-?[0-9]+[.][0-9]+E[-+]?[0-9]+)");
    }
    public static List<Integer> searchInt(List<String> filesArr) throws IOException {
        List<Integer> result = new ArrayList<>();
        for (String file : filesArr) {
            try {
                FileReader fr = new FileReader(new File(file));
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    try {
                        result.add(Integer.parseInt(line));
                    } catch (NumberFormatException e) {

                    }
                }
                br.close();
                fr.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        return result;
    }
    public static List<Float> searchFloat(List<String> filesArr) throws IOException {
        List<Float> result = new ArrayList<>();
        for (String file : filesArr) {
            try {
                FileReader fr = new FileReader(new File(file));
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    if (FileListener.isFloat(line)) {
                        result.add(Float.parseFloat(line));
                    }
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        return result;
    }
    public static List<String> searchStr(List<String> filesArr) throws IOException {
        List<String> result = new ArrayList<>();
        for (String file : filesArr) {
            try {
                FileReader fr = new FileReader(new File(file));
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    try {
                        Float.parseFloat(line);
                    } catch (NumberFormatException e) {
                        result.add(line);
                    }
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
        return result;
    }
}
