package sec01;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		contentPane.setBackground(Color.CYAN);
		// contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("OK"), BorderLayout.NORTH);
		contentPane.add(new JButton("Cancel"), BorderLayout.SOUTH);
		contentPane.add(new JButton("Ignore"), BorderLayout.EAST);
		contentPane.add(new JButton("Add"), BorderLayout.WEST);
		contentPane.add(new JButton("Div"), BorderLayout.CENTER);
		
		setSize(350, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
