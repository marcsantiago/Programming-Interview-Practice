/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author marcsantiago
 */
public class DeckOfCards {
    private final String [] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
    private final String [] cards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "King", "Queen"};
    public String [] deck = new String[52];
    
    public DeckOfCards(){
        for (int i = 0; i < deck.length; i++) {
            deck[i] = cards[i% 13] + " Of " + suits[i % 4];
        }
        
        Collections.shuffle(Arrays.asList(deck));
    }
  
}


class BlackJack{
    DeckOfCards myDeck = new DeckOfCards();
    //private int turn = 0;
    private int cardNum = 0;
    private int computerPoints = 0;
    private int playerPoints = 0;
    private boolean computerStay = false;
    private String playerName;
    private String computerInitCard;
    private ArrayList<Integer> playerHand = new ArrayList<>();
    private ArrayList<Integer> computerHand = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);

    public BlackJack(){
        game();
    }
    
    private void game(){
        boolean hit = true;
        System.out.println("Please enter your name");
        playerName = sc.next();
        System.out.println("Welcome " + playerName);
        System.out.println("Dealing cards...");
        drawTwo();
        System.out.println("Computer has two cards, one is face down the other is "  + computerInitCard);
        System.out.println(playerName + "'s two cards are the " + myDeck.deck[2] + " and " + myDeck.deck[3] + " total points: " + playerPoints);
        if(computerPoints == 21){
            computerStay = true;
        }
        if(playerPoints == 21 && computerPoints != 21){
            System.out.println(playerName + " wins!");
            System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
            return;
        }
        while(hit){
            System.out.println("Hit? [y, n]");
            String answer = sc.next();
            if(answer.equals("y")){
                playerDraw();
                System.out.println("Current Hand " + playerPoints);
            }
            else{
                hit = false;
            }
            
            if(playerPoints == 21){
                System.out.println(playerName + " wins!");
                System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
                return;
            }
            
            if(playerPoints > 21){
                System.out.println(playerName + " loses!");
                 System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
                return;
            }
        }
        
        while(!computerStay){
            computerDraw();
            if(computerPoints > 21){
                System.out.println("Computer loses! Computer had " + computerPoints + " points" );
                return;
            }
        }
        
        if(computerPoints > playerPoints){
            System.out.println(playerName + " loses!");
            System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
        }
        else if(computerPoints < playerPoints){
            System.out.println(playerName + " wins!");
            System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
        }
        else if(computerPoints == playerPoints){
            System.out.println("Bust!");
            System.out.println("Computer Points: " + computerPoints + playerName + "'s Points: " + playerPoints);
        }
        
        
    }
    
    
    private void drawTwo(){
        computerInitCard = computerDraw();
        computerDraw();
        playerDraw();
        playerDraw();
    }
    
    private String computerDraw(){
        if(computerPoints >= 17 && computerPoints < 22 || computerPoints > 21){
            computerStay = true;
        }
        
        if(!computerStay){
            String card = myDeck.deck[cardNum];
            if(card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K'){
                computerHand.add(10);
            }
            else if(card.charAt(0) == 'A'){
                computerHand.add(11);
            }
            else if(card.contains("10")){
                computerHand.add(10);
            }
            else{
                computerHand.add(Integer.parseInt((String.valueOf(card.charAt(0)))));
            }       
            computerPoints = sumHand(computerHand);
            cardNum++;
            return card;
        }     
        return null;
    }
    
    private void playerDraw(){
        String card = myDeck.deck[cardNum];
        if(card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K'){
            playerHand.add(10);
        }
        else if(card.charAt(0) == 'A'){
            playerHand.add(11);
        }
        else if(card.contains("10")){
            playerHand.add(10);
        }
        else{
            playerHand.add(Integer.parseInt((String.valueOf(card.charAt(0)))));
        }
        System.out.println(playerName + " drew " + card);
        playerPoints = sumHand(playerHand);   
        cardNum++;
    }
    
    private int sumHand(ArrayList<Integer> hand){
        int sum = 0;
        boolean elevenInHand = false;
        for(Integer i : hand){
            if(i == 11){
                elevenInHand = true;
            }
            sum += i;
        }
        if(elevenInHand && sum > 21){
            sum -= 10;
        } 
        return sum;
    }
}