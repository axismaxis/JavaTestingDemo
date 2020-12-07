package days.day7;

import com.sun.org.apache.xpath.internal.operations.Bool;
import generic.AdventSolver;
import util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySevenSolver implements AdventSolver {

//    static class Bag {
//        public Bag(String color) {
//            this.color = color;
//        }
//
//        public String color;
//        List<Bag>  = new LinkedList<>();
//    }

    static class Bag{
        public Bag(String color) {
            this.color = color;
        }

        public String color;

        private List<String> colorsInBag = new LinkedList<>();
        public void addContainingColor(String color){
            colorsInBag.add(color);
        }

        public List<String> getContainingColors(){
            return colorsInBag;
        }
    }

    Map<String, List<String>> bags = new HashMap<>();
    Map<String, Boolean> foundGoldBagInThisBag = new HashMap<>();

    public String getAnswer() {
        ArrayList<String> lineList = FileUtil.getTextFileAsArrayLineList("dayseven.txt");

        Pattern p = Pattern.compile("(?<=[0-9] )\\w+ \\w+(?= \\w+[\\,\\.])");

        String currentColor;
        List<String> currentContainingColors;
        for (String line : lineList) {
            currentColor = line.split(" bags contain")[0];
            currentContainingColors = new LinkedList<>();
            Matcher matcher = p.matcher(line);
            int i = 0;
            while (matcher.find()) {
                currentContainingColors.add(matcher.group());
            }
            bags.put(currentColor, currentContainingColors);
        }

        int bagsContaining = 0;
        for(Map.Entry<String, List<String>> bag : bags.entrySet()){
            if(doesBagContainShinyGold(bag.getKey(), 0)){
                bagsContaining++;
            }
        }

        return Integer.toString(1);
    }

    public Boolean doesBagContainShinyGold(String bagColor, int helpMeDaddy){
        try {
            helpMeDaddy++;
            if(helpMeDaddy == 6){
                System.out.println("Hello");
            }
            if(bagColor.equals("shiny gold")){
                return false;
            }
            if(foundGoldBagInThisBag.containsKey(bagColor)){
                return foundGoldBagInThisBag.get(bagColor);
            }
            if(bags.get(bagColor).contains("shiny gold")){
                foundGoldBagInThisBag.put(bagColor, true);
                return foundGoldBagInThisBag.get(bagColor);
            }

            boolean foundBag = false;
            if(bags.get(bagColor).size() == 0){
                foundGoldBagInThisBag.put(bagColor, false);
            }
            for(String containingBagColor : bags.get(bagColor)){
                if(doesBagContainShinyGold(containingBagColor, helpMeDaddy)){
                    foundGoldBagInThisBag.put(containingBagColor, true);
                    foundBag = true;
                } else {
                    foundGoldBagInThisBag.put(containingBagColor, false);

                }
            }
            return foundBag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
