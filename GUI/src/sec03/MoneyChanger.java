package sec03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoneyChanger extends JFrame {
	Container contentPane;
	JButton button = null;
	JTextField tf = null;
	private static final int 오만원 = 50000;
	private static final int 만원 = 50000;
	private static final int 천원 = 50000;
	private static final int 오백원 = 50000;
	private static final int 백원 = 50000;
	private static final int 오십원 = 50000;
	private static final int 십원 = 50000;
	private static final int 일원 = 50000;
	int money = 0;
	int m50000 = 0;
	int m10000 = 0;
	int m1000 = 0;
	int m500 = 0;
	int m100 = 0;
	int m50 = 0;
	int m10 = 0;
	int m1 = 0;
	MoneyChanger() {
		setTitle("MoneyChanger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JTextField[] ntf = new JTextField[8];
		contentPane.add(new JLabel("금액 : "));
		tf = new JTextField(10);
		contentPane.add(tf);
		button = new JButton("계산");
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int money = Integer.parseInt(tf.getText());
					System.out.println(money);
					m50000 = money/오만원;
					System.out.println(m50000);
					contentPane.add(new JLabel("오만원 : "));
					ntf[0].setText(String.valueOf(m50000));
					//contentPane.add(ntf[0]);
					
					m10000 = (money%오만원)/만원;
					contentPane.add(new JLabel("만원 : "));
					ntf[1].setText(String.valueOf(m10000));
					//contentPane.add(ntf[1]);
					
					m1000 = ((money%오만원)%만원)/천원;
					contentPane.add(new JLabel("천원 : "));
					ntf[2].setText(String.valueOf(m1000));
					//contentPane.add(ntf[2]);
					
					m500 = (((money%오만원)%만원)%천원)/오백원;
					contentPane.add(new JLabel("오백원 : "));
					ntf[3].setText(String.valueOf(m500));
					//contentPane.add(ntf[3]);
					
					m100 = ((((money%오만원)%만원)%천원)%오백원)/백원;
					contentPane.add(new JLabel("백원 : "));
					ntf[4].setText(String.valueOf(m100));
					//contentPane.add(ntf[4]);
					
					m50 = (((((money%오만원)%만원)%천원)%오백원)%백원)/오십원;
					contentPane.add(new JLabel("오십원 : "));
					ntf[5].setText(String.valueOf(m50));
					//contentPane.add(ntf[5]);
					
					m10 = ((((((money%오만원)%만원)%천원)%오백원)%백원)%오십원)/십원;
					contentPane.add(new JLabel("십원 : "));
					ntf[6].setText(String.valueOf(m10));
					//contentPane.add(ntf[6]);
					
					m1 = ((((((money%오만원)%만원)%천원)%오백원)%백원)%오십원)%십원;
					contentPane.add(new JLabel("일원 : "));
					ntf[7].setText(String.valueOf(m1));
					//contentPane.add(ntf[7]);
					
				} catch(NumberFormatException ne) {
					ne.printStackTrace();
				}
			}
		});
		for(int i=0; i<ntf.length; i++) {
			contentPane.add(ntf[i]);
		}
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MoneyChanger();
	}
}
