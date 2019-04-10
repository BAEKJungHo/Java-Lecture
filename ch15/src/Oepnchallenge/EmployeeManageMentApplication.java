package Oepnchallenge;

import java.time.LocalDate;
import java.util.*;

public class EmployeeManageMentApplication {
	
	public static void main(String[] args) {
		TreeSet<Employee> treeSet = new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				if(e1.position.compareTo(e2.position) > 0) return 1;
				else if(e1.position.compareTo(e2.position) < 0) return -1;
				else {
					return e1.date.compareTo(e2.date);
				}
			}
		});

		treeSet.add(new Employee(1, "백부장", Position.부장, LocalDate.of(2018, 01, 10)));
		treeSet.add(new Employee(2, "최부장", Position.부장, LocalDate.of(2018, 05, 10)));
		treeSet.add(new Employee(4, "김차장", Position.차장, LocalDate.of(2018, 11, 10)));
		treeSet.add(new Employee(5, "황과장", Position.과장, LocalDate.of(2018, 12, 10)));
		treeSet.add(new Employee(6, "주과장", Position.과장, LocalDate.of(2019, 01, 10)));
		treeSet.add(new Employee(7, "이대리", Position.대리, LocalDate.of(2019, 02, 10)));
		treeSet.add(new Employee(3, "박차장", Position.차장, LocalDate.of(2018, 07, 10)));
		treeSet.add(new Employee(8, "차대리", Position.대리, LocalDate.of(2019, 03, 10)));
		treeSet.add(new Employee(9, "유사원", Position.사원, LocalDate.of(2019, 04, 10)));
		treeSet.add(new Employee(10, "정사원", Position.사원, LocalDate.of(2019, 04, 11)));
		
		for(Employee employee : treeSet) {
			System.out.println(employee.name + " - " + employee.position + " - " + employee.date);
		}
	}
}
