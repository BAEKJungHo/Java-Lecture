package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Mouse Event");
		btn.setBackground(Color.yellow);
		MyMouseListener listener = new MyMouseListener();
		btn.addMouseListener(listener);
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}

