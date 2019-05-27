package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.red);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.blue);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
