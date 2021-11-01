package org.technogise.chess;

import org.technogise.chess.exception.InvalidPositionException;

public class PieceFactory {
    public static Piece getPiece(Type type, int x, int y, ChessBoard board) throws InvalidPositionException {

        if (x >= board.getXLength() || y >= board.getYLength()) {
            throw new InvalidPositionException();
        }

        if (type.equals(Type.PAWN)) {
            return new Pawn(x, y, board);
        }
        else if (type.equals(Type.KING)) {
            return new King(x, y, board);
        }
        else if (type.equals(Type.QUEEN)) {
            return new Queen(x, y, board);
        }
        return null;
    }
}
