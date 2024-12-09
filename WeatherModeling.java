import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class weathermodeling extends JPanel {
    private double a, b, c;
    public weathermodeling(double a, double b, double c) {
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
        g2d.setColor(Color.RED);
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
        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame("Quadratic Equation Graph");
        System.out.println("Enter the coefficients of the quadratic equation (a, b, c): ");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        weathermodeling graph = new weathermodeling(a, b, c);
        frame.add(graph);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Close this graph to enter new coefficients.");
        scanner.close();
    }
}