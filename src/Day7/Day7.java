package Day7;

import utils.Input;

import java.util.ArrayList;

public class Day7 {
    ArrayList<Directory> allDirectories = new ArrayList<>();
    private Directory currentDirectory;

    public static void main(String[] args) {
        new Day7().run();
    }

    public void run() {
        init();
        part1();
        part2();
    }

    public void init() {
        Input input = new Input("src/Day7/input.txt");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split("\\s+");
            String name = splitLine[0];
            switch (name) {
                case "$":
                    if ("cd".equals(splitLine[1])) {
                        Directory directory = new Directory();
                        if (currentDirectory == null) {
                            allDirectories.add(directory);
                            currentDirectory = directory;
                        } else if (splitLine[2].equals("..")) {
                            currentDirectory = currentDirectory.parent;
                        } else {
                            directory.parent = currentDirectory;
                            allDirectories.add(directory);
                            currentDirectory = directory;
                        }
                    }
                    break;
                case "dir":
                    break;
                default:
                    int weight = Integer.parseInt(name);
                    Directory parentDirectory = currentDirectory.parent;
                    while (parentDirectory != null) {
                        parentDirectory.totalWeight += weight;
                        parentDirectory = parentDirectory.parent;
                    }
                    currentDirectory.totalWeight += weight;
            }
        }
        input.close();
    }

    public void part1() {
        int part1 = 0;
        for (Directory directory : allDirectories) {
            if (directory.totalWeight <= 100000) {
                part1 += directory.totalWeight;
            }
        }
        System.out.println(part1);
    }

    public void part2() {
        int freeSpace = 70000000 - allDirectories.get(0).totalWeight;
        int moreNeededSpace = 30000000 - freeSpace;
        int smallestDirectory = Integer.MAX_VALUE;
        for (Directory directory : allDirectories) {
            if (directory.totalWeight >= moreNeededSpace && directory.totalWeight < smallestDirectory) {
                smallestDirectory = directory.totalWeight;
            }
        }
        System.out.println(smallestDirectory);
    }
}

class Directory {
    int totalWeight;
    Directory parent;

    public Directory() {
        this.totalWeight = 0;
    }
}
