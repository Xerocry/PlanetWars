import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Андрей2 on 26.08.14.
 */
public class PlanetPanel extends JPanel {
    private ArrayList<Planet> planets = new ArrayList<Planet>();

    public PlanetPanel() {
        planets.add(new Planet((int)(Math.random()*50), 300, 150, 50, new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random())));
        planets.add(new Planet((int)(Math.random()*50), 200, 350, 60, new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random())));
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
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
        for (Planet planet : planets) {
            g2d.setColor(planet.getColor());
            g2d.fillOval((int) planet.getX() - planet.getRadius(),
                    (int) planet.getY()- planet.getRadius(), planet.getRadius()*2, planet.getRadius()*2);
            g2d.setFont(new Font("Serif", Font.PLAIN, 20));
            g2d.setColor(Color.black);
            String s = String.valueOf(planet.numShips);
            FontMetrics fm = g2d.getFontMetrics();
            double textWidth = fm.getStringBounds(s, g2d).getWidth();
            g2d.drawString(s, (int) ((int) planet.getX() - textWidth/2), ((int) planet.getY() + (fm.getMaxAscent()-fm.getMaxDescent()) / 2));
        }
    }
}
