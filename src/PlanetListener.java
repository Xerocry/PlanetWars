import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Андрей2 on 27.08.14.
 */
public class PlanetListener implements MouseListener, MouseMotionListener{
    private Planet start, end;
    private boolean pressed;
    private PlanetPanel planetPanel;

    public PlanetListener(PlanetPanel planetPanel) {
        this.planetPanel = planetPanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Planet planet : planetPanel.getPlanets()){
            if(Math.pow(e.getX()-(int) planet.getX(),2)+
                    Math.pow(e.getY()-(int) planet.getY(),2) <= planet.getRadius()*planet.getRadius()){
                planetPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                start = planet;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (Planet planet : planetPanel.getPlanets()){
            if(Math.pow(e.getX()-(int) planet.getX(),2)+
                    Math.pow(e.getY()-(int) planet.getY(),2) <= planet.getRadius()*planet.getRadius()){
                end = planet;
                if(!planet.equals(start) && start!=null){
                    start.sendFleet((int)(start.numShips * 0.5), end);
                    planetPanel.setCursor(Cursor.getDefaultCursor());
                    return;
                }
            }
        }
        planetPanel.setCursor (Cursor.getDefaultCursor());

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
