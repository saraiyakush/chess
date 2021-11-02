package org.technogise.chess;

import org.technogise.chess.exception.InvalidPositionException;

public class PieceFactory {
    public static Piece getPiece(Type type, int x, int y, ChessBoard board) throws InvalidPositionException {

        if (x >= board.getXLength() || y >= board.getYLength()) {
            throw new InvalidPositionException();
        }

        if (type.equals(Type.PAWN)) {
            return Pawn.Builder.getInstance()
                    .setxPosition(x)
                    .setyPosition(y)
                    .setBoard(board)
                    .build();
        }
        else if (type.equals(Type.KING)) {
            return King.Builder.getInstance()
                    .setxPosition(x)
                    .setyPosition(y)
                    .setBoard(board)
                    .build();
        }
        else if (type.equals(Type.QUEEN)) {
            return Queen.Builder.getInstance()
                    .setxPosition(x)
                    .setyPosition(y)
                    .setBoard(board)
                    .build();
        }
        return null;
    }
}
