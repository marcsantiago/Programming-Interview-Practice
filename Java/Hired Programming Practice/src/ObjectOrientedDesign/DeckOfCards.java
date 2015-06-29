/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectOrientedDesign;

import java.util.Arrays;
import java.util.Collections;

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


class BlackJack extends DeckOfCards{
    DeckOfCards myDeck = new DeckOfCards();
    private int cardNum = 0;

    public BlackJack(){
        Collections.shuffle(Arrays.asList(myDeck.deck));
    }
    
    public String draw(){
        String card = myDeck.deck[cardNum];
        cardNum++;
        return card;
    }
    
    public void play(){
        char card1 = draw().charAt(0);
        char card2 = draw().charAt(0);
        System.out.println(card1 + " " + card2);
        
        
    }
    
}