package Day2;

import utils.Input;

public class Day2 {

    int score = 0;
    public static void main(String[] args) {
        new Day2().run();
    }

    public void run() {
        Input input = new Input("src/Day2/input.txt");
        while (input.hasNextLine()) {
            String matchInput = input.nextLine();
            String[] splitInput = matchInput.split("\\s+");
            String Elf = splitInput[0];
            String Me = splitInput[1];
            switch (Elf) {
                case "A":
                    Elf = "rock";
                    break;
                case "B":
                    Elf = "paper";
                    break;
                case "C":
                    Elf = "scissors";
                    break;
            }
            switch (Me) {
                case "X":
                    Me = "lose";
                    break;
                case "Y":
                    Me = "draw";
                    break;
                case "Z":
                    Me = "win";
                    break;
            }
            match(Elf, Me);
        }
        System.out.println("Score: " + score);
    }

    public void match(String Elf, String Me) {
        switch (Elf) {
            case "rock":
                switch (Me) {
                    case "draw":
                        score += 4;
                        System.out.println("Draw");
                        break;
                    case "win":
                        score += 8;
                        System.out.println("You win");
                        break;
                    case "lose":
                        score += 3;
                        System.out.println("You lose");
                        break;
                }
                break;
            case "paper":
                switch (Me) {
                    case "lose":
                        score += 1;
                        System.out.println("You lose");
                        break;
                    case "draw":
                        score += 5;
                        System.out.println("Draw");
                        break;
                    case "win":
                        score += 9;
                        System.out.println("You win");
                        break;
                }
                break;
            case "scissors":
                switch (Me) {
                    case "win":
                        score += 7;
                        System.out.println("You win");
                        break;
                    case "lose":
                        score += 2;
                        System.out.println("You lose");
                        break;
                    case "draw":
                        score += 6;
                        System.out.println("Draw");
                        break;
                }
                break;
        }
    }
}
