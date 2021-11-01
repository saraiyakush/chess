package org.technogise.chess;

public class ChessBoard {

    private final int xLength;
    private final int yLength;

    private final int[][] board;

    public ChessBoard(int xLength, int yLength) {
        board = new int[xLength][yLength];
        this.xLength = xLength;
        this.yLength = yLength;
    }

    public int getXLength() {
        return xLength;
    }

    public int getYLength() {
        return yLength;
    }
}
