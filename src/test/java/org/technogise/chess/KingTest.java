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
                .setyPosition(4)
                .setBoard(new ChessBoard(8, 8))
                .build();

        HashSet<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(2, 5));
        expectedPositions.add(new Position(2, 3));
        expectedPositions.add(new Position(3, 5));
        expectedPositions.add(new Position(1, 5));
        expectedPositions.add(new Position(3, 4));
        expectedPositions.add(new Position(1, 4));
        expectedPositions.add(new Position(1, 3));

        assertEquals(expectedPositions, king.getAllMoveablePositions());
        assertEquals(expectedPositions.size(), king.getAllMoveablePositions().size());
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

    @Test
    public void builder_returnsValidKing() {
        Piece king = King.Builder.getInstance().build();
        assertEquals(Type.KING, king.getType());
        assertEquals(1, king.getVerticalSteps());
        assertEquals(1, king.getHorizontalSteps());
        assertEquals(1, king.getDiagonalSteps());
    }
}
