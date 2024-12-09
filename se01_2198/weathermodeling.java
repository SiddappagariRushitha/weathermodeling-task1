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