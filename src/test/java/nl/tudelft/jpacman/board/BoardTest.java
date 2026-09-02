package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void validBoard() {
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
        Board board = new Board(grid);
        assertThat(board.squareAt(0, 0)).isNull();
    }
}
