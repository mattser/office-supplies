package com.nology;

public class Pens implements Stationary {

    private int amountOf;

    public Pens() {

    }
    public Pens(int numberOfPens) {
        this.amountOf = numberOfPens;
    }

    @Override
    public void add() {
        amountOf += 1;
    }

    @Override
    public int remove() {
        if (amountOf > 0) {
            amountOf -= 1;
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int getAmount() {
        return amountOf;
    }

    @Override
    public void addNumberOf(int number) {
        amountOf += number;
    }

    @Override
    public int removeNumberOf(int number) {
        if (amountOf-number > 0) {
            amountOf -= number;
            return number;
        } else {
            return -1;
        }

    }

    @Override
    public String checkForEnoughStock(int number) {
        if (amountOf >= number) {
            return "There is enough Stock";
        } else {
            return "You need " + Integer.toString(number-amountOf) + " More Stock";
        }
    }
}
