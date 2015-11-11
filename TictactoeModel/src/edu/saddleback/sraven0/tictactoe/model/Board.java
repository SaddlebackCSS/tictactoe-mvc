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
public class Board {
    private Token[] _board;
    public static final int SIZE = 9;
    
    public Board(){
        _board = new Token[SIZE];
        for(int i = 0; i < SIZE; i++){
            _board[i] = Token.EMPTY;
        }
    }
    
    public void placeToken(Token token, int pos){
        if(token == null){
            throw new NullPointerException("token cannot be null");
        }
        _board[pos] = token;
    }
    
    public Token tokenAt(int pos){
        return _board[pos];
    }
    
    public Token checkWin(){
        return Token.EMPTY; // no winners ever >:|
    }
    
    public boolean checkTie(){
        for(Token t : _board){
            if(t == Token.EMPTY){
                return false;
            }
        }
        return true;
    }
}
