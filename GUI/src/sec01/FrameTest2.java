package sec01;

import javax.swing.JFrame;

public class FrameTest2 extends JFrame {
	public FrameTest2() {
		setTitle("JFRAME TEST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit 클릭 시 Background에서도 종료
		setSize(300, 500);
		setLocation(200, 300);
		setResizable(false); // 사이즈 조정 불가능
		setVisible(true);
	}

	public static void main(String[] args) {
		FrameTest2 ft = new FrameTest2();
	}
}
