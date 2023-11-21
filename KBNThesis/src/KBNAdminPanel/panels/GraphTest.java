package KBNAdminPanel.panels;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GraphTest extends JPanel {
    private int MAX_SCORE = 100;
    private static final int BORDER_GAP = 50;
    private static final int MOVE_AMOUNT = 10;
    private static final Color GRAPH_POINT_COLOR = Color.BLACK;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 8;
    private static final int Y_HATCH_CNT = 10;
    private List<List<Integer>> datasets;
    private List<String> date;

    // Define an array of colors for each dataset
    private static final Color[] LINE_COLORS = {Color.BLUE, Color.RED, Color.GREEN};

    public GraphTest(List<List<Integer>> datasets, int max, List<String> date) {
        this.datasets = datasets;
        this.MAX_SCORE = max;
        this.date = date;

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (date.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

        // Iterate over each dataset and draw its corresponding line
        for (int i = 0; i < datasets.size(); i++) {
            List<Integer> dataset = datasets.get(i);
            List<Point> graphPoints = new ArrayList<>();
            for (int j = 0; j < dataset.size(); j++) {
                int x1 = (int) (j * xScale + BORDER_GAP);
                int y1 = (int) ((MAX_SCORE - dataset.get(j)) * yScale + BORDER_GAP - MOVE_AMOUNT);
                graphPoints.add(new Point(x1, y1));
            }

            // Draw the graph lines for the current dataset
            Stroke oldStroke = g2.getStroke();
            g2.setColor(LINE_COLORS[i % LINE_COLORS.length]); // Cycle through colors
            g2.setStroke(GRAPH_STROKE);
            for (int j = 0; j < graphPoints.size() - 1; j++) {
                int x1 = graphPoints.get(j).x;
                int y1 = graphPoints.get(j).y;
                int x2 = graphPoints.get(j + 1).x;
                int y2 = graphPoints.get(j + 1).y;
                g2.drawLine(x1, y1, x2, y2);
            }

            g2.setStroke(oldStroke);
            g2.setColor(GRAPH_POINT_COLOR);

            // Draw the graph points for the current dataset
            for (Point point : graphPoints) {
                int x = point.x - GRAPH_POINT_WIDTH / 2;
                int y = point.y - GRAPH_POINT_WIDTH / 2;
                int ovalW = GRAPH_POINT_WIDTH;
                int ovalH = GRAPH_POINT_WIDTH;
                g2.fillOval(x, y, ovalW, ovalH);
            }
        }

        // Draw x and y axes, hatch marks, and labels
        drawAxesAndLabels(g2, xScale, yScale);
    }

    private void drawAxesAndLabels(Graphics2D g2, double xScale, double yScale) {
        // Draw x and y axes
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP - MOVE_AMOUNT, BORDER_GAP, BORDER_GAP - MOVE_AMOUNT);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP - MOVE_AMOUNT, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP - MOVE_AMOUNT);

        // Create hatch marks for y-axis
        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP) - MOVE_AMOUNT;
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);

            String label = Integer.toString((MAX_SCORE / Y_HATCH_CNT) * (i + 1));
            g2.drawString(label, x0 - 25, y0 + 5);
        }

        // Create hatch marks for x-axis
        for (int i = 0; i < date.size(); i++) {
            int x0 = (int) ((i * xScale) + BORDER_GAP);
            int x1 = x0;
            int y0 = getHeight() - BORDER_GAP;
            int y1 = y0 - GRAPH_POINT_WIDTH;
            g2.drawLine(x0, y0, x1, y1);

            String label = date.get(i);
            int labelWidth = g2.getFontMetrics().stringWidth(label);
            int labelHeight = g2.getFontMetrics().getHeight();
            Graphics2D g2d = (Graphics2D) g2.create();
            g2d.translate(x0, y0 + GRAPH_POINT_WIDTH + 15);
            g2d.rotate(-Math.PI / 2);
            g2d.drawString(label, -labelHeight - 5, 0);
            g2d.dispose();
        }
    }
}