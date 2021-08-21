package multiThreading;

import java.util.Scanner;
class Reservation
{
	static int tickets = 10;
	synchronized void bookticket (int name, int wantedtickets)
	{
	    if (wantedtickets <= tickets)
	    {
	     System.out.println (wantedtickets + " booked to " + "person"+(name+1));
	     tickets = tickets - wantedtickets;
	    }
	    else
	    {
	     System.out.println ("No tickets to book");
	    }
	}
}
class Thread1 extends Thread{
    Reservation r;
    int name;
    int seats;

    Thread1(Reservation r,int i,int x){
        this.r=r;
        name=i;
        seats=x;
    }
    public void run(){
        r.bookticket(name,seats);
    }
}


public class MultiThread3
{
    public static void main (String[]args)
    {
    	Reservation r=new Reservation();
    	System.out.println("Enter number of people");
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	for(int i=0;i<n;i++)
    	{
    		System.out.println("Enter number of tickets");
    		int x=sc.nextInt();
    		Thread1 t=new Thread1(r,i,x);
    		t.start();
    		//bookticket(i,x);
    	}
    	sc.close();
    }

}