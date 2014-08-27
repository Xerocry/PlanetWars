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

    public Color getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void sendFleet(int numSent, Planet target){
            if(numSent > numShips)
            {
                numSent = numShips - 1;
            }
            if (numSent > 0)
            {
                for (int i = 0; i < numSent; i++) {
                    Ship ship = new Ship(target);
                }

                this.numShips -= numSent;
                target.numShips += numSent;
                System.out.println(numSent + "lost");
            }
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
