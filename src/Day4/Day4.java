package Day4;

import utils.Input;

public class Day4 {
    int part1 = 0;
    int part2 = 0;

    public static void main(String[] args) {
        new Day4().run();
    }

    public void run() {
        init();
        part1();
        part2();
    }

    public void init() {

    }

    public void part1() {
        Input input = new Input("src/Day4/inputT.txt");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split(",");
            String[] elf1 = splitLine[0].split("-");
            String[] elf2 = splitLine[1].split("-");
            if (Integer.parseInt(elf1[0]) > Integer.parseInt(elf2[0])) {
                if (Integer.parseInt(elf1[1]) <= Integer.parseInt(elf2[1])) {
                    part1++;
                    //break;
                }
            } else if (Integer.parseInt(elf1[0]) < Integer.parseInt(elf2[0])) {
                if (Integer.parseInt(elf1[1]) >= Integer.parseInt(elf2[1])) {
                    part1++;
                    //break;
                }
            } else if (Integer.parseInt(elf1[0]) == Integer.parseInt(elf2[0])) {
                part1++;
            }

        }
        System.out.println(part1);
        input.close();
    }

    public void part2() {
        Input input = new Input("src/Day4/input.txt");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splitLine = line.split(",");
            String[] elf1 = splitLine[0].split("-");
            String[] elf2 = splitLine[1].split("-");
            if (Integer.parseInt(elf1[0]) >= Integer.parseInt(elf2[0])) {
                if (Integer.parseInt(elf1[0]) <= Integer.parseInt(elf2[1])) {
                    part2++;
                    //break;
                }
            } else if (Integer.parseInt(elf1[0]) <= Integer.parseInt(elf2[0])) {
                if (Integer.parseInt(elf1[1]) >= Integer.parseInt(elf2[0])) {
                    part2++;
                    //break;
                }
            }
        }
        System.out.println(part2);
        input.close();
    }
}
