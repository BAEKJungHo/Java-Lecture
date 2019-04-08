package Openchallenge;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01DartApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Dart 게임 입력> ");
		String game = scan.nextLine();
		System.out.println("획득한 점수 = " + dartResult(parseDart(game)));
		scan.close();
	}

	static int dartResult(Ex01Dart[] dart) {
		int score = 0;
		for (int i=0; i<3; i++) {
			switch (dart[i].area) {
			case 'S':
				dart[i].score = dart[i].number;
				break;
			case 'D':
				dart[i].score = dart[i].number * dart[i].number;
				break;
			case 'T':
				dart[i].score = dart[i].number * dart[i].number * dart[i].number;
			}
		}
		for (int i=0; i<3; i++) {
			if (dart[i].optionStar) {
				dart[i].score *= 2;
				if (i != 0) {
					dart[i-1].score *= 2;
				}
			}
			if (dart[i].optionAcha)
				dart[i].score *= -1;
		}
		score = dart[0].score + dart[1].score + dart[2].score;
		return score;
	}
	
	static Ex01Dart[] parseDart(String str) {
		Ex01Dart[] dart = new Ex01Dart[3];
		StringTokenizer st = null;
		String s; String number = null;
		int index = 0; 
		int len = str.length();
		
		for (int i=0; i<3; i++) {
			dart[i] = new Ex01Dart();
			dart[i].optionStar = false;
			dart[i].optionAcha = false;
			s = str.substring(index);
			//System.out.println(s);
			
			st = new StringTokenizer(s, "SDT");
			dart[i].number = Integer.parseInt(st.nextToken());
			index += (dart[i].number == 10) ? 2 : 1;
			dart[i].area = str.charAt(index); 
			index++;
			if (index < len) {
				if (str.charAt(index) == '*')
					dart[i].optionStar = true;
				if (str.charAt(index) == '#')
					dart[i].optionAcha = true;
				if (dart[i].optionStar || dart[i].optionAcha)
					index++;
			}
			//System.out.println(i + dart[i].toString());
		}
		return dart;
	}
}