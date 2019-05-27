package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelEx extends JFrame {
	Container contentPane;
	LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("사랑합니다");
		ImageIcon love = new ImageIcon("images/love.png");
		JLabel imageLabel = new JLabel(love);
		ImageIcon normalIcon = new ImageIcon("images/call.png");
		JLabel label = new JLabel("CALL ME", normalIcon, SwingConstants.CENTER);
		
		contentPane.add(textLabel);
		contentPane.add(imageLabel);
		contentPane.add(label);
		
		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelEx();
	}
}
