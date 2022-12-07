package Day1;

import utils.Input;

public class Day1 {
    int Highest = 0;
    int SecondHighest = 0;
    int ThirdHighest = 0;
    public static void main(String[] args) {
        new Day1().run();
    }

    public void run() {
        Input input = new Input("src/Day1/input.txt");
        int temp = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            if (line.isEmpty()) {
                if (temp > Highest) {
                    ThirdHighest = SecondHighest;
                    SecondHighest = Highest;
                    Highest = temp;
                } else if (temp > SecondHighest) {
                    ThirdHighest = SecondHighest;
                    SecondHighest = temp;
                } else if (temp > ThirdHighest) {
                    ThirdHighest = temp;
                }
                temp = 0;
            } else {
                temp += Integer.parseInt(line);
            }
        }
        if (temp > Highest) {
            ThirdHighest = SecondHighest;
            SecondHighest = Highest;
            Highest = temp;
        } else if (temp > SecondHighest) {
            ThirdHighest = SecondHighest;
            SecondHighest = temp;
        } else if (temp > ThirdHighest) {
            ThirdHighest = temp;
        }
        System.out.println(Highest + " " + SecondHighest + " " + ThirdHighest);
        System.out.println(Highest + SecondHighest + ThirdHighest);
    }
}
