/**
 * Created by Андрей2 on 26.08.14.
 */
public class Ship extends SpaceObject {
    private Planet owner;

    public Ship(Planet owner) {
        this.owner = owner;
    }

    //    private boolean hasHit()
//    {
//        double dx = target.X - x;
//        double dy = target.Y - y;
//        return (target.RADIUS * target.RADIUS > dx * dx + dy * dy);
//    }


}
