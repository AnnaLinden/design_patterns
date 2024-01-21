package FACTORY_METHOD;

import java.util.List;
import java.util.Random;

public class CityMap implements Map {

    private Tile[][] grid;
    private int size = 5;

    public CityMap() {

        grid = new Tile[size][size];
        generateMap();
    }

    @Override
    public Tile createTile() {
        List<Tile> tiles = List.of(new RoadTile(), new BuildingTile(), new ForestTile());
        return tiles.get(new Random().nextInt(tiles.size()));
    }

    private void generateMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = createTile();
            }
        }
    }

    @Override
    public void diaplay() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

}
