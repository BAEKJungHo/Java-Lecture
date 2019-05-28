package sec04;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class GraphicsDrawLineMouseEx extends JFrame {
	Container contentPane;
	GraphicsDrawLineMouseEx() {
		setTitle("GraphicsDrawLineMouseEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		Vector<Point> vs = new Vector<Point>();
		Vector<Point> ve = new Vector<Point>();
		
		Point startP = null;
		Point endP = null;
		
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					startP = e.getPoint();
				}
				public void mouseReleased(MouseEvent e) {
					endP = e.getPoint();
					vs.add(startP);
					vs.add(endP);
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i=0; i<vs.size(); i++) {
				Point s = vs.elementAt(i);
				Point e = ve.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}
}
