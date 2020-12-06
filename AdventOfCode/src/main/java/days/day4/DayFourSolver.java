package days.day4;

import generic.AdventSolver;
import util.FileUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validations{
    final static Validation BirthYearValidation = (input -> input != null && input.length() == 4 && Integer.parseInt(input) >= 1920 && Integer.parseInt(input) <= 2002);
    final static Validation IssueYearValidation = (input -> input != null && input.length() == 4 && Integer.parseInt(input) >= 2010 && Integer.parseInt(input) <= 2020);
    final static Validation ExpirationYearValidation = (input -> input != null && input.length() == 4 && Integer.parseInt(input) >= 2020 && Integer.parseInt(input) <= 2030);
    final static Validation HeightValidation = (input -> {
        Pattern pattern = Pattern.compile("(.*)(cm|in)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            String unitType = matcher.group(2);
            Integer unitAmount = Integer.parseInt(matcher.group(1));
            if(unitType.equals("cm")){
                return (unitAmount >= 150 && unitAmount <= 193);
            } else if( unitType.equals("in")){
                return (unitAmount >= 59 && unitAmount <= 76);
            }
        }
        return false;
    });
    final static Validation HairColorValidation = (input -> input.matches("#[0-9a-f]{6}"));
    final static Validation EyeColorValidation = (input -> input.matches("amb|blu|brn|gry|grn|hzl|oth"));
    final static Validation PassportIdValidation = (input -> input.matches("[0-9]{9}"));
}

public class DayFourSolver implements AdventSolver {
    final List<PropertyValidation> REQUIREDPROPERTIES = Arrays.asList(
            new PropertyValidation("byr", Validations.BirthYearValidation),
            new PropertyValidation("iyr", Validations.IssueYearValidation),
            new PropertyValidation("eyr", Validations.ExpirationYearValidation),
            new PropertyValidation("hgt", Validations.HeightValidation),
            new PropertyValidation("hcl", Validations.HairColorValidation),
            new PropertyValidation("ecl", Validations.EyeColorValidation),
            new PropertyValidation("pid", Validations.PassportIdValidation)
        );

    public String getAnswer(){
        LinkedList<String> lineList = FileUtil.getTextFileAsLineList("dayfour.txt");

        List<Map<String, String>> passports = new LinkedList<>();

        HashMap<String, String> currentMap = new HashMap<>();

        for(String line : lineList){
            if(line.equals("")){
                //New passport
                passports.add(currentMap);
                currentMap = new HashMap<>();
                continue;
            }

            String[] splitLine = line.split(" ");
            for (String s : splitLine) {
                String[] passportProperty = s.split(":");
                currentMap.put(passportProperty[0], passportProperty[1]);
            }
        }
        passports.add(currentMap);

        //Check if all required properties are there
        int correctPasswordCounter = 0;
        for(Map<String, String> passport : passports){
            boolean correctPassport = true;
            for(PropertyValidation property : REQUIREDPROPERTIES){
                if(!passport.containsKey(property.name)){
                    correctPassport = false;
                    break;
                }

                if(!property.validationMethod.isValid(passport.get(property.name))){
                    correctPassport = false;
                    break;
                }

            }
            if(correctPassport){
                correctPasswordCounter++;
            }
        }


        return Integer.toString(correctPasswordCounter);
    }
}
