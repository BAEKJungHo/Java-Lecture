package sec04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsClip extends JFrame {
	private Thread th;
	Container contentPane;
	GraphicsClip() {
		setTitle("GraphicsClip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		th = new Thread(new Runnable() {
			@Override
			public void run() {
				int n=0;
				while(true) {
					// timerLabel.setText(Integer.toString(n));
					n++;
					try {
						Thread.sleep(1000); // 1초 동안 잠을 잔다.
					} catch(InterruptedException e) {
						return; // 예외가 발생하면 스레드 종료
					}
				}
			}
		});
		setSize(300, 400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/call.png");
		Image image = imageIcon.getImage();
		

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(50, 20, 150, 150);
			g.drawImage(image, getWidth(), getHeight(), this);
			g.setColor(Color.blue);
			g.setFont(new Font("SanSerif", Font.ITALIC, 40));
			g.drawString("Go Gator!!", 10, 150);
		}
	}
	
	public static void main(String[] args) {
		new GraphicsClip();
	}
}
