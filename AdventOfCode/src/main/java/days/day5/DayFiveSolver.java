package days.day5;

import generic.AdventSolver;
import util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFiveSolver implements AdventSolver {
    public String getAnswer(){
        ArrayList<String> lineList = FileUtil.getTextFileAsArrayLineList("dayfive.txt");


        ArrayList<Integer> resultList = new ArrayList<>();
        for(String line : lineList){
            int min = 0;
            int max = 127;
            int foundRow = 0;

            int colMin = 0;
            int colMax = 7;
            int foundColumn = 0;

            int counter = 0;
            for(Character c : line.toCharArray()){
                counter++;
                if(counter == 7){
                    if(c.equals('B')){
                        foundRow = max;
                    } else if(c.equals('F')){
                        foundRow = min;
                    }
                    //System.out.println(foundRow);
                    continue;
                }
                if(counter < 7){
                    if(c.equals('B')){
                        min = (int) Math.ceil((max + min) / 2.0);
                    } else if(c.equals('F')){
                        max = (max + min) / 2;
                    }
                } else if (counter > 7){
                    if(counter == 10){
                        if(c.equals('L')){
                            foundColumn = colMin;
                        } else if(c.equals('R')){
                            foundColumn = colMax;
                        }
                        //System.out.println(foundColumn);
                        continue;
                    }
                    if(c.equals('R')){
                        colMin = (int) Math.ceil((colMax + colMin) / 2.0);
                    } else if(c.equals('L')){
                        colMax = (colMax + colMin) / 2;
                    }
                }
            }

            resultList.add(foundColumn + (foundRow * 8));
        }

        int min = 1000;
        int max = 0;
        for(Integer i : resultList){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        boolean[] seatExist = new boolean[1000];
        for(Integer i : resultList){
            seatExist[i] = true;
        }

        Integer notFoundId = 0;
        for(int i = min; i <= max; i++){
            if(!seatExist[i]){
                notFoundId = i;
            }
        }

        int resultMax = resultList.stream().max(Integer::compare).get();

        return Integer.toString(notFoundId);
    }
}
