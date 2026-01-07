package com.demo.services;

import com.demo.models.Cards;
import com.demo.models.Rank;
import com.demo.models.Suit;


import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Deck {

    private final Stack<Cards> cards = new Stack<>();

    public Deck(){
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                Cards card = new Cards(suit,rank);
                cards.push(card);
            }
        }
    }

    public Stack<Cards> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Cards drawCard() throws NoSuchElementException {
        if(!cards.isEmpty()){
            return cards.pop();
        }
        throw new NoSuchElementException("No cards to draw");
    }

}
