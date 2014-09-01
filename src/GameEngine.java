import javax.swing.*;

/**
 * Created by Андрей2 on 26.08.14.
 */

public class GameEngine {
    private PlanetPanel map;
    private ShipsPanel shipsPanel;

    public void stop(Thread thread) {
        thread = null;
        deleteShips();
    }

    public ShipsPanel getShipsPanel() {
        return shipsPanel;
    }

    public void deleteShips() {
        shipsPanel.deleteShips();
    }

    public GameEngine() {
        map = new PlanetPanel();
        shipsPanel = new ShipsPanel();
        PlanetListener pl = new PlanetListener(this, map);
        map.addMouseListener(pl);
        map.addMouseMotionListener(pl);
    }

    public void start() {
        Thread increment = new Thread(new ShipsIncrement());
        increment.start();
        Thread render = new Thread(new Render());
        render.start();
    }

    public void startMove(int numSent, Planet start, Planet end) {

//        if (numSent > start.numShips) {
//            numSent = start.numShips - 1;
//        }
        start.numShips -= numSent;
        for (int i = 0; i < numSent; i++) {
            Ship ship = new Ship(start, end);
            shipsPanel.addShip(ship);
//            System.out.println(shipsP?anel.getAmount());
            ShipProcessor shipProc = new ShipProcessor(this, ship);
            shipProc.start();
        }

//        System.out.println(shipsPanel.getFleet() + "");
//        start.numShips -= numSent;
//        end.numShips += numSent;

    }

    private class ShipsIncrement implements Runnable {
        @Override
        public void run() {
            while (true) {
                deleteShips();
                for (Planet planet : map.getPlanets()) {
                    planet.numShips++;
                    map.updateUI();
                    try {
                        Thread.sleep((long) (Math.random() * 200));
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
    }

    private class Render implements Runnable{
        @Override
        public void run() {
            JFrame mainWind = new JFrame();
            mainWind.setSize(500, 500);
            mainWind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWind.setTitle("Planet Wars");
            JLayeredPane layeredPane = mainWind.getLayeredPane();
            map.setOpaque(false);
            map.setSize(500,500);
            shipsPanel.setSize(500,500);
            shipsPanel.setOpaque(false);
            layeredPane.add(map, new Integer(1));
            layeredPane.add(shipsPanel, new Integer(2));
            mainWind.setVisible(true);
            while (true) {
                map.updateUI();
                shipsPanel.updateUI();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignored) {}
            }
        }
    }
}


