package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class KingTest {

    @Test
    public void returnsValidPositionsIfValidInput() {
        Piece king = new King(2, 5, new ChessBoard(8, 8));

        HashSet<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(2, 6));
        expectedPositions.add(new Position(2, 4));
        expectedPositions.add(new Position(3, 5));
        expectedPositions.add(new Position(1, 5));
        expectedPositions.add(new Position(3, 6));
        expectedPositions.add(new Position(1, 6));
        expectedPositions.add(new Position(3, 4));
        expectedPositions.add(new Position(1, 4));

        assertEquals(expectedPositions, king.getAllMoveablePositions());
    }
}
