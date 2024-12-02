import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Day {
    protected Scanner input;

    public Day(String fileLocation) throws Exception {
        input = new Scanner(new File(fileLocation));
    }

    private void interpretFile() {}
    private void part1() {}
    private void part2() {}
}
