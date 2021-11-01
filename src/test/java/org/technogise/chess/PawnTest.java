package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PawnTest {

    @Test
    public void returnsValidPositionsIfValidInput() {
        Piece pawn = new Pawn(2, 5, new ChessBoard(8, 8));
        HashSet<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(2, 6));

        assertEquals(expectedPositions, pawn.getAllMoveablePositions());
    }
}
