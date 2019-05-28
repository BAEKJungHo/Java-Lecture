package sec04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsDrawImageEx1 extends JFrame {
	Container contentPane;
	GraphicsDrawImageEx1() {
		setTitle("drawImage 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/call.png");
		Image image = imageIcon.getImage();

		public void paintComponent(Graphics g) {
			System.out.println("paintComponent 호출"); // Panel 크기를 늘릴때 마다 호출됨
			super.paintComponent(g);
			// g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(image, 20, 20, 250, 100, 100, 50, 200, 200, this);
		}
	}
	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}
}
