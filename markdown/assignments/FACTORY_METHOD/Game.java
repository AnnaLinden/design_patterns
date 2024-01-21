package FACTORY_METHOD;

public class Game {

    public static void main(String[] args) {
        Map map = createMap();
        map.display();
    }

    public static Map createMap() {
        return new WildernessMap();
    }

}
