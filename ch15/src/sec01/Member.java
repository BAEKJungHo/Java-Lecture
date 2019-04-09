package sec01;

public class Member {
	
	public String name;
	public String sex;
	public String phone;
	
	public Member(String name, String sex, String phone) {
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Member) {
			Member member = (Member)o;
			return member.name.equals(name) && (member.sex.equals(sex));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + sex.hashCode();
	}
}
