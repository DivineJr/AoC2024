import java.util.ArrayList;

public class Day1 extends Day {
    private ArrayList<Integer> list1 = new ArrayList<Integer>();
    private ArrayList<Integer> list2 = new ArrayList<Integer>();
    
    public Day1(String fileLocation) throws Exception {
        super(fileLocation);

        interpretFile();
        part1();
        part2();
    }

    private void interpretFile() {
        while(input.hasNext()) {
            list1.add(input.nextInt());
            list2.add(input.nextInt());
        }
    }

    private void sortList(ArrayList<Integer> list) {
        for(int i = list.size() - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(list.get(j) > list.get(j+1)) {
                    int placeholder = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, placeholder);
                }
            }
        }
    }

    private void part1() {
        int totalDistance = 0;

        sortList(list1);
        sortList(list2);

        //Get Distance
        for(int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println("Part 1: " + totalDistance);
    }

    private void part2() {
        int totalSimilarityScore = 0;

        for(int i = 0; i < list1.size(); i++) {
            int currentNumber = list1.get(i);
            int totalSimilar = 0;
            for(int j = 0; j < list2.size(); j++) {
                if(currentNumber == list2.get(j)) {
                    totalSimilar++;
                }
            }

            totalSimilarityScore += currentNumber * totalSimilar;
        }

        System.out.println("Part 2: " + totalSimilarityScore);
    }
}
