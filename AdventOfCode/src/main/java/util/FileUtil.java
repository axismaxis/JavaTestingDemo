package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FileUtil {

    public static ArrayList<String> getTextFileAsArrayLineList(String filePath){
        return new ArrayList<>(getTextFileAsLineList(filePath));
    }

    public static LinkedList<String> getTextFileAsLineList(String filePath) {
        File file2 = new File("AdventOfCode/src/main/resources/input/" + filePath);

        Scanner sc = null;
        try {
            sc = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        LinkedList<String> returnList = new LinkedList<>();
        while (sc.hasNextLine()) {
            returnList.add(sc.nextLine());
        }

        return returnList;
    }
}
