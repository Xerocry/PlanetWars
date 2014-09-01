/**
 * Created by Андрей2 on 29.08.14.
 */

public class ShipProcessor extends Thread{
    private static int delta = 1;
    GameEngine engine;
    private Ship ship;
    private Planet destination;

    public ShipProcessor(GameEngine engine, Ship ship) {
        this.destination = ship.getDestination();
        this.ship = ship;
        this.engine = engine;
    }
        @Override
        public void run() {
            while (Math.pow(destination.getX() - ship.getX(),2) +
                    Math.pow(destination.getY() - ship.getY(),2) >= Math.pow(destination.getRadius(), 2)) {
                double cosin = Math.abs((destination.getY() - ship.getY()) / (Math.sqrt(Math.pow((destination.getX() - ship.getX()), 2) + Math.pow((destination.getY() - ship.getY()), 2))));
                double yDelta = delta * cosin, xDelta = Math.sqrt(Math.pow(delta, 2) - Math.pow(yDelta, 2));
                if (ship.getX() > destination.getX())
                    ship.setX(ship.getX() - xDelta);
                else if (ship.getX() < destination.getX())
                    ship.setX(ship.getX() + xDelta);
                if (ship.getY() > destination.getY())
                    ship.setY(ship.getY() - yDelta);
                else if (ship.getY() < destination.getY())
                    ship.setY(ship.getY() + yDelta);
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException ignored) {
                }
            }
            ship.setArrived(true);
            ship.getDestination().numShips++;
            engine.stop(this);

        }
}
