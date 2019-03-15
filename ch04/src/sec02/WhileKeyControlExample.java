package sec02;

public class WhileKeyControlExample {
	public static void main(String[] args) throws Exception {
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("----------------------------------------------------");
				System.out.println("1.증속 | 2. 감속 | 3. 급가속 | 4. 급감속 | 5. 중지 ");
				System.out.println("-----------------------------------------------------");
				System.out.println("선택 : ");
			}
			
			keyCode = System.in.read();
			
			if(keyCode == '1') {
				speed++;
			}
			else if(keyCode == '2') {
				if(speed > 0)
					speed--;
				else
					continue;
			}
			else if(keyCode == '3') {
				speed += 10;
			}
			else if(keyCode == '4') {
				if(speed >= 10) {
					speed -= 10;
				}
				else
					continue;
			}
			else if(keyCode == '5') {
				break;
			}
			System.out.println("현재속도 = " + speed);
		}
		System.out.println("프로그램 종료");
	}
}
