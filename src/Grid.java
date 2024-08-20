import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class Grid {
  // fields
  Cell[][] cells = new Cell[20][20];
  
  // constructors
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(10+Cell.size*i, 10+Cell.size*j);
      }
    }
  }
  // methods
  public void paint(Graphics g, Point mousePos, List<Point> mousePositions) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
     //Draw mouse trails
  g.setColor(new Color(0,0,0,128)); 
  for (Point p : mousePositions) {
    if (p != null) {
      g.fillOval(p.x - 5, p.y - 5, 10, 10);
    }
  }
  }

}
