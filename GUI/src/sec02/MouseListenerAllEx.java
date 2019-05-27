package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerAllEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseListenerAllEx() {
		setTitle("MouseListenerAllEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanel p = (JPanel)e.getSource();
				p.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				JPanel p = (JPanel)e.getSource();
				p.setBackground(Color.BLUE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				la.setText("MousePressed ("+e.getX()+","+e.getY()+")");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				la.setText("MouseReleased ("+e.getX()+","+e.getY()+")");
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
			}
		});
		la = new JLabel("NO MOUSE EVENT");
		contentPane.add(la);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
}
