package controller;   // hoac dung package ban dang de Main.java

import view.GameView;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();
        view.start();
    }
}