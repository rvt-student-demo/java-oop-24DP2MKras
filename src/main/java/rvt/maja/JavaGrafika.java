package rvt.maja;

import javax.swing.JFrame;

public class JavaGrafika {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java grafika");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 768);
        GrafiskaisPanelis maja = new GrafiskaisPanelis();
        frame.add(maja);
        frame.setVisible(true);
    }
}
