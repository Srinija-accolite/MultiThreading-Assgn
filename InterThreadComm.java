package multiThreading;

 class InterThread {
	int amt=1000;
	synchronized void withdraw(int amount){
		System.out.println("Withdraw start");
		if(amount>amt) {
			System.out.println("Less balance");
			try {
				wait();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		amt=amt-amount;
		System.out.println("You have withdrawed the amount of "+amount);
		System.out.println("Available Balance= "+amt);
	}
	synchronized void deposit(int amount) {
		System.out.println("Deposit start");
		amt=amt+amount;
		notify();
		System.out.println("Successfully deposited an amount of "+amount);
		System.out.println("Available balance= "+amt);
	}
}
 public class InterThreadComm{
	 public static void main(String args[]) throws Exception{
		 InterThread th=new InterThread();
		 new Thread() {
			 public void run() {
				 th.withdraw(1500);
			 }
		 }.start();
		 new Thread() {
			 public void run() {
				 th.deposit(1500);
			 }
		 }.start();
	 }
	 
 }
