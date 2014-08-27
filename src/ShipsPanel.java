import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Андрей2 on 26.08.14.
 */
public class ShipsPanel extends JPanel {
    private ArrayList<Ship> fleet;

    public ShipsPanel() {
        fleet = new ArrayList<Ship>(null);
    }

    public ShipsPanel(int numShips) {
       fleet = new ArrayList<Ship>(numShips);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        for (Ship sheep : fleet) {
            g2d.setColor(Color.green);

//            Point p1 = new Point (size.width / 3, (2 * size.height) / 3);
//            Point p2 = new Point(size.width / 2, size.height / 3);
//            Point p3 = new Point((2 * size.width) / 3, (2 * size.height) / 3);
//            int[] x = { p1.x, p2.x, p3.x };
//            int[] y = { p1.y, p2.y, p3.y };
//            Polygon triangle = new Polygon(x, y, x.length);
        }
    }
}
