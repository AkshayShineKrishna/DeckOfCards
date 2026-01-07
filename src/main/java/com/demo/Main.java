package com.demo;

import com.demo.models.Cards;
import com.demo.services.Deck;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        List<Cards> drawnCards = new ArrayList<>();
        for(int i = 0; i<20 ; i++){
            try {
                drawnCards.add(deck.drawCard());
            } catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException : " + e.getMessage());
                break;
            }
        }
        System.out.println("\nDrawn cards : \n" + drawnCards);
        drawnCards.sort(Comparator.comparing(Cards::getSuit).thenComparing(Cards::getRank));
        System.out.println("\nDrawn cards after sorting based on suit then based on rank : \n" + drawnCards);
    }
}