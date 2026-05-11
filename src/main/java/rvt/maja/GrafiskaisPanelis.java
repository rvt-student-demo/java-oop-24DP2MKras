package rvt.maja;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;
public class GrafiskaisPanelis extends JPanel{
    public GrafiskaisPanelis(){

    }
    public GrafiskaisPanelis(LayoutManager layout) {
        super(layout);
    }
    public GrafiskaisPanelis(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }
    public GrafiskaisPanelis(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(500, 350, 350, 400);
        g.setColor(Color.BLACK);
        g.drawLine(850, 350, 675, 200);
        g.drawLine(500, 350, 675, 200);
        g.setColor(Color.RED);
    }
}
