package architecture;

public class Button {
	OnClickListener listener; // �������̽� ���� ����
	
	// �Ű������� ������
	// �Ű������� ��ü�� �޾� ����
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// ������ ��ü������ �������̵��� ��ü�޼ҵ� ȣ��
	void touch() {
		listener.onClick();
	}
	
	// �������̽��� �߻�޼ҵ� ����
	interface OnClickListener {
		void onClick();
	}
}
