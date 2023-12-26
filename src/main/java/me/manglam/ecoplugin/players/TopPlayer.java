package me.manglam.ecoplugin.players;

public class TopPlayer {

    private String name;
    private double balance;

    public TopPlayer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}

