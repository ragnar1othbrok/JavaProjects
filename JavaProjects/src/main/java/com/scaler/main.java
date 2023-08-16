package com.scaler;

import com.scaler.tictactoe.controllers.GameController;

public class main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        System.out.println("GAME IS STARTING") ;
        Game = game = gameController.startGame();

        while (gameController.getGameStatus(game).equals(IN_PROGRESS)) {
            gameController.printBoard(game);
            gameController.makeNextMove(game);
        }
        if(gameController.getStatus(game).equals(DRAW)){
            System.out.println("Gamw has Drawn");
        }
        else {
            System.out.println("Game has Won");
        }
    }
}
