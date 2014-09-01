import java.awt.*;

/**
 * Created by Андрей2 on 26.08.14.
 */
public class Planet extends SpaceObject {
    private int radius;
    private Color color;
    public int numShips;

//    private int owner;
//    private int growthRate;


    public void setNumShips(int numShips) {
        this.numShips = numShips;
    }

    public Color getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void sendFleet(int numSent, Planet target){

    }

    public Planet(
//          int owner,
            int numShips,
            double x,
            double y,
            int rad,
            Color color) {
//            this.owner = owner;
//            this.growthRate = growthRate;
        setX(x);
        setY(y);
        radius = rad;
        this.color = color;
        this.numShips = numShips;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
