/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.saddleback.sraven0.tictactoe.cli;

import edu.saddleback.sraven0.tictactoe.model.*;
import java.util.Scanner;

/**
 *
 * @author sraven0
 */
public class Main {

    private static Game game;
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        game = new Game();
        Game.State state;
        do {
            printBoard();
            int move = promptMove();
            state = game.makeMove(move);
        } while (state == Game.State.Running);
        printBoard();
        switch (state) {
            case Running:
                break;
            case Tied:
                System.out.println("Game is tied!");
                break;
            case Won:
                System.out.printf("%s won!\n", game.getCurrentPlayer());
                break;
            default:
                break;
        }
    }

    private static void printBoard() {
        System.out.println("-----------");
        for (int i = 0; i < Board.SIZE; i += 3) {
            System.out.printf(" %s | %s | %s \n", 
                    game.getBoard().tokenAt(i),
                    game.getBoard().tokenAt(i + 1),
                    game.getBoard().tokenAt(i + 2));
            System.out.println("-----------");
        }
    }

    private static int promptMove() {
        Token player = game.getCurrentPlayer();
        int move = -1;
        do {
            System.out.printf("%s's turn, enter move: ", player);
            move = in.nextInt();
        } while (move < 0 || move >= Board.SIZE);
        return move;
    }

}
