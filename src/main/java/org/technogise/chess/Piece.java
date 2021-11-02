package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class Piece to simulate any piece on the board
 */
public abstract class Piece {

    private Type type;  // King, Queen, Pawn etc.
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

    public Type getType() {
        return type;
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

    /*public Set<Position> getAllMoveablePositions() {

        Set<Position> moveablePositions = new HashSet<>();

        moveablePositions.addAll(getAllVerticalPositions());
        moveablePositions.addAll(getAllHorizontalPositions());
        moveablePositions.addAll((getAllDiagonalPositions()));

        return moveablePositions;
    }

    public Set<Position> getAllVerticalPositions() {
        Set<Position> moveablePositions = new HashSet<>();

        // If the piece can move in vertical position
        if (verticalSteps > 0) {
            // Vertical positions (upwards)
            int count = 0;
            Position next = new Position(getPosition().getX(), getPosition().getY() + 1);
            while (count < getVerticalSteps() && next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(getPosition().getX(), next.getY()));
                next = new Position(next.getX(), next.getY() + 1);
                count++;
            }

            if (backward) {
                // Vertical positions (downwards)
                count = 0;
                next = new Position(getPosition().getX(), getPosition().getY() - 1);
                while (count < getVerticalSteps() && next.getY() >= 0) {
                    moveablePositions.add(new Position(getPosition().getX(), next.getY()));
                    next = new Position(next.getX(), next.getY() - 1);
                    count++;
                }
            }
        }
        else if (verticalSteps < 0) {
            // Vertical positions (upwards)
            int count = 0;
            Position next = new Position(getPosition().getX(), getPosition().getY() + 1);
            while (next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(getPosition().getX(), next.getY()));
                next = new Position(next.getX(), next.getY() + 1);
                count++;
            }

            if (backward) {
                // Vertical positions (downwards)
                count = 0;
                next = new Position(getPosition().getX(), getPosition().getY() - 1);
                while (next.getY() >= 0) {
                    moveablePositions.add(new Position(getPosition().getX(), next.getY()));
                    next = new Position(next.getX(), next.getY() - 1);
                    count++;
                }
            }
        }

        return moveablePositions;
    }

    public Set<Position> getAllHorizontalPositions() {
        Set<Position> moveablePositions = new HashSet<>();

        if(horizontalSteps > 0) {
            // Horizontal positions (right)
            int count = 0;
            Position next = new Position(getPosition().getX() + 1, getPosition().getY());
            while (count < getHorizontalSteps() && next.getX() < getBoard().getXLength()) {
                moveablePositions.add(new Position(next.getX(), getPosition().getY()));
                next = new Position(next.getX() + 1, next.getY());
                count++;
            }

            if (backward) {
                // Horizontal positions (left)
                count = 0;
                next = new Position(getPosition().getX() - 1, getPosition().getY());
                while (count < getHorizontalSteps() && next.getX() >= 0) {
                    moveablePositions.add(new Position(next.getX(), getPosition().getY()));
                    next = new Position(next.getX() - 1, next.getY());
                    count++;
                }
            }
        }
        else if (horizontalSteps < 0) {
            // Horizontal positions (right)
            int count = 0;
            Position next = new Position(getPosition().getX() + 1, getPosition().getY());
            while (next.getX() < getBoard().getXLength()) {
                moveablePositions.add(new Position(next.getX(), getPosition().getY()));
                next = new Position(next.getX() + 1, next.getY());
                count++;
            }

            if (backward) {
                // Horizontal positions (left)
                count = 0;
                next = new Position(getPosition().getX() - 1, getPosition().getY());
                while (next.getX() >= 0) {
                    moveablePositions.add(new Position(next.getX(), getPosition().getY()));
                    next = new Position(next.getX() - 1, next.getY());
                    count++;
                }
            }
        }
        return moveablePositions;
    }

    public Set<Position> getAllDiagonalPositions() {
        Set<Position> moveablePositions = new HashSet<>();

        if (diagonalSteps > 0) {
            // Diagonal positions (up right)
            int count = 0;
            Position next = new Position(getPosition().getX() + 1, getPosition().getY() + 1);
            while (count < getDiagonalSteps()
                    && next.getX() < getBoard().getXLength()
                    && next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(next.getX(), next.getY()));
                next = new Position(next.getX() + 1, next.getY() + 1);
                count++;
            }

            if (backward) {
                // Diagonal positions (down left)
                count = 0;
                next = new Position(getPosition().getX() - 1, getPosition().getY() - 1);
                while (count < getDiagonalSteps()
                        && next.getX() >= 0
                        && next.getY() >= 0) {
                    moveablePositions.add(new Position(next.getX(), next.getY()));
                    next = new Position(next.getX() - 1, next.getY() - 1);
                    count++;
                }
            }

            // Diagonal positions (up left)
            count = 0;
            next = new Position(getPosition().getX() - 1, getPosition().getY() + 1);
            while (count < getDiagonalSteps()
                    && next.getX() >= 0
                    && next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(next.getX(), next.getY()));
                next = new Position(next.getX() - 1, next.getY() + 1);
                count++;
            }

            if (backward) {
                // Diagonal positions (down right)
                count = 0;
                next = new Position(getPosition().getX() + 1, getPosition().getY() - 1);
                while (count < getDiagonalSteps()
                        && next.getX() < getBoard().getXLength()
                        && next.getY() >= 0) {
                    moveablePositions.add(new Position(next.getX(), next.getY()));
                    next = new Position(next.getX() + 1, next.getY() - 1);
                    count++;
                }
            }
        }
        else if (diagonalSteps < 0) {
            // Diagonal positions (up right)
            int count = 0;
            Position next = new Position(getPosition().getX() + 1, getPosition().getY() + 1);
            while (next.getX() < getBoard().getXLength()
                    && next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(next.getX(), next.getY()));
                next = new Position(next.getX() + 1, next.getY() + 1);
                count++;
            }

            if (backward) {
                // Diagonal positions (down left)
                count = 0;
                next = new Position(getPosition().getX() - 1, getPosition().getY() - 1);
                while (next.getX() >= 0
                        && next.getY() >= 0) {
                    moveablePositions.add(new Position(next.getX(), next.getY()));
                    next = new Position(next.getX() - 1, next.getY() - 1);
                    count++;
                }
            }

            // Diagonal positions (up left)
            count = 0;
            next = new Position(getPosition().getX() - 1, getPosition().getY() + 1);
            while (next.getX() >= 0
                    && next.getY() < getBoard().getYLength()) {
                moveablePositions.add(new Position(next.getX(), next.getY()));
                next = new Position(next.getX() - 1, next.getY() + 1);
                count++;
            }

            if (backward) {
                // Diagonal positions (down right)
                count = 0;
                next = new Position(getPosition().getX() + 1, getPosition().getY() - 1);
                while (next.getX() < getBoard().getXLength()
                        && next.getY() >= 0) {
                    moveablePositions.add(new Position(next.getX(), next.getY()));
                    next = new Position(next.getX() + 1, next.getY() - 1);
                    count++;
                }
            }

        }

        return moveablePositions;
    }*/
}
