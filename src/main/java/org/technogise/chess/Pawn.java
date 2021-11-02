package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete class to simulate Pawn on the board
 */
public class Pawn extends Piece {

    public Pawn(Builder builder) {
        // Define the type and max steps for this class
        super(Type.PAWN,
                builder.xPosition, builder.yPosition,
                builder.verticalSteps, builder.horizontalSteps, builder.diagonalSteps,
                builder.board);
    }

    public static class Builder {
        private int xPosition;
        private int yPosition;
        private int verticalSteps = 1;
        private int horizontalSteps = 0;
        private int diagonalSteps = 0;
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

        public Pawn build() {
            return new Pawn(this);
        }
    }

    @Override
    public Set<Position> getAllMoveablePositions() {

        Set<Position> moveablePositions = new HashSet<>();

        int count = 0;
        int nextPosition = getPosition().getY() + 1;
        while (count < getVerticalSteps() && nextPosition < getBoard().getYLength()) {
            moveablePositions.add(new Position(getPosition().getX(), nextPosition));
            nextPosition++;
            count++;
        }
        return moveablePositions;
    }
}
