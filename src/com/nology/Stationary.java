package com.nology;

public interface Stationary {

    public void add();
    public int remove();
    public int getAmount();
    public void addNumberOf( int number );
    public int removeNumberOf(int number);
    public String checkForEnoughStock(int number);
}
