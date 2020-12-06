package days.day3;

import generic.AdventSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static util.FileUtil.getTextFileAsLineList;
import static util.LargeIntegerUtil.multiply;

public class DayThreeSolver implements AdventSolver {

    public String getAnswer() {
        LinkedList<String> lineList = getTextFileAsLineList("daythree.txt");
        String output = "";
        char[][] map = new char[lineList.size()][100000];
        for (int i = 0; i < lineList.size(); i++) {
            String line = lineList.get(i);
            for (int x = 0; x < 1000; x++) {
                for (int j = 0; j < line.length(); j++) {
                    map[i][j + (x * line.length())] = line.charAt(j);
                }
            }
        }

        StringBuilder line = new StringBuilder();
        for (int x = 0; x < lineList.size(); x++) {
            for (int y = 0; y < 100; y++) {
                line.append(map[x][y]);
            }
            line.append("\n");
        }
        System.out.println(line);

        // Right 1, down 1
        int[][] slopes = {
                {1, 1},
                {3, 1},
                {5, 1},
                {7, 1},
                {1, 2}
        };

        //int treeCounter = 0;
        int[] treeListCounter = new int[5];
        for (int slopeCnt = 0; slopeCnt < 5; slopeCnt++) {
            for (int i = 0; i < lineList.size() - 1; i++) {
                int right = slopes[slopeCnt][0];
                int down = slopes[slopeCnt][1];
                if (((i * down) + 1) >= lineList.size()) {
                    break;
                }
                char ch = map[(i * down) + 1][(i + 1) * right];
                if (map[(i * down) + 1][(i + 1) * right] == '#') {
                    treeListCounter[slopeCnt]++;
                }
            }
        }

        String total = multiply(Integer.toString(treeListCounter[0]), Integer.toString(treeListCounter[1]));
        total = multiply(total, Integer.toString(treeListCounter[2]));
        total = multiply(total, Integer.toString(treeListCounter[3]));
        total = multiply(total, Integer.toString(treeListCounter[4]));

        return total;
    }





}
