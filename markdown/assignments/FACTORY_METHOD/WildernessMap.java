package FACTORY_METHOD;

import java.util.List;
import java.util.Random;

public class WildernessMap implements Map {

    private Tile[][] grid; // 2D array to store tiles
    private int size = 5;

    public WildernessMap() {
        grid = new Tile[size][size];
        generateMap();
    }

    @Override
    public Tile createTile() {
        List<Tile> tiles = List.of(new SwampTile(), new WaterTile(), new ForestTile());
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
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

}
