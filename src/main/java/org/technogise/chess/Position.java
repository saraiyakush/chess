package org.technogise.chess;

import java.util.Objects;

public class Position {
    private int x;  // X position on the board
    private int y;  // Y position on the board

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[" +
                " x=" + x +
                ", y=" + y +
                " ]";
    }
}
