/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.saddleback.sraven0.tictactoe.gui;

import edu.saddleback.sraven0.tictactoe.model.Board;
import edu.saddleback.sraven0.tictactoe.model.Game;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sraven0
 */
public class MainWindow extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainWindow app = new MainWindow();
        app.setSize(150, 150);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    private JButton[] buttons;
    private JLabel status;
    private Game game;
    private Game.State state;

    private MainWindow() {
        super();
        game = new Game();
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        status = new JLabel();

        add(buttonPanel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        buttons = new JButton[Board.SIZE];
        for (int i = 0; i < Board.SIZE; i++) {
            JButton button = new JButton();
            buttons[i] = button;
            buttonPanel.add(button);
            button.addActionListener(new TicTacToeActionListener(i));
        }
        state = Game.State.Running;
        updateStatus();
    }

    private void updateStatus() {
        for (int i = 0; i < Board.SIZE; i++) {
            JButton button = buttons[i];
            button.setText(game.getBoard().tokenAt(i).toString());

        }
        String message = "";
        switch (state) {
            case Running:
                message = String.format("%s's turn", game.getCurrentPlayer());
                break;
            case Tied:
                message = "game died";
                break;
            case Won:
                message = String.format("%s didn't die", game.getCurrentPlayer());
                break;
            default:
                break;
        }

        status.setText(message);
        repaint();
        revalidate();
    }

    private class TicTacToeActionListener implements ActionListener {

        int pos;

        public TicTacToeActionListener(int i) {
            pos = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (state == Game.State.Running) {
                state = game.makeMove(pos);
            } else {
                game.newGame();
                state = Game.State.Running;
            }
            updateStatus();
        }

    }
}
