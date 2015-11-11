/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.saddleback.sraven0.tictactoe.model;

/**
 *
 * @author sraven0
 */
public class Game {

    Board board;
    Token currentPlayer;

    public enum State {

        Running, Won, Tied;
    }

    private State state;

    public Game() {
        newGame();
    }

    final public void newGame() {
        board = new Board();
        currentPlayer = Token.X;
        state = State.Running;
    }

    public State makeMove(int pos) {
        if (state == State.Running) {
            board.placeToken(currentPlayer, pos);
            Token winner = board.checkWin();
            if (winner != Token.EMPTY) {
                state = State.Won;
            } else if (board.checkTie()) {
                state = State.Tied;
            } else {
                currentPlayer = currentPlayer == Token.X ? Token.O : Token.X;
            }
        }
        return state;
    }

    public Token getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}
