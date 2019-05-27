package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerEx extends JFrame {
	JLabel la;
	
	MouseListenerEx() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		la = new JLabel("Hello");
		la.setSize(50, 20);
		la.setLocation(30, 30);
		contentPane.add(la);
		setSize(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}
