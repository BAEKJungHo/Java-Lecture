package sec01;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FrameTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("JFRAME TEST");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit 클릭 시 Background에서도 종료
		jf.setSize(300, 500);
		jf.setLocation(200, 300);
		jf.setResizable(false); // 사이즈 조정 불가능
		jf.setVisible(true);
	}
}

