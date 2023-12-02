package uk.co.mrdaly.adventofcode2023.util.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public void moveUp(int steps) {
        this.y += steps;
    }

    public void moveDown(int steps) {
        this.y -= steps;
    }

    public void moveLeft(int steps) {
        this.x -= steps;
    }

    public void moveRight(int steps) {
        this.x += steps;
    }

    public boolean isAdjacentTo(Position that) {
        boolean horizontallyAdjacent = that.x == this.x + 1 || that.x == this.x || that.x == this.x - 1;
        boolean verticallyAdjacent = that.y == this.y + 1 || this.y == that.y || that.y == this.y - 1;
        return horizontallyAdjacent && verticallyAdjacent;
    }

    public boolean isHorizontallyAdjacentTo(Position that) {
        return that.x == this.x + 1 || that.x == this.x || that.x == this.x - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
}