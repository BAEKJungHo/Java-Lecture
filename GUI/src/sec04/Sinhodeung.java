package sec04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sinhodeung extends JFrame {
	public Sinhodeung() {
		add(new MyPanel());
		setSize(300, 500);
		setVisible(true);
	}
	class MyPanel extends JPanel implements ActionListener {
		boolean flag = false;
		private int light_number = 0;
		public MyPanel() {
			setLayout(new BorderLayout());
			JButton b = new JButton("traffic light turn on");
			b.addActionListener(this);
			add(b, BorderLayout.SOUTH);
			Thread th = new Thread();
			th.start();
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000); // 1초 동안 잠을 잔다.
				} catch(InterruptedException e) {
					return; // 예외가 발생하면 스레드 종료
				}
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawOval(100,  100,  100, 100);
			g.drawOval(100,  200,  100, 100);
			g.drawOval(100,  300,  100, 100);
			if(light_number == 0) {
				g.setColor(Color.red);
				g.fillOval(100, 100, 100, 100);
			} else if(light_number == 1) {
				g.setColor(Color.green);
				g.fillOval(100, 200, 100, 100);
			} else if(light_number == 2) {
				g.setColor(Color.YELLOW);
				g.fillOval(100, 300, 100, 100);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(++light_number >= 3) 
				light_number = 0;
			repaint();
		}
	}
	public static void main(String[] args) {
		new Sinhodeung();
	}
}


