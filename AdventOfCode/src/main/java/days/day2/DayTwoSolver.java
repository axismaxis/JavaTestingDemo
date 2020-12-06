package days.day2;

import generic.AdventSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static util.FileUtil.getTextFileAsLineList;

public class DayTwoSolver implements AdventSolver {
    public String getAnswer(){
        LinkedList<String> fileList = getTextFileAsLineList("daytwo.txt");
        int totalPasswordsCorrect = 0;
        for(String line : fileList){
            String[] splitLine = line.split(" ");
            int min = Integer.parseInt(splitLine[0].split("-")[0]);
            int max = Integer.parseInt(splitLine[0].split("-")[1]);

            char charToFind = splitLine[1].substring(0, 1).toCharArray()[0];

            String password = splitLine[2];
            boolean foundFirst = false;
            boolean foundSecond = false;
            if(password.charAt(min - 1) == charToFind){
                foundFirst = true;
            }
            if(password.charAt(max - 1) == charToFind){
                foundSecond = true;
            }
            if(foundFirst && foundSecond){
                continue;
            }
            if(foundFirst || foundSecond){
                totalPasswordsCorrect++;
            }
        }

        long stopTime = System.nanoTime();
        //long duration = stopTime - startTime;
        //System.out.println(duration);

        return Integer.toString(totalPasswordsCorrect);
    }



    public LinkedList<String> readAllBytes(String filePath)
    {
        //ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource(filePath).getFile());
        //System.out.println(file.getAbsolutePath());

        File file2 = new File("AdventOfCode/src/main/resources/input/" + filePath);
        //System.out.println(file2.getAbsolutePath());

        Scanner sc = null;
        try {
            sc = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        LinkedList<String> returnList = new LinkedList<>();
        while (sc.hasNextLine()){
            returnList.add(sc.nextLine());
        }

        return returnList;
    }


}
