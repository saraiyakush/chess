package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete class to simulate King on the board
 */
public class King extends Piece {

    public King(int x, int y, ChessBoard board) {
        // Define the type and max steps for this class
        super(Type.KING, x, y, 1, 1, 1, board);
    }

    @Override
    public Set<Position> getAllMoveablePositions() {
        Set<Position> moveablePositions = new HashSet<>();

        // Vertical positions (upwards)
        int count = 0;
        Position next = new Position(getPosition().getX(), getPosition().getY() + 1);
        while (count < getVerticalSteps() && next.getY() < getBoard().getYLength()) {
            moveablePositions.add(new Position(getPosition().getX(), next.getY()));
            next = new Position(next.getX(), next.getY() + 1);
            count++;
        }

        // Vertical positions (downwards)
        count = 0;
        next = new Position(getPosition().getX(), getPosition().getY() - 1);
        while (count < getVerticalSteps() && next.getY() >= 0) {
            moveablePositions.add(new Position(getPosition().getX(), next.getY()));
            next = new Position(next.getX(), next.getY() - 1);
            count++;
        }

        // Horizontal positions (right)
        count = 0;
        next = new Position(getPosition().getX() + 1, getPosition().getY());
        while (count < getHorizontalSteps() && next.getX() < getBoard().getXLength()) {
            moveablePositions.add(new Position(next.getX(), getPosition().getY()));
            next = new Position(next.getX() + 1, next.getY());
            count++;
        }

        // Horizontal positions (left)
        count = 0;
        next = new Position(getPosition().getX() - 1, getPosition().getY());
        while (count < getHorizontalSteps() && next.getX() >= 0) {
            moveablePositions.add(new Position(next.getX(), getPosition().getY()));
            next = new Position(next.getX() - 1, next.getY());
            count++;
        }

        // Diagonal positions (up right)
        count = 0;
        next = new Position(getPosition().getX() + 1, getPosition().getY() + 1);
        while (count < getDiagonalSteps()
                && next.getX() < getBoard().getXLength()
                && next.getY() < getBoard().getYLength()) {
            moveablePositions.add(new Position(next.getX(), next.getY()));
            next = new Position(next.getX() + 1, next.getY() + 1);
            count++;
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

        return moveablePositions;
    }
}
