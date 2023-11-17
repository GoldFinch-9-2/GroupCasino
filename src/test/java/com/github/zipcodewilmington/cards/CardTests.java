package com.github.zipcodewilmington.cards;

import com.github.zipcodewilmington.casino.cards.Card;
import com.github.zipcodewilmington.casino.cards.Face;
import com.github.zipcodewilmington.casino.cards.Suit;
import org.junit.Assert;
import org.junit.Test;

public class CardTests {

    @Test
    public void testCardConstructor(){
        Suit suit = Suit.HEARTS;
        Face face = Face.EIGHT;
        Card card = new Card(suit, face);

        Assert.assertNotNull(card);
        Assert.assertEquals(face, card.getFace());
        Assert.assertEquals(suit, card.getSuit());
    }
}
