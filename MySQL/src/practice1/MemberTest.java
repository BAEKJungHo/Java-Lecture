package practice1;

import java.util.List;
import java.util.Scanner;

import basic03.EaglesDTO;
public class MemberTest {
	public static void main(String[] args) {
		boolean run = true;
		
		int id;
		String password;
		String name;
		String birthday;
		String address;
		
		MemberDTO member;
		List<MemberDTO> memberList;
		MemberDAO mDao = new MemberDAO();
		
		while(run) {
			System.out.println("회원메뉴 1-가입, 2-조회, 3-변경, 4-삭제, 5-검색, 6-로그인, 7-종료");
			Scanner scan = new Scanner(System.in);
			int number = Integer.parseInt(scan.nextLine());
			switch(number) {
			case 1: // Insert
				System.out.print("패스워드>"); password = scan.nextLine();
				System.out.print("이름>"); name = scan.nextLine();
				System.out.print("생년월일>"); birthday = scan.nextLine();
				System.out.print("주소>"); address = scan.nextLine();
				
				mDao.insertMember(new MemberDTO(password, name, birthday, address));
				System.out.println("입력 완료 !!");
				break;
			case 2: // SelectAll
				memberList = mDao.selectAll();
				for (MemberDTO members : memberList) {
					System.out.println(members.toString());
				}
				break;
			case 3: // Update
				System.out.print("ID 번호를 입력해 주세요 : ");
				id = Integer.parseInt(scan.nextLine());
				
				System.out.print("패스워드>"); password = scan.nextLine();
				System.out.print("이름>"); name = scan.nextLine();
				System.out.print("생년월일>"); birthday = scan.nextLine();
				System.out.print("주소>"); address = scan.nextLine();
				
				// Update 전
				System.out.println("변경 전");
				member = mDao.selectOne(id);
				System.out.println(member.toString());
				
				member.setPassword(password);
				member.setName(name);
				member.setBirthday(birthday);
				member.setAddress(address);
				mDao.updateMember(member);
				
				// Update 후
				System.out.println("변경 후");
				member = mDao.selectOne(id);
				System.out.println(member.toString());
				break;
			case 4: // Delete
				System.out.print("삭제할 ID 번호를 입력해 주세요 : ");
				id = Integer.parseInt(scan.nextLine());
				
				member = mDao.selectOne(id);
				if(member.getId() == 0) {
					System.out.println("ID번호가 잘 못 입력 되었습니다.");
					continue;
				} else {
					System.out.println(member.toString() + "\n");
					mDao.deleteMember(id);
					System.out.println("삭제 후 릴레이션");
					memberList = mDao.selectAll();
					for (MemberDTO members : memberList) {
						System.out.println(members.toString());
					}
				}
				break;
			case 5: // Search by Name
				System.out.print("검색할 이름을 입력하세요 : ");
				name = scan.nextLine();
				memberList = mDao.selectName(name);
				for (MemberDTO members : memberList) {
					System.out.println(members.toString());
				}
				break;
			case 6: // Login
				System.out.print("로그인 아이디 : ");
				id = Integer.parseInt(scan.nextLine());
				System.out.print("로그인 패스워드 : ");
				password = scan.nextLine();
				mDao.checkLogin(id, password);
				run = false;
				break;
			case 7:
				System.out.println("종료되었습니다!");
				run = false;
				break;
			} // End of switch
			
		} // End of while
		
		// Connection close
		mDao.close();
	}
}
