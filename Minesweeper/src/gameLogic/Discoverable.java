package gameLogic;

import gameUtils.CellPosition;

import java.util.List;


public interface Discoverable {
    List<CellPosition> getNeighbours();

}
