package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class QueenTest {

    @Test
    public void getAllMoveablePositions_returnsValidPositionsIfValidInput() {
        Piece queen = Queen.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();

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

    @Test
    public void getAllMoveablePositions_doesNotReturnInvalidPositions() {
        Piece queen = Queen.Builder.getInstance()
                .setxPosition(2)
                .setyPosition(5)
                .setBoard(new ChessBoard(8, 8))
                .build();

        HashSet<Position> invalidPositions = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ( (i != 2 || j != 6)
                        && (i != 2 || j != 7)
                        && (i != 2 || j != 4)
                        && (i != 2 || j != 3)
                        && (i != 2 || j != 2)
                        && (i != 2 || j != 1)
                        && (i != 2 || j != 0)
                        && (i != 0 || j != 5)
                        && (i != 1 || j != 5)
                        && (i != 3 || j != 5)
                        && (i != 4 || j != 5)
                        && (i != 5 || j != 5)
                        && (i != 6 || j != 5)
                        && (i != 7 || j != 5)
                        && (i != 3 || j != 6)
                        && (i != 4 || j != 7)
                        && (i != 1 || j != 4)
                        && (i != 0 || j != 3)
                        && (i != 1 || j != 6)
                        && (i != 0 || j != 7)
                        && (i != 3 || j != 4)
                        && (i != 4 || j != 3)
                        && (i != 5 || j != 2)
                        && (i != 6 || j != 1)
                        && (i != 7 || j != 0)) {
                    invalidPositions.add(new Position(i, j));
                }
            }
        }

        assertFalse(queen.getAllMoveablePositions().stream().anyMatch(invalidPositions::contains));
    }

    @Test
    public void builder_returnsValidQueen() {
        Piece queen = Queen.Builder.getInstance().build();
        assertEquals(Type.QUEEN, queen.getType());
        assertEquals(-1, queen.getVerticalSteps());
        assertEquals(-1, queen.getHorizontalSteps());
        assertEquals(-1, queen.getDiagonalSteps());
    }
}
