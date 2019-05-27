package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListenerExample extends JFrame {
	
	ListenerExample() {
		setTitle("ListenerExample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action"))
					b.setText("액션");
				else 
					b.setText("Action");;
			}
		});
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerExample();
	}
}