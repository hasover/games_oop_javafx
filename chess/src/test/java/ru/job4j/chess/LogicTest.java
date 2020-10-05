package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenCanMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure kingBlack = new KingBlack(Cell.C2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(kingBlack);
        logic.move(bishopBlack.position(), Cell.F4);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenCannotMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure kingBlack = new KingBlack(Cell.D2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(kingBlack);
        logic.move(bishopBlack.position(), Cell.F4);
    }
}