package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void validBoardSquareAt() {
        Square[][] grid = {
            { new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThat(board.squareAt(0, 0)).isNotNull();
    }

    @Test
    void invalidBoard() {
        Square[][] grid = {
            { null }
        };

        assertThrows(AssertionError.class, () -> new Board(grid));
    }

    @Test
    void testGetWidth() {
        Square[][] grid = {
            { new BasicSquare() },
            { new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThat(board.getWidth()).isEqualTo(2);
    }

    @Test
    void testGetHeight() {
        Square[][] grid = {
            { new BasicSquare(), new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThat(board.getHeight()).isEqualTo(2);
    }

    @Test
    void testWithinBorders() {
        Square[][] grid = {
            { new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThat(board.withinBorders(0, 0)).isTrue();
        assertThat(board.withinBorders(1, 0)).isFalse();
        assertThat(board.withinBorders(0, 1)).isFalse();
        assertThat(board.withinBorders(-1, 0)).isFalse();
    }

    @Test
    void testSquareAtOutsideBoard() {
        Square[][] grid = {
            { new BasicSquare() }
        };

        Board board = new Board(grid);

        assertThrows(AssertionError.class, () -> board.squareAt(1, 0));
    }
}
