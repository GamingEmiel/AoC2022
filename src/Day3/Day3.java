package Day3;

import utils.Input;

import java.util.ArrayList;
import java.util.Collections;

public class Day3 {
    int score = 0;
    int score2 = 0;
    ArrayList<String> compartment1 = new ArrayList<>();
    ArrayList<String> compartment2 = new ArrayList<>();
    ArrayList<String> rucksack1 = new ArrayList<>();
    ArrayList<String> rucksack2 = new ArrayList<>();
    ArrayList<String> rucksack3 = new ArrayList<>();


    public static void main(String[] args) {
        new Day3().run();
    }

    public void run() {
        init();
        part1();
        part2();
    }

    public void init() {

    }

    public void part1() {
        Input input = new Input("src/Day3/input.txt");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split("");
            for (int i = 0; i < splitLine.length / 2; i++) {
                compartment1.add(splitLine[i]);
            }
            for (int i = splitLine.length / 2; i < splitLine.length; i++) {
                compartment2.add(splitLine[i]);
            }
            for (String s : compartment1) {
                if (compartment2.contains(s)) {
                    score += convertItem(s);
                    break;
                }
            }
            compartment1.clear();
            compartment2.clear();
        }
        System.out.println(score);
    }

    public int convertItem(String item) {
        if (Character.isLowerCase(item.charAt(0))) {
            return item.charAt(0) - 96;
        } else {
            return item.charAt(0) - 38;
        }
    }

    public void part2() {
        Input input = new Input("src/Day3/input.txt");
        int counter = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split("");
            if (counter == 0) {
                Collections.addAll(rucksack1, splitLine);
                counter++;
            } else if (counter == 1) {
                Collections.addAll(rucksack2, splitLine);
                counter++;
            } else if (counter == 2) {
                Collections.addAll(rucksack3, splitLine);
                counter = 0;
                for (String s : rucksack1) {
                    if (rucksack2.contains(s) && rucksack3.contains(s)) {
                        score2 += convertItem(s);
                        rucksack1.clear();
                        rucksack2.clear();
                        rucksack3.clear();
                        break;
                    }
                }
            }

        }
        System.out.println(score2);
    }
}
