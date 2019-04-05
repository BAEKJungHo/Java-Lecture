package sec02;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println(threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println(threadB.getName());
		threadB.start();

	}
}
