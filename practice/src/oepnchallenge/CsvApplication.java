package oepnchallenge;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class CsvApplication {
	public static void main(String[] args) {
		String filePath = "D:\\Workspace\\Egovernment\\Java\\practice\\src\\addrInput.txt";
		
		List<String> name = new ArrayList<String>();
		List<String> email = new ArrayList<String>();
		List<String> phone = new ArrayList<String>();
		
		StringTokenizer st = null;
		
		Scanner scan = new Scanner(System.in);
		String yn;
		
		int i = 0;
		
		try {
			System.out.print("정보를 입력 하시겠습니까?(Y/N) : ");
			yn = scan.nextLine();
			if(yn.equals("Y")) { inputMember(); }

			BufferedReader br = new BufferedReader(new FileReader(filePath)); 
            String line = "";
            
            while((line = br.readLine()) != null) { // 한 줄씩 읽기
                System.out.println(line);
                st = new StringTokenizer(line, ",");
                while(st.hasMoreTokens()) {
                	try {
                   	name.add(i, st.nextToken());
                   	email.add(i, st.nextToken());
                	phone.add(i, st.nextToken());
                	} catch(NoSuchElementException e) {
                       	name.add(i, " ");
                    	email.add(i, " ");
                    	phone.add(i, " ");
                	}
                	i++; 
                }
            }
            eliDuplicated(name, phone, email);
            br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		BufferedReader br = new BufferedReader(new FileReader(filePath)); 
        String line = "";
        System.out.println("=====================중복 제거 및 정렬 후======================");
        while((line = br.readLine()) != null) { // 한 줄씩 읽기
            System.out.println(line);
        }
		} catch(Exception e) { }
	}
	
	public static void eliDuplicated(List<String> name, List<String> phone, List<String> email) throws Exception {
		System.out.println("==================중복제거 함수 실행===================");
		String filePath = "D:\\Workspace\\Egovernment\\Java\\practice\\src\\addrInput.txt";
		
		for(int i=0; i<name.size()-1; i++) {
			for(int k=i+1; k<name.size(); k++) {
				if(name.get(i).equals(name.get(k)) && phone.get(i).equals(phone.get(k))) { // 이름과 전화번호가 같으면 중복
					System.out.println("중복이름 : " + name.get(i));
					
					System.out.println("중복이름에 해당되는 Email : " + email.get(i) + " & " + email.get(k));
				    String input = "Please delete email or id : "; 
				    System.out.println(input); 
				    
				    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
				    String word = reader.readLine(); 
				    reader.close(); 
	
				    System.out.println("Remove: " + word); 
				    String wordToRemove = word; 
	
	
				    StringBuffer newContent = new StringBuffer(); 

					TreeSet treeSet = new TreeSet();
					
				    // 한 줄씩 읽어서 입력한 값이 그 줄에 포함되어있는지 확인 
				    BufferedReader br = new BufferedReader(new FileReader(filePath)); 
			      	while ((word = br.readLine()) != null) { 
			      		if (!word.trim().contains(wordToRemove)) { // 포함되어 있지 않으면 treeSet에 넣어 정렬
			      			treeSet.add(word); 
			      		} 
			      	} 
			      	// 트리셋이 비어있는지 확인하면서 버퍼에 추가
			      	while(!treeSet.isEmpty()) {
		      			newContent.append(treeSet.pollFirst()); 
		      			newContent.append("\r\n"); // new line 
			      	}
				    br.close(); 
	
			      	FileWriter removeLine = new FileWriter(filePath); 
			      	BufferedWriter change = new BufferedWriter(removeLine); 
			      	PrintWriter replace = new PrintWriter(change); 
			      	replace.write(newContent.toString()); 
			      	replace.close(); 
				}	
			}
		}
	}
	
	public static void inputMember() throws Exception {
		String filePath = "D:\\Workspace\\Egovernment\\Java\\practice\\src\\addrInput.txt";
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		List<String> newName = new ArrayList<String>();
		List<String> newEmail = new ArrayList<String>();
		List<String> newPhone = new ArrayList<String>();
		
		while(run) {
			System.out.println("==================입력 함수 실행===================");
			System.out.println("=================1. 입력 2. 종료===================");
			int number = Integer.parseInt(scan.nextLine());
			switch(number) {
			case 1:
				System.out.print("이름을 입력하세요 : ");
				newName.add(scan.nextLine());
				System.out.print("이메일을 입력하세요 : ");
				newEmail.add(scan.nextLine());
				System.out.print("전화번호을 입력하세요 : ");
				newPhone.add(scan.nextLine());
				break;
			case 2:
				run = false;
				break;
			}
		}
		
		FileWriter fw = new FileWriter(filePath ,true); // 기존에 추가하여 작성(true)
		
		for(int i=0; i<newName.size(); i++) {
			String str = newName.get(i)+","+newEmail.get(i)+","+newPhone.get(i);
			fw.write("\r\n");
			fw.write(str);
		}
		fw.close();
	}
}
