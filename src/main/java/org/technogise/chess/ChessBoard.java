package org.technogise.chess;

import java.util.HashSet;
import java.util.Set;

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

    public Set<Position> getOccupiedPositions() {
        Set<Position> occupiedPositions = new HashSet<>();
        occupiedPositions.add(new Position(3, 3));

        return occupiedPositions;
    }
}
