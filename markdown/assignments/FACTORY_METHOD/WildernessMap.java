package FACTORY_METHOD;

public class WildernessMap implements Map {

    @Override
    public Tile createTile() {
        return new WaterTile();
    }

    @Override
    public void diaplay() {
        System.out.println("Wilderness Map");
    }

}
