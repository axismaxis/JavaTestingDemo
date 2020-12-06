package days.day6;

import com.sun.org.apache.xpath.internal.operations.Bool;
import generic.AdventSolver;
import util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DaySixSolver implements AdventSolver {
    static class Group{
        Map<Character, Integer> foundAnswers = new HashMap<>();
        int amountAllAnsweredYes = 0;
    }

    public String getAnswer(){
        ArrayList<String> lineList = FileUtil.getTextFileAsArrayLineList("daysix.txt");

        List<Group> foundGroups = new LinkedList<>();

        Group group = new Group();
        int peopleCounter = 0;
        for(String line : lineList){
            if(line.equals("")){
                for(Map.Entry<Character, Integer> entry : group.foundAnswers.entrySet()){
                    if(entry.getValue() == peopleCounter){
                        group.amountAllAnsweredYes++;
                    }
                }

                foundGroups.add(group);
                group = new Group();
                peopleCounter = 0;
                continue;
            }

            peopleCounter++;
            for(Character c : line.toCharArray()){
                if(group.foundAnswers.containsKey(c)){
                    group.foundAnswers.put(c, group.foundAnswers.get(c) + 1);
                } else {
                    group.foundAnswers.put(c, 1);
                }
            }
        }
        for(Map.Entry<Character, Integer> entry : group.foundAnswers.entrySet()){
            if(entry.getValue() == peopleCounter){
                group.amountAllAnsweredYes++;
            }
        }

        foundGroups.add(group);

        int count = 0;
        for(Group g : foundGroups){
            count += g.amountAllAnsweredYes;
        }

        return Integer.toString(count);
    }
}
