import javax.swing.*;
import java.awt.*;

public class Rajz extends JPanel {
    private int n;
    private double[] x;
    private double[] y;

    public Rajz(int n, double[] x, double[] y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);
        g.setColor(Color.PINK);
        for (int i = 0; i < n; i++) {
            g.fillOval((int) (x[i]*100), (int) (y[i]*100), 10, 10);
        }
        repaint();
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public void setX(int i, double x) {
        this.x[i] = x;
    }

    public void setY(int i, double y) {
        this.y[i] = y;
    }
}
