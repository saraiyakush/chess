package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class PawnTest {

    @Test
    public void getAllMoveablePositions_returnsValidPositionsIfValidInput() {
        Piece pawn = Pawn.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();
        HashSet<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(2, 6));

        assertEquals(expectedPositions, pawn.getAllMoveablePositions());
    }

    @Test
    public void getAllMoveablePositions_doesNotReturnInvalidPositions() {
        Piece pawn = Pawn.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();

        HashSet<Position> invalidPositions = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 2 || j != 6) {
                    invalidPositions.add(new Position(i, j));
                }
            }
        }

        assertFalse(pawn.getAllMoveablePositions().stream().anyMatch(invalidPositions::contains));
    }

    @Test
    public void builder_returnsValidPawn() {
        Piece pawn = Pawn.Builder.getInstance().build();
        assertEquals(Type.PAWN, pawn.getType());
        assertEquals(1, pawn.getVerticalSteps());
        assertEquals(0, pawn.getHorizontalSteps());
        assertEquals(0, pawn.getDiagonalSteps());
    }
}
