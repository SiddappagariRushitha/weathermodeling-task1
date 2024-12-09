Rushitha reddy
BU22CSEN0100799


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

Sahana
BU22CSENOLO2206
import javax.swing.*;
import java.awt.*;
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
            double y = a * Math.pow(x, 2) + b * x + c;
            int scaledX = originX + x;
            int scaledY = originY - (int) y;

            // Draw the point on the graph
            g2d.fillRect(scaledX, scaledY, 1, 1)
        }
    }

  public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Upper Parabola Graph");
        double a = 1, b = -6, c = 8;  
        weathermodeling graph = new weathermodeling(a, b, c);
        frame.add(graph);
        frame.setSize(800, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
   
}

Deepika
BU22CSENO102215


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class WeatherModeling extends JPanel {
    private double a, b, c;
    public WeatherModeling(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int originX = width / 2;  
        int originY = height / 2; 
        int scale = 10;
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, originY, width, originY);  
        g2d.drawLine(originX, 0, originX, height);
        g2d.setColor(Color.GREEN);
        for (int x = -originX / scale; x < originX / scale; x++) {
            double y1 = a * Math.pow(x, 2) + b * x + c;
            double y2 = a * Math.pow(x + 1, 2) + b * (x + 1) + c;
            int scaledX1 = originX + x * scale;
            int scaledY1 = originY - (int) (y1 * scale);
            int scaledX2 = originX + (x + 1) * scale;
            int scaledY2 = originY - (int) (y2 * scale);
            g2d.drawLine(scaledX1, scaledY1, scaledX2, scaledY2);
        }
    }

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame("Weather Modeling - Quadratic Graph");
        System.out.println("Stage 1: Hard-coded example");
        double a = -1, b = 3, c = 5; // Hardcoded coefficients
        frame.add(new WeatherModeling(a, b, c));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Close this graph to proceed to the next stage.");
        System.out.println("Stage 2: Keyboard Input");
        System.out.print("Enter coefficients (a, b, c): ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        frame.getContentPane().removeAll();
        frame.add(new WeatherModeling(a, b, c));
        frame.revalidate();
        frame.repaint();
        JOptionPane.showMessageDialog(frame, "Close this graph to proceed to the next stage.");
        System.out.println("Stage 3: File Input");
        System.out.print("Enter the filename containing coefficients: ");
        String filename = scanner.next();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] coefficients = line.split(",");
                a = Double.parseDouble(coefficients[0].trim());
                b = Double.parseDouble(coefficients[1].trim());
                c = Double.parseDouble(coefficients[2].trim());
                frame.getContentPane().removeAll(); 
                frame.add(new WeatherModeling(a, b, c));
                frame.revalidate();
                frame.repaint();
                JOptionPane.showMessageDialog(frame, "Close this graph to proceed to the next set of inputs.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid file format. Ensure coefficients are in the format: a,b,c");
        }

        scanner.close();
    }
}


namitha
BU22CSEN0100875


import javax.swing.*;
import java.awt.*;
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
            double y = a * Math.pow(x, 2) + b * x + c;
            int scaledX = originX + x;
            int scaledY = originY - (int) y;

  // Draw the point on the graph
            g2d.fillRect(scaledX, scaledY, 1, 1)
        }
    }

   public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Upper Parabola Graph");
        double a = 1, b = -6, c = 8;  
        weathermodeling graph = new weathermodeling(a, b, c);
        frame.add(graph);
        frame.setSize(800, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
   
}



manya
BU22CSEN0102198

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class WeatherModeling extends JPanel {
    private static final List<Double> xValues = new ArrayList<>();
    private static final List<Double> yValues = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Hardcoded Inputs\n2. Keyboard Inputs\n3. File Inputs\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            if (choice == 4) break;
            switch (choice) {
                case 1 -> hardcodedInputs();
                case 2 -> keyboardInputs(scanner);
                case 3 -> fileInputs();
                default -> System.out.println("Invalid choice.");
            }
                if (!xValues.isEmpty() && !yValues.isEmpty()) {
                SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Parabola Graph");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new WeatherModeling());
                    frame.setSize(800, 600);
                    frame.setVisible(true);
                });
            }
        }
        scanner.close();
    }
    private static void hardcodedInputs() {
        computeValues(1, 2, 3);
        System.out.println("Graph generated using hardcoded inputs.");
    }
    private static void keyboardInputs(Scanner scanner) {
        System.out.print("Enter a, b, c: ");
        computeValues(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Graph generated using keyboard inputs.");
    }
    private static void fileInputs() {
        try (Scanner fileReader = new Scanner(new File("input.txt"))) {
            xValues.clear();
            yValues.clear();
            while (fileReader.hasNextLine()) {
                String[] values = fileReader.nextLine().split(" ");
                if (values.length != 4) continue;
                double a = Double.parseDouble(values[0]);
                double b = Double.parseDouble(values[1]);
                double c = Double.parseDouble(values[2]);
                double x = Double.parseDouble(values[3]);
                double y = -a * Math.pow(x, 2) + b * x + c;
                xValues.add(x);
                yValues.add(y);
            }
            System.out.println("Graph generated using file inputs.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private static void computeValues(double a, double b, double c) {
        xValues.clear();
        yValues.clear();
        for (double x = -10; x <= 10; x += 0.5) {
            double y = -a * x * x + b * x + c;
            xValues.add(x);
            yValues.add(y);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth(), height = getHeight();
        int originX = width / 2, originY = height / 2;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawLine(0, originY, width, originY);
        g2d.drawLine(originX, 0, originX, height);
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < xValues.size() - 1; i++) {
            int x1 = (int) (originX + xValues.get(i) * 20);
            int y1 = (int) (originY - yValues.get(i) * 20);
            int x2 = (int) (originX + xValues.get(i + 1) * 20);
            int y2 = (int) (originY - yValues.get(i + 1) * 20);
            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}

