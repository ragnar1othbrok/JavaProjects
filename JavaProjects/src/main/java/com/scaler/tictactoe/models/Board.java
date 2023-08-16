package com.scaler.tictactoe.models;

import java.util.List;

public class Board {
    private int size ;
    private List<List<Cell>> Board ;

    public Board(int dimension) {

    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return Board;
    }

    public void setBoard(List<List<Cell>> board) {
        Board = board;
    }
}
