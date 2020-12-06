import days.day3.DayThreeSolver;
import days.day4.DayFourSolver;
import days.day5.DayFiveSolver;
import days.day6.DaySixSolver;
import generic.AdventSolver;

public class Main {

    static AdventSolver solver;

    public static void main(String[] args) {
        solver = new DaySixSolver();

        System.out.println(solver.getAnswer());
    }
}
