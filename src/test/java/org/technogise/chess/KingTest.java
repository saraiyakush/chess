package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class KingTest {

    @Test
    public void getAllMoveablePositions_returnsValidPositionsIfValidInput() {
        Piece king = King.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();

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

    @Test
    public void getAllMoveablePositions_doesNotReturnInvalidPositions() {
        Piece king = King.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();

        HashSet<Position> invalidPositions = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( (i != 2 || j != 6)
                        && (i != 2 || j != 4)
                        && (i != 3 || j != 5)
                        && (i != 1 || j != 5)
                        && (i != 3 || j != 6)
                        && (i != 1 || j != 6)
                        && (i != 3 || j != 4)
                        && (i != 1 || j != 4) ) {
                    invalidPositions.add(new Position(i, j));
                }
            }
        }

        assertFalse(king.getAllMoveablePositions().stream().anyMatch(invalidPositions::contains));
    }
}
