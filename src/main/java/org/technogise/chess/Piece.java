package org.technogise.chess;

import java.util.Set;

public abstract class Piece {

    private Type type;  // org.technogise.chess.King, org.technogise.chess.Queen, Oawn etc.
    private Position position;  // X and Y position on the board
    private ChessBoard board;   // The board where this piece is placed

    private final int verticalSteps;    // No. of vertical steps
    private final int horizontalSteps;  // No. of horizontal steps
    private final int diagonalSteps;    // No. of diagonal steps

    public Piece(Type type, int x, int y, int verticalSteps, int horizontalSteps, int diagonalSteps, ChessBoard board) {
        this.type = type;
        this.position = new Position(x, y);
        this.board = board;

        this.verticalSteps = verticalSteps;
        this.horizontalSteps = horizontalSteps;
        this.diagonalSteps = diagonalSteps;
    }

    public Position getPosition() {
        return position;
    }

    public int getVerticalSteps() {
        return verticalSteps;
    }

    public int getHorizontalSteps() {
        return horizontalSteps;
    }

    public int getDiagonalSteps() {
        return diagonalSteps;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public abstract Set<Position> getAllMoveablePositions();
}
