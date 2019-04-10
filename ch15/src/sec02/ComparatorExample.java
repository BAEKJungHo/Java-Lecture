package sec02;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				if(f1.price > f2.price) return 1;
				else if(f1.price < f2.price) return -1;
				else return f1.name.compareTo(f2.name);
			}
		});
		
		treeSet.add(new Fruit("사과", 3000));
		treeSet.add(new Fruit("딸기", 5000));
		treeSet.add(new Fruit("바나나", 8000));
		treeSet.add(new Fruit("망고", 8000));
		treeSet.add(new Fruit("포도", 9000));
		
		for(Fruit fruit : treeSet) {
			System.out.println(fruit.name + " : " + fruit.price);
		}
	}
}
