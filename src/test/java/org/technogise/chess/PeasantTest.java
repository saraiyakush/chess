package org.technogise.chess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PeasantTest {
    @Test
    public void getAllMoveablePositions_returnsValidPositions() {
        Piece peasant = new Peasant(3, 3, new ChessBoard(8, 8));

        Set<Position> expectedPositions = new HashSet<>();
        expectedPositions.add(new Position(4, 4));
        expectedPositions.add(new Position(2, 4));

        assertEquals(expectedPositions, peasant.getAllMoveablePositions());
        assertEquals(expectedPositions.size(), peasant.getAllMoveablePositions().size());

    }


}
