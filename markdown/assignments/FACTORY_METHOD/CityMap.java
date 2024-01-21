package FACTORY_METHOD;

import java.util.List;
import java.util.Random;

public class CityMap implements Map {

    @Override
    public Tile createTile() {
        List<Tile> tiles = List.of(new RoadTile(), new BuildingTile(), new ForestTile());
        return tiles.get(new Random().nextInt(tiles.size()));
    }

    @Override
    public void diaplay() {
        System.out.println("City Map");
    }

}
