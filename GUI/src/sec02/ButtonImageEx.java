package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonImageEx extends JFrame {
	Container contentPane;
	ButtonImageEx() {
		setTitle("이미지 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/love.png");
		ImageIcon rolloverIcon = new ImageIcon("images/call.png");
		ImageIcon pressedIcon = new ImageIcon("images/love.png");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setRolloverIcon(rolloverIcon);
		btn.setPressedIcon(pressedIcon);
		contentPane.add(btn);
		
		setSize(300, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonImageEx();
	}
}
