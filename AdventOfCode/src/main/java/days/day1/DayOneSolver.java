package days.day1;

import generic.AdventSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DayOneSolver implements AdventSolver {
    public String getAnswer(){
        LinkedList<Integer> fileList = readAllBytes("dayone.txt");
        ArrayList<Integer> input = new ArrayList<>(fileList);
        LinkedList<Integer> inputRemaining = new LinkedList<>(fileList);
        boolean found = false;


//        for(Integer first : input){
//            for(Integer second : input){
//                if(first + second == 2020){
//                    return Integer.toString(first * second);
//                }
//            }
//        }
        int counter = 0;
        long startTime = System.nanoTime();
        for(int timer = 0; timer < 1; timer++){

            input = new ArrayList<>(fileList);
            for(int i = input.size() - 1; i > 0; i--){
                for(int j = input.size() - 1; j > 0; j--){
                    for(int x = input.size() - 1; x > 0; x--){
                        if((input.get(i) + input.get(j) + input.get(x)) == 2020){
                            return Integer.toString(input.get(i) * input.get(j) * input.get(x));
                        }
                    }
                }
            }
        }
        long stopTime = System.nanoTime();

        long duration = stopTime - startTime;
        System.out.println(counter);
        System.out.println(duration);

        return "";
    }

    public LinkedList<Integer> readAllBytes(String filePath)
    {
        //ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource(filePath).getFile());
        //System.out.println(file.getAbsolutePath());

        File file2 = new File("AdventOfCode/src/main/resources/input/dayone.txt");
        System.out.println(file2.getAbsolutePath());

        Scanner sc = null;
        try {
            sc = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        LinkedList<Integer> returnList = new LinkedList<>();
        while (sc.hasNextLine()){
            returnList.add(Integer.parseInt(sc.nextLine()));
        }

        return returnList;
    }


}
