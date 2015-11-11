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
public enum Token {

    EMPTY {
                @Override
                public String toString() {
                    return " ";
                }
            }, 
    X, O;
}
