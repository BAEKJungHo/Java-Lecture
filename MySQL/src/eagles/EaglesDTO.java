package eagles;

public class EaglesDTO {
	
	private int backNo;
	private String name;
	private String position;
	private String hs;
	private String hand;
	private int birth;
	private int salary;
	
	public EaglesDTO(int backNo, String name, String position, String hs, String hand, int birth, int salary) {
		super();
		this.backNo = backNo;
		this.name = name;
		this.position = position;
		this.hs = hs;
		this.hand = hand;
		this.birth = birth;
		this.salary = salary;
	}
	
	public EaglesDTO() { }

	public int getBackNo() {
		return backNo;
	}

	public void setBackNo(int backNo) {
		this.backNo = backNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHs() {
		return hs;
	}

	public void setHs(String hs) {
		this.hs = hs;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EaglesDTO [backNo=" + backNo + ", name=" + name + ", position=" + position + ", hs=" + hs + ", hand="
				+ hand + ", birth=" + birth + ", salary=" + salary + "]";
	}
	
}
