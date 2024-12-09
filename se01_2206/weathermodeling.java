import javax.swing.*;
import java.awt.*;
public class weathermodeling extends JPanel {
    private int a, b, c;
public weathermodeling(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int originX = width / 2; 
        int originY = height / 2; 

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, originY, width, originY); 
        g2d.drawLine(originX, 0, originX, height); 
        g2d.setColor(Color.BLUE);
        for (int x = -originX; x < originX; x++) {
            double y1 = a * Math.pow(x, 2) + b * x + c;
            double y2 = a * Math.pow(x + 1, 2) + b * (x + 1) + c;
            int scaledX1 = originX + x;
            int scaledY1 = originY - (int) y1;
            int scaledX2 = originX + (x + 1);
            int scaledY2 = originY - (int) y2;
            g2d.drawLine(scaledX1, scaledY1, scaledX2, scaledY2);
        }
    }
public static void main(String[] args) {
 // Set coefficients for the quadratic equation: y = ax^2 + bx + c
        int a = 1;  
        int b = -2;
        int c = -3; 
        JFrame frame = new JFrame("Quadratic Graph");
        weathermodeling graph = new weathermodeling(a, b, c);
        frame.add(graph);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}