package practice2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import practice1.MemberDAO;
import practice1.MemberDTO;
public class BbsApplication{
	
	public static void main(String[] args) {
		boolean run = true;
		int number;
		
		while(run) {
			System.out.println("=====회원메뉴 1-쓰기, 2-조회, 3-수정, 4-삭제, 5-상세조회, 6-종료=====");
			Scanner scan = new Scanner(System.in);
			number = Integer.parseInt(scan.nextLine());
			switch(number) {
			case 1:
				write(); break;
			case 2:
				search(); break;
			case 3:
				update(); break;
			case 4:
				delete(); break;
			case 5:
				DetailSearch(); break;
			case 6:
				System.out.println("종료되었습니다.");
				run = false;
				break;
			}
		} // End of while
	} // End of main

	public static void write() {
		MemberDAO mDao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		
		int memberId;
		String memberPassword;
		String title;
		String content;
		
		// 로그인
		Scanner scan = new Scanner(System.in);
		System.out.print("로그인 아이디 : ");
		memberId = Integer.parseInt(scan.nextLine());
		System.out.print("로그인 패스워드 : ");
		memberPassword = scan.nextLine();
		if(mDao.checkLogin(memberId, memberPassword) == true) {
			System.out.println("로그인 성공!");
			
			member.setId(memberId);
			
			// 날짜 변환
			SimpleDateFormat format1 = new SimpleDateFormat ("yy-MM-dd HH:mm");
			Date time = new Date();
			String time1 = format1.format(time);
		
			// 글쓰기
			System.out.print("제목>"); title = scan.nextLine();
			System.out.print("내용>"); content = scan.nextLine();
			BbsDAO bDao = new BbsDAO();
			bDao.insertBbs(new BbsDTO(member.getId(), title, time1, content));
			System.out.println("입력 완료 !!");
		} else {
			System.out.println("로그인 실패!");
		}
	}
	
	public static void search() {
		BbsDAO bDao = new BbsDAO();
		List<BbsDTO> bbsList;
		
		bbsList = bDao.selectAll();
		for (BbsDTO bbs : bbsList) {
			System.out.println(bbs.toString());
		}
	}
	
	public static void update() {
		MemberDAO mDao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		BbsDAO bDao = new BbsDAO();
		BbsDTO bbs = new BbsDTO();
		
		int memberId;
		String title;
		String content;
		String memberPassword;
		
		// 로그인
		Scanner scan = new Scanner(System.in);
		System.out.print("Member 아이디를 입력해주세요 : ");
		memberId = Integer.parseInt(scan.nextLine());
		System.out.print("로그인 패스워드 : ");
		memberPassword = scan.nextLine();
		if(mDao.checkLogin(memberId, memberPassword) == true) {
			System.out.println("로그인 성공!");
			member.setId(memberId);
			
			System.out.print("제목>"); title = scan.nextLine();
			System.out.print("내용>"); content = scan.nextLine();
			
			// Update 전
			System.out.println("변경 전");
			bbs = bDao.selectOne(memberId);
			System.out.println(bbs.toStrOne());
			
			bbs.setTitle(title);
			bbs.setContent(content);
			bDao.updateBbs(bbs);
			
			// Update 후
			System.out.println("변경 후");
			bbs = bDao.selectOne(memberId);
			System.out.println(bbs.toStrOne());
		} else {
			System.out.println("로그인 실패!");
		}
	}
	
	public static void delete() {
		int memberId;
		BbsDAO bDao = new BbsDAO();
		BbsDTO bbs = new BbsDTO();
		List<BbsDTO> bbsList;
		
		System.out.print("삭제할 Member 아이디를 입력해 주세요 : ");
		Scanner scan = new Scanner(System.in);
		memberId = Integer.parseInt(scan.nextLine());
		
		bbs = bDao.selectOne(memberId);
		if(bbs.getMemberId() == 0) {
			System.out.println("ID번호가 잘 못 입력 되었습니다.");
		} else {
			System.out.println(bbs.toString() + "\n");
			bDao.deleteBbs(memberId);
			System.out.println("삭제 후 릴레이션");
			bbsList = bDao.selectAll();
			for (BbsDTO bb : bbsList) {
				System.out.println(bb.toString());
			}
		}
	}
	
	public static void DetailSearch() {
		int id;
		BbsDAO bDao = new BbsDAO();
		BbsDTO bbs = new BbsDTO();
		
		System.out.print("ID를 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		id = Integer.parseInt(scan.nextLine());
		
		System.out.println("검색결과");
		bbs = bDao.selectId(id);
		System.out.println(bbs.toStrDetail());
	}
}