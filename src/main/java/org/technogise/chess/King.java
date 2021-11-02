package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete class to simulate King on the board
 */
public class King extends Piece {

    public King(Builder builder) {
        // Define the type and max steps for this class
        super(Type.KING,
                builder.xPosition, builder.yPosition,
                builder.verticalSteps, builder.horizontalSteps, builder.diagonalSteps,
                builder.board);
    }

    public static class Builder {
        private int xPosition;
        private int yPosition;
        private int verticalSteps = 1;
        private int horizontalSteps = 1;
        private int diagonalSteps = 1;
        private ChessBoard board;

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder setxPosition(int xPosition) {
            this.xPosition = xPosition;
            return this;
        }

        public Builder setyPosition(int yPosition) {
            this.yPosition = yPosition;
            return this;
        }

        public Builder setVerticalSteps(int verticalSteps) {
            this.verticalSteps = verticalSteps;
            return this;
        }

        public Builder setHorizontalSteps(int horizontalSteps) {
            this.horizontalSteps = horizontalSteps;
            return this;
        }

        public Builder setDiagonalSteps(int diagonalSteps) {
            this.diagonalSteps = diagonalSteps;
            return this;
        }

        public Builder setBoard(ChessBoard board) {
            this.board = board;
            return this;
        }

        public King build() {
            return new King(this);
        }
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
