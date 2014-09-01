/**
 * Created by Андрей2 on 26.08.14.
 */
public class Ship extends SpaceObject {
    private Planet owner;
    private Planet destination;
    private boolean arrived = false;

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    public Ship(Planet owner, Planet destination) {
        this.x = (int)(Math.random()*500);
        this.y = (int)(Math.random()*500);

//        this.x = owner.getX();
//        this.y = owner.getY();
        this.owner = owner;
        this.destination=destination;
    }

    public Planet getDestination() {
        return destination;
    }

    public Planet getOwner() {
        return owner;
    }

}
