package org.technogise.chess;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.technogise.chess.exception.InvalidPositionException;

@RunWith(JUnit4.class)
public class PieceFactoryTest {

    @Test
    public void getPiece_returnsPawnIfInputPawn() {

        assertTrue(PieceFactory.getPiece(Type.PAWN, 0, 0, new ChessBoard(8, 8)) instanceof Pawn);
    }

    @Test
    public void getPiece_returnsNullIfInputInvalid() {
        assertNull(PieceFactory.getPiece(Type.BISHOP, 0, 0, new ChessBoard(8, 8)));
    }

    @Test
    public void getPiece_throwsInvalidPositionExceptionIfNotValidPositionOnBoard() {
        assertThrows(InvalidPositionException.class, () -> PieceFactory.getPiece(Type.KING, 7, 9, new ChessBoard(8, 8)));
    }
}
