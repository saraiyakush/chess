## Introduction

This is a console application that simulates a chessboard and the movements of the following pieces on the board.

- PAWN
- KING
- QUEEN

## Package Structure

```
|____pom.xml        <-- Maven dependencies
|____README.md        <-- This readme file
|____.gitignore
|____src
| |____main
| | |____java
| | | |____org
| | | | |____technogise
| | | | | |____chess
| | | | | | |____Type.java        <-- Piece types i.e. KING, QUEEN
| | | | | | |____PieceFactory.java    <-- Creates piece based on type
| | | | | | |____ChessBoardApplication.java   <-- Main program
| | | | | | |____Position.java    <-- Position on the board (x, y)
| | | | | | |____Queen.java   <-- Concrete class Queen
| | | | | | |____King.java    <-- Concrete class King
| | | | | | |____ChessBoard.java    <-- Chess board
| | | | | | |____Piece.java   <-- Abstract class piece
| | | | | | |____Pawn.java    <-- Concrete class Pawn
| | | | | | |____exception
| | | | | | | |____InvalidPieceException.java
| | | | | | | |____InvalidPositionException.java
| |____test
| | |____java
| | | |____org
| | | | |____technogise
| | | | | |____chess
| | | | | | |____PawnTest.java
| | | | | | |____KingTest.java
| | | | | | |____PieceFactoryTest.java
| | | | | | |____QueenTest.java
| | | | | | |____ChessBoardApplicationTest.java

```

## Chessboard Layout

- The chess is an 8x8 grid with 8 rows and 8 columns.
- Rows and columns start with index 0 and end at index 7 i.e. bottom left position will be [0, 0] and top right position will be [7, 7].
- Each position on the board is represented as a two-dimensional array index i.e. [2, 3] where 2 is the position on X axis and 3 is the position on Y axis.
- Moving up/down changes the Y axis and moving right/left changes the X axis. E.g. If the current position is [2, 5] then next upward position will be [2, 6].

## Dependencies

- Java 8 or higher
- Maven

## Running the program

- **From IDE**

  1. Clone this repository
  2. Import in your IDE as a Maven project
  3. Run the class named `ChessBoardApplication`
  4. Enter your inputs in the console

- **From Console/Terminal**
  1. Clone this repository and `cd` into the folder
  2. Run `mvn clean install`
  3. Run `java -jar target/chess-1.0-SNAPSHOT-spring-boot.jar`
  4. Enter your inputs in the console

The program accepts the following arguments in that order.

```
PIECE X-POSITION Y-POSITION

Example:
KING 2 5
PAWN 1 1
QUEEN 3 4
```

The output of the program will be all the positions that a given piece can move from the initial position.

```
Example:
KING 1 1

Output:
[ x=1, y=2 ]
[ x=1, y=0 ]
[ x=2, y=1 ]
[ x=0, y=1 ]
[ x=2, y=2 ]
[ x=0, y=2 ]
[ x=2, y=0 ]
[ x=0, y=0 ]
```
