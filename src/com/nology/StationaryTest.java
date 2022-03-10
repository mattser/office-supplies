package com.nology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StationaryTest {

    A4Booklet booklets;
    Pens pens;
    Rulers rulers;
    Staples staples;
    Staplers staplers;

    @BeforeEach
    void setUp() {
        booklets = new A4Booklet(300);
        pens = new Pens(1000);
        staplers = new Staplers(200);
        staples = new Staples(8000);
        rulers = new Rulers(50);
    }

    @AfterEach
    void tearDown() {}

    @Test
    @DisplayName("Remove 258 pens, ")
    void removePens() {
        pens.removeNumberOf(258);
        assertEquals(742, pens.getAmount());
    }

    @Test
    @DisplayName("See check for not enough pens message")
    void handOutPens() {
        int numberNeeded = 10*250 - pens.getAmount();
        assertEquals(pens.checkForEnoughStock(10*250),"You need " + numberNeeded + " More Stock");
    }

    @Test
    @DisplayName("Check for enough staples")
    void handOutStaples() {
        int numberRequired = staplers.getAmount()*92;
        int numberNeeded = numberRequired - staples.getAmount();
        assertEquals(staples.checkForEnoughStock(numberRequired),"You need " + numberNeeded + " More Stock");
    }

    @Test
    @DisplayName("Check How Many Rulers are Needed")
    void moreRulers() {
        int numberNeeded = (300+63) - rulers.getAmount();
        assertEquals(rulers.checkForEnoughStock(300+63),"You need " + numberNeeded + " More Stock");
    }

    @Test
    @DisplayName("Check for the max number of staff possible")
    void maxStaff() {
        int maxStaff = 16;
        boolean StockLeft = true;
        int counter = 0;
        int reply;

        while (true) {

            reply = pens.removeNumberOf(5);
            if (reply == -1) break;
            reply = staplers.removeNumberOf(1);
            if (reply == -1) break;
            reply = staples.removeNumberOf(100);
            if (reply == -1) break;
            reply = rulers.removeNumberOf(3);
            if (reply == -1) break;
            reply = booklets.removeNumberOf(4);
            if (reply == -1) break;

            counter++;

        }

        assertEquals(maxStaff,counter);
    }
}
