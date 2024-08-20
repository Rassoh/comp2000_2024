import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Grid grid = new Grid();
      List<Point> mousePositions = new LinkedList<>(); // Stores the mouse position

      Timer trailUpdateTimer;
      Timer repaintTimer;
      Point lastMousePos = null;


      public Canvas() {
        setPreferredSize(new Dimension(720, 720));

        trailUpdateTimer = new Timer(30, e -> {
          if (lastMousePos != null){
            //Add the last mouse position to the list
            mousePositions.add(new Point(lastMousePos));
            //Keep only the last 100 positions
            if (mousePositions.size() > 100){
              mousePositions.remove(0);
            }
            //Trigger to repaint showing updated trails
            repaint();
          }
        });

        trailUpdateTimer.start();

      //Timer to repaint canvas
      repaintTimer = new Timer(16, e -> repaint());
      repaintTimer.start();
        addMouseMotionListener(new MouseMotionAdapter() {
          
     
          @Override
          public void mouseMoved(MouseEvent e) {
            lastMousePos = e.getPoint();
         
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
  
} }
