package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.cards.Card;
import com.github.zipcodewilmington.casino.cards.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJackGame implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    ArrayList<PlayerInterface> players = new ArrayList<>();
    Deck deck = new Deck();
    BlackJackPlayer dealer = new BlackJackPlayer(new CasinoAccount("tamdoan", "hi12345"));
    @Override
    public boolean add(PlayerInterface player) {
        return players.add(player);
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return players.remove(player);
    }

    public Card deal(){
        return deck.pop();
    }
    @Override
    public void run() {
        console.println(".______    __          ___       ______  __  ___        __       ___       ______  __  ___ \n" +
                "|   _  \\  |  |        /   \\     /      ||  |/  /       |  |     /   \\     /      ||  |/  / \n" +
                "|  |_)  | |  |       /  ^  \\   |  ,----'|  '  /        |  |    /  ^  \\   |  ,----'|  '  /  \n" +
                "|   _  <  |  |      /  /_\\  \\  |  |     |    <   .--.  |  |   /  /_\\  \\  |  |     |    <   \n" +
                "|  |_)  | |  `----./  _____  \\ |  `----.|  .  \\  |  `--'  |  /  _____  \\ |  `----.|  .  \\  \n" +
                "|______/  |_______/__/     \\__\\ \\______||__|\\__\\  \\______/  /__/     \\__\\ \\______||__|\\__\\ \n" +
                "                                                                                           ");
        BlackJackPlayer player = (BlackJackPlayer) players.get(0);
        double bet = 0.0;

        do {
            player.printBalance();
            dealHands(player);
            boolean playAgain = true;
            bet = askForBet(player);

            while (playAgain){
                // checks if anyone is dealt a blackjack from beginning
                if(!checkPlayerCards(player) || !checkPlayerCards(this.dealer)){
                    break;
                }
                // prints out cards in dealer's & player's hands
                printHands(player);
                String input = console.getStringInput("Dealer's hand is: " + dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\nWould you like to hit or stand?\n" +
                        "    [ HIT ] , [ STAND ] ");

                // moved game logic into play method to test it
                playAgain = play(input, player);

                if(player.getStand() && this.dealer.getStand()){
                    break;
                }

            }
            System.out.println(" *** GAME OVER ***");
            printHands(player);
            System.out.println("*** ENDING SCORE *** \nDealer's hand is: " + this.dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\n****");

            determineWinner(player, bet);
            clearGame(player);
        }
        while(playAgain("\nWould you like to play again?\n [ YES ], [ NO ]"));


    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return console.getStringInput(prompt).equalsIgnoreCase("yes");
    }

    public void dealHands(BlackJackPlayer player){
        this.dealer.addToHand(deal());
        //this.dealer.addToHand(deal());
        player.addToHand(deal());
        player.addToHand(deal());
    }

    public void dealerMove(){
        if(this.dealer.getSumOfCards() < 16){
            this.dealer.addToHand(deal());
        }
        else {
            this.dealer.stand();
        }
    }

    public boolean hit(BlackJackPlayer player){
        player.addToHand(deal());
        boolean playAgain = checkPlayerCards(player);
//        if(!dealer.getStand() && playAgain) {
//            dealerMove();
//            playAgain = determineAfterDealerMove(player);
//            return playAgain;
//        }
//        else if(dealer.getStand() && (player.getSumOfCards() > this.dealer.getSumOfCards())){
//            return playAgain;
//        }
        return playAgain;
    }

    public boolean checkPlayerCards(BlackJackPlayer player){
        if(player.getSumOfCards() > 21){
            System.out.println("*** BUST! ***");
            return false;
        }
        else if(player.getSumOfCards() == 21){
            System.out.println("*** BLACK JACK! ***");
            return false;
        }
        return true;
    }


    public boolean determineAfterDealerMove(BlackJackPlayer player){
        if(this.dealer.getSumOfCards() > 21 && player.getSumOfCards() < 21){
            System.out.println("*** DEALER BUSTED! ***");
            return false;
        }
        else if(this.dealer.getSumOfCards() == 21){
            System.out.println("*** DEALER BLACKJACK! ***");
            return false;
        }

        return true;
    }

    public void determineWinner(BlackJackPlayer player, double bet){
        if((player.getSumOfCards() < this.dealer.getSumOfCards() && this.dealer.getSumOfCards() > 21)){
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + bet);
            // player get winnings
        }
        else if(player.getSumOfCards() > this.dealer.getSumOfCards() && this.dealer.getSumOfCards() < 21 && player.getSumOfCards() < 21){
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + bet);
        }
        else if(player.getSumOfCards() == 21){
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + (bet * 2));
            // player get winnings
        }
        else{
           System.out.println("YOU LOSE!");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() - bet );

        }
        player.printBalance();

    }

    public void clearGame(BlackJackPlayer player){
        this.dealer.hand.clear();
        player.hand.clear();
        this.dealer.sumOfCards = 0;
        player.sumOfCards = 0;
        this.dealer.stand = false;
        player.stand = false;
    }

    public void printHands(BlackJackPlayer player){
        System.out.println("*** Dealer's ***");
        this.dealer.printHand();
        System.out.println("*** Player's ***");
        player.printHand();
    }

    public BlackJackPlayer getDealer() {
        return this.dealer;
    }

    public double askForBet(BlackJackPlayer player) {
        double answer = -1;
        while (answer == -1){
            answer = console.getDoubleInput("How much would you like to bet?: ");
            if(answer < 10){
                answer = -1;
                System.out.println("Must be more than $10 !!");
            }
            else if(answer > player.getArcadeAccount().getBalance()){
                answer = -1;
                System.out.println("You don't even have that much money!");
            }
        }
        return answer;
    }

    public boolean play(String input, BlackJackPlayer player){
        boolean play = true;
        if (input.equalsIgnoreCase("hit")) {
            play = hit(player);
        } else if (input.equalsIgnoreCase("stand")){
            player.stand();

            // dealer keeps hitting until it gets to the point where it wins or busts
            dealerMove();
            while (!dealer.getStand() && (this.dealer.getSumOfCards() != player.getSumOfCards())) {
                printHands(player);
                System.out.println("Dealer's hand is: " + this.dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\n");
                determineAfterDealerMove(player);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                dealerMove();
            }
            play = false;
        }

        return play;
    }
}
