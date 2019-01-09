package it.unive.dais.commandroid;

public class Board {
    private int[] board;
    private int size = 10;

    public Board() {
        board = new int[size];
        newGame();
    }

    private void newGame() {
        for (int i = 0; i  < board.length; i++) {
            board[i] = 0;
        }

//        currentPlayer = 'X';
//        ended = false;
    }
}
