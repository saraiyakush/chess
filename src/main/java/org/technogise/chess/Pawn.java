package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    public Pawn(int x, int y, ChessBoard board) {
        super(Type.PAWN, x, y, 1, 0, 0, board);
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
