package architecture;

public class Button {
	OnClickListener listener; // 인터페이스 변수 선언
	
	// 매개변수의 다형성
	// 매개변수로 객체를 받아 생성
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// 생성된 객체명으로 오버라이딩된 실체메소드 호출
	void touch() {
		listener.onClick();
	}
	
	// 인터페이스에 추상메소드 선언
	interface OnClickListener {
		void onClick();
	}
}
