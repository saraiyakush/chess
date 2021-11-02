package org.technogise.chess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Peasant extends Piece {
    public Peasant(int x, int y, ChessBoard board) {
        super(Type.PEASANT, x, y, 0, 0, 1, board);
    }

    @Override
    public Set<Position> getAllMoveablePositions() {
        Set<Position> moveablePositions = new HashSet<>();

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
        return moveablePositions;
    }
}
