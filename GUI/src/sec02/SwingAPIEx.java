package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAPIEx extends JFrame {
	Container contentPane;
	JLabel la;
	JButton b1, b2, b3, b4;
	
	SwingAPIEx() {
		setTitle("SwingAPIEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);
		
		b2 = new JButton("모양 정보");
		b2.setOpaque(true);
		b2.setForeground(Color.magenta);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("고딕체", Font.ITALIC, 20));
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);
		
		b3 = new JButton("작동하지 않는 버튼");
		b3.setEnabled(false);
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);
		
		b4 = new JButton("숨기기/보이기");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		setSize(250, 200);
		setVisible(true);
	}
	
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == b1) {
				System.out.println(b1.getX() + "," + b1.getY());
				System.out.println(b1.getWidth() + "x" + b1.getHeight());
				JPanel c = (JPanel)b2.getParent();
				System.out.println(c.getX() + "," + c.getY());
				System.out.println(c.getWidth() + "x" + c.getHeight());
			} else if(source == b2) {
				System.out.println("폰트 : " + b2.getFont());
				System.out.println("배경색 : " + b2.getBackground());
				System.out.println("글자색 :" + b2.getForeground());
			} else {
				if(b1.isVisible()) {
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				} else {
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new SwingAPIEx();
	}
}