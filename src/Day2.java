import java.util.ArrayList;
import java.util.Scanner;

public class Day2 extends Day {
    ArrayList<ArrayList<Integer>> bigList = new ArrayList<ArrayList<Integer>>();

    public Day2(String fileString) throws Exception {
        super(fileString);

        System.out.println("== Day 2 ==");
        interpretFile();
        part1();
        part2();
    }

    private void interpretFile() {
        while (input.hasNextLine()) {
            Scanner currentLine = new Scanner(input.nextLine());
            ArrayList<Integer> smallList = new ArrayList<Integer>();
            while (currentLine.hasNext()) {
                smallList.add(currentLine.nextInt());
            }

            bigList.add(smallList);
        }
    }

    private void part1() {
        int totalSafe = 0;

        for (int i = 0; i < bigList.size(); i++) {
            ArrayList<Integer> currentList = bigList.get(i);
            boolean increase = false;
            boolean flag = true;

            for (int j = 0; j < currentList.size() - 1; j++) {
                if (j == 0) {
                    if (currentList.get(0) < currentList.get(1)) {
                        increase = true;
                    } else {
                        increase = false;
                    }
                }
                if (currentList.get(j) == currentList.get(j + 1)) {
                    flag = false;
                } else {
                    if (increase ? currentList.get(j) < currentList.get(j + 1)
                            : currentList.get(j) > currentList.get(j + 1)) {
                        int difference = Math.abs(currentList.get(j) - currentList.get(j + 1));
                        if (difference >= 1 && difference <= 3) {
                            // do nothing
                        } else {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }

                if (!flag) {
                    j = currentList.size();
                }
            }

            if (flag) {
                totalSafe++;
            }
        }

        System.out.println("Part 1: " + totalSafe);

    }

    //376 too high
    //294 too high
    @SuppressWarnings("unchecked")
    private void part2() {
        int totalSafe = 0;

        for (int i = 0; i < bigList.size(); i++) {
            ArrayList<Integer> currentList = bigList.get(i);
            boolean flag = false;

            for (int j = 0; j <= currentList.size(); j++) {
                ArrayList<Integer> useList = giveListPart2((ArrayList<Integer>)(currentList.clone()), j);
                if(checkSafePart2(useList)) {
                    flag = true;
                    j = currentList.size() + 1;
                }
            }

            if(flag) {
                totalSafe++;
            }

        }

        System.out.println("Part 2: " + totalSafe);
    }

    private boolean checkSafePart2(ArrayList<Integer> list) {
        boolean increase = true;
        boolean flag = true;
        for (int j = 0; j < list.size() - 1; j++) {
            if (j == 0) {
                if (list.get(0) < list.get(1)) {
                    increase = true;
                } else {
                    increase = false;
                }
            }
            if (list.get(j) == list.get(j + 1)) {
                flag = false;
            } else {
                if (increase ? list.get(j) < list.get(j + 1) : list.get(j) > list.get(j + 1)) {
                    int difference = Math.abs(list.get(j) - list.get(j + 1));
                    if (difference >= 1 && difference <= 3) {
                        // do nothing
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }

            if (!flag) {
                j = list.size();
            }
        }

        return flag;
    }

    private ArrayList<Integer> giveListPart2(ArrayList<Integer> list, int index) {
        if(index == 0) {
            return list;
        } else {
            list.remove(index - 1);
            return list;
        }
    }
}
