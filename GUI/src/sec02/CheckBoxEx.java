package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxEx extends JFrame {
	Container contentPane;
	CheckBoxEx() {
		setTitle("체크박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherry.PNG");
		ImageIcon selectedCherryIcon = new ImageIcon("images/cherry.PNG");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxEx();
	}
}
