package sec01;

public class MemberExample {
	public static void main(String[] args) {
		Member obj1 = new Member("red");
		Member obj2 = new Member("red");
		Member obj3 = new Member("blue");
		
		String name = "백정호";
		String name1 = "백정호";
		String name2 = new String("백정호");
		
		String[] str1 = new String[] {"john"};
		String[] str2 = new String[] {"john"};
		String[] str3 = new String[] {"john"};
		
		if(obj1.equals(obj2)) {
			System.out.println("동등");
		} else {
			System.out.println("다름");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("동등");
		} else {
			System.out.println("다름");
		}
		
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println(name.hashCode());
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());

	}
}
