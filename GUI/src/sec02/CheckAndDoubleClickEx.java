package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckAndDoubleClickEx extends JFrame {
	JPanel contentPane = new JPanel();
	CheckAndDoubleClickEx() {
		setTitle("CheckAndDoubleClickEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					
					JPanel p = (JPanel)e.getSource();
					p.setBackground(new Color(r,g,b));
				}
			}
		});
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		 new CheckAndDoubleClickEx();
	}
}
