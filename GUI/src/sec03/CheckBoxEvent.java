package sec03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxEvent extends JFrame {
	Container contentPane;
	JCheckBox[] cb = new JCheckBox[2];
	String[] names = {"버튼 비활성화", "버튼 감추기"};
	JButton button = null;
	CheckBoxEvent() {
		setTitle("CheckBoxEvent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		button = new JButton("TEST BUTTON");
		for(int i=0; i<cb.length; i++) {
			cb[i] = new JCheckBox(names[i]);
			cb[i].setBorderPainted(true);
			contentPane.add(cb[i]);
			cb[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getItem() == cb[0]) {
						if(button.isEnabled())
							button.setEnabled(false);
						else 
							button.setEnabled(true);
					}
					else  {
						if(button.isVisible())
							button.setVisible(false);
						else 
							button.setVisible(true);
					}
				}
			});
		}
		contentPane.add(button);
		setSize(250, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxEvent();
	}
}
