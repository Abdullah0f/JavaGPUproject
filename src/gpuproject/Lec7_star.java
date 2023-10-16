package gpuproject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;

public class Lec7_star extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SecureRandom random = new SecureRandom();

        int[] xPoints = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
        int[] yPoints = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };

        Graphics2D g2d = (Graphics2D) g;

        for (int count = 1; count < xPoints.length; count++) {
            // create the star--this does not draw the star

            // rotate around origin and draw stars in random colors
            for (int i = 1; i <= 20; i++) {
                GeneralPath star = new GeneralPath();
                // set the initial coordinate of the General Path
                star.moveTo(xPoints[0], yPoints[0]);
                star.lineTo(xPoints[count], yPoints[count]);
                star.closePath(); // close the shape
                g2d.translate(150, 150); // translate the origin to (150, 150)
                g2d.rotate(Math.PI / 10.0); // rotate coordinate system

                // set random drawing color
                g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
        }
    }
}
