package sec05;

public class Box<T> {
	private T t;
	void set(T t) { this.t = t; }
	public T get() { return t; }
}
