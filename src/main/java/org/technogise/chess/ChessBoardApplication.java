package org.technogise.chess;

import org.technogise.chess.exception.InvalidPositionException;

import java.util.Scanner;

public class ChessBoardApplication {

    /**
     * Validates the given string
     * @param inputStr Input from console
     * @return `true` if all checks pass, `false` otherwise.
     */
    private static boolean validateInput(String inputStr) {

        String validInput = "Input Example: KING 2 5 (Type X-Position Y-Position in that order)";

        if (inputStr == null || inputStr.isEmpty()) {
            System.err.println("No input received");
            System.out.println(validInput);
            return false;
        }

        String[] input = inputStr.split(" ");

        if (input.length < 3) {
            System.err.println("Invalid input format");
            System.out.println(validInput);
            return false;
        }

        try {
            Integer.parseInt(input[1]);
            Integer.parseInt(input[2]);
        } catch (NumberFormatException e) {
            System.err.println("Input must be STRING NUMBER NUMBER");
            System.out.println(validInput);
            return false;
        }
        return true;
    }

    private static void play(String[] inputs) {
        // Initialize board
        ChessBoard board = new ChessBoard(10, 10);

        // Initialize a piece on the board
        try {
            Piece piece = PieceFactory.getPiece(Type.valueOf(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), board);

            // Print all positions
            if (piece != null) {
                piece.getAllMoveablePositions().forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid piece type -> " + inputs[0]);
            System.out.println("Valid pieces: KING, QUEEN, PAWN");
        } catch (InvalidPositionException pe) {
            System.err.println("Invalid position on board -> [" + inputs[1] + ", " + inputs[2] + "]");
            System.out.println("Valid positions: [0, 0] -> [7, 7]");
        }
    }


    public static void main(String[] args) {

        // Get user input
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        // Validate input
        if (!validateInput(inputStr)) {
            return;
        }

        String[] input = inputStr.split(" ");   // Space as separator
        play(input);

    }

}
