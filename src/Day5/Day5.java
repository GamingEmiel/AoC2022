package Day5;

import utils.Input;

import java.util.ArrayList;

public class Day5 {
    public static final String path = "src/Day5/input.txt";
    //public static final String endCondition = " 1   2   3";
    public static final String endCondition = " 1   2   3   4   5   6   7   8   9";
    public static final int stackAmount = 9;
    ArrayList<ArrayList<String>> stacks = new ArrayList<>();


    public static void main(String[] args) {
        new Day5().run();
    }

    public void run() {
        Input input = new Input(path);
        init(input);
        part1(input);
        input.close();
        input = new Input(path);
        init(input);
        part2(input);
        input.close();
    }

    public void init(Input input) {
        stacks.clear();
        for (int i = 0; i < stackAmount; i++) {
            stacks.add(new ArrayList<>());
        }
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                break;
            } else if (!line.equals(endCondition)) {
                String stack = "";
                int tracker = 3;
                for (ArrayList<String> strings : stacks) {
                    if (line.length() >= tracker) {
                        stack = line.substring(tracker - 3, tracker);
                        if (!stack.equals("   ")) {
                            strings.add(stack);
                        }
                    }
                    tracker += 4;
                }
            }
        }
    }

    public void part1(Input input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split("\\s+", 6);
            int amountToMove = Integer.parseInt(splitLine[1]);
            int stackToMoveFrom = Integer.parseInt(splitLine[3]);
            int stackToMoveTo = Integer.parseInt(splitLine[5]);
            for (int i = 0; i < amountToMove; i++) {
                ArrayList<String> stackFrom = stacks.get(stackToMoveFrom - 1);
                if (stackFrom.size() > 0) {
                    String crate = stackFrom.remove(0);
                    stacks.get(stackToMoveTo - 1).add(0, crate);
                }
            }
        }
        for (ArrayList<String> stack : stacks) {
            if (stack.size() > 0) {
                System.out.print(stack.get(0).charAt(1));
            }
        }
        System.out.println();
    }

    public void part2(Input input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split("\\s+", 6);
            int amountToMove = Integer.parseInt(splitLine[1]);
            int stackToMoveFrom = Integer.parseInt(splitLine[3]);
            int stackToMoveTo = Integer.parseInt(splitLine[5]);
            for (int i = 0; i < amountToMove; i++) {
                ArrayList<String> stackFrom = stacks.get(stackToMoveFrom - 1);
                if (stackFrom.size() > 0) {
                    String crate = stackFrom.remove(0);
                    stacks.get(stackToMoveTo - 1).add(i, crate);
                }
            }
        }
        for (ArrayList<String> stack : stacks) {
            if (stack.size() > 0) {
                System.out.print(stack.get(0).charAt(1));
            }
        }
    }
}
