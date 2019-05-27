package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	RadioButtonEx() {
		setTitle("RadioButtonEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherry.PNG");
		ImageIcon selectedCherryIcon = new ImageIcon("images/apple.PNG");
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);
		
		setSize(300, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
