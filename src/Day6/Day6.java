package Day6;

import utils.Input;

import java.util.ArrayList;

public class Day6 {
    String[] chars;
    public static final String PATH = "src/Day6/input.txt";

    public static void main(String[] args) {
        new Day6().run();
    }

    public void run() {
        init();
        part1();
        part2();
    }

    public void init() {
        Input input = new Input(PATH);
        chars = input.nextLine().split("");
        input.close();
    }

    public void part1() {
        checkForMarker(4);
        /*int characters;
        for (characters = 4; characters < chars.length; characters++) {
            for (int i = characters - 4; i < characters; i++) {
                for (int j = i + 1; j < characters; j++) {
                    if (chars[i].equals(chars[j])) {
                        break;
                    }
                }

            }
            System.out.println(characters);
        }*/
    }

    public void part2() {
        checkForMarker(14);
    }

    public void checkForMarker(int length) {
        int characters;
        for (characters = length; characters < chars.length; characters++) {
            int count = 0;
            ArrayList<String> list = new ArrayList<>();
            for (int i = characters - length; i < characters; i++) {
                list.add(chars[i]);
            }
            for (int i = characters - length; i < characters; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i != (j + characters - length) && list.get(j).equals(chars[i])) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(characters);
                break;
            }
            //System.out.println(count);
            //System.out.println(list);
        }
    }
}
