package sec04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsAndMouseDragging extends JFrame {
	Container contentPane;
	public GraphicsAndMouseDragging() {
		setTitle("GraphicsClip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/call.png");
		Image img = icon.getImage();
		int ovalX=100, ovalY=100;
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.GREEN);
			g.fillOval(ovalX, ovalY, 20, 20);
		}
	}
	public static void main(String[] args) {
		new GraphicsAndMouseDragging();
	}

}
