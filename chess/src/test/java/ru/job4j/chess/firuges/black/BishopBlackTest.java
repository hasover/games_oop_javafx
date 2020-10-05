package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure newBishop = bishopBlack.copy(Cell.A5);
        assertThat(newBishop.position(),is(Cell.A5));
    }

    @Test
    public void testCopy() {
        Figure bishopBlack = new BishopBlack(Cell.F3);
        assertThat(bishopBlack.position(),is(Cell.F3));
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5),is( new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTestWayFails() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C2);
        bishopBlack.way(Cell.C6);
    }

}