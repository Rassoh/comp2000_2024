import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Grid grid = new Grid();
      List<Point> mousePositions = new LinkedList<>();

      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
        addMouseMotionListener(new MouseMotionAdapter() {
          
     
          @Override
          public void mouseMoved(MouseEvent e) {
            // Add the current mouse position
            mousePositions.add(e.getPoint());
            // Keep only last 100 positions
            if (mousePositions.size() > 100) {
              mousePositions.remove(0);
            }
            repaint();
          }
        });
      }

      @Override
      public void paint(Graphics g) {
        super.paint(g);
        grid.paint(g, null, mousePositions);
      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
       /*try {
        Thread.sleep(16);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }*/
    } 
} }
