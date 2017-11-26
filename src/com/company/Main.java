package com.company;

public class Main {

    public static void main(String[] args) {
        IGameLogic gameLogic = new GameLogic(new NumberGenerator(10), new TextGenerator());
        gameLogic.startGame();
    }
}
