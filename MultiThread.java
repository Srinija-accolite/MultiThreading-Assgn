package multiThreading;

public class MultiThread extends Thread{
	public void run() {
		for(int i = 2; i <=10; i=i+2) {
		 System.out.println("Child Thread: " + i);
		 }
		}
	static class ThreadDemo1 {
		public static void main(String args[]) throws InterruptedException {
		MultiThread t1=new MultiThread(); // creation of a new thread
		MultiThread t2=new MultiThread();//creation of another new thread
		System.out.println(t1.getState());
		t1.start();
		t1.join();
		System.out.println(t1.getState());
		System.out.println(t1.getPriority());
		t2.start();
		System.out.println("Second thread running");
		System.out.println(t2.getState());
		System.out.println(t2.getPriority());
		t2.setPriority(MAX_PRIORITY);
		System.out.println(t2.getPriority());
		
		t2.join();
		System.out.println("End-of-Executions");
		
		}
}
}
