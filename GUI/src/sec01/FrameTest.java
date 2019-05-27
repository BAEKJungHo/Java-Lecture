package sec01;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FrameTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame(); // 프레임 객체 생성
		jf.setTitle("JFRAME TEST"); // 프레임 제목
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit 클릭 시 Background에서도 종료
		jf.setSize(300, 500); // 프레임 크기
		jf.setLocation(200, 300); // 프레임 위치
		jf.setResizable(false); // 사이즈 조정 불가능
		jf.setVisible(true); // 프레임 보이게 하기
	}
}

