package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class QueenTest {

    @Test
    public void returnsValidPositionsIfValidInput() {
        Piece queen = new Queen(2, 5, new ChessBoard(8, 8));

        HashSet<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(2, 6));
        expectedPositions.add(new Position(2, 7));
        expectedPositions.add(new Position(2, 4));
        expectedPositions.add(new Position(2, 3));
        expectedPositions.add(new Position(2, 2));
        expectedPositions.add(new Position(2, 1));
        expectedPositions.add(new Position(2, 0));

        expectedPositions.add(new Position(3, 5));
        expectedPositions.add(new Position(4, 5));
        expectedPositions.add(new Position(5, 5));
        expectedPositions.add(new Position(6, 5));
        expectedPositions.add(new Position(7, 5));
        expectedPositions.add(new Position(1, 5));
        expectedPositions.add(new Position(0, 5));

        expectedPositions.add(new Position(3, 6));
        expectedPositions.add(new Position(4, 7));
        expectedPositions.add(new Position(1, 4));
        expectedPositions.add(new Position(0, 3));

        expectedPositions.add(new Position(1, 6));
        expectedPositions.add(new Position(0, 7));
        expectedPositions.add(new Position(3, 4));
        expectedPositions.add(new Position(4, 3));
        expectedPositions.add(new Position(5, 2));
        expectedPositions.add(new Position(6, 1));
        expectedPositions.add(new Position(7, 0));


        assertEquals(expectedPositions, queen.getAllMoveablePositions());
    }
}
