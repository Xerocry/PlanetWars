import javax.swing.*;

/**
 * Created by Андрей2 on 26.08.14.
 */

public class GameEngine {
    private PlanetPanel map;
    private ShipsPanel shipsPanel;

    public GameEngine() {
        map = new PlanetPanel();
        shipsPanel = new ShipsPanel(0);
        PlanetListener pl = new PlanetListener(map);
        map.addMouseListener(pl);
        map.addMouseMotionListener(pl);
    }

    public void start() {
        Thread increment = new Thread(new ShipsIncrement());
        increment.start();
        Thread render = new Thread(new Render());
        render.start();
    }

    private class ShipsIncrement implements Runnable {
        @Override
        public void run() {
            while (true) {
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

    public class Render implements Runnable{
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
            layeredPane.add(shipsPanel, new Integer(1));
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
