package pl.sda.rafal.zientara.RockPaperScissors.players;

import pl.sda.rafal.zientara.RockPaperScissors.GameAction;

import java.util.Scanner;

public class ScannerPlayer extends Player{

    public ScannerPlayer(String nick) {
        super(nick);
    }

    @Override
    public GameAction getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getNick() + " Podaj akcję r/p/s");
        while (true) {
        String input = scanner.next().toLowerCase();
            switch (input) {
                case "r":
                case "rock":
                    return GameAction.ROCK;
                case "s":
                case "scissors":
                    return GameAction.SCISSORS;
                case "p":
                case "paper":
                    return GameAction.PAPER;
                default:
                    System.out.println(getNick() + "! Wybierz jedną z dostępnych opcji!");
            }
        }
    }
}
