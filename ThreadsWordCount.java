package multiThreading;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LineCounter implements Runnable{
	String s[];
	Thread t;
	int count;
	int start, end;																																;																																																																																																
	LineCounter(String s[], int start, int end){
		this.s = s;
		this.count=0;
		this.t = new Thread(this);
		this.start = start;
		this.end = end;
	}
	public void run(){
		for ( int i = start ; i<end; i ++)
			this.count = this.count + s[i].split("\\s+").length;
	}
}
public class ThreadsWordCount{

	public static void main(String args[]) throws IOException{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter threads");
		int nthreads=sc.nextInt();
		
		int count = 0;
		LineCounter lc[] = new LineCounter[nthreads];

		System.out.println("Enter number of lines");
		int n=sc.nextInt();
		System.out.println("Enter lines");
		String[] lines=new String[n];
		for(int i=0;i<n;i++) {
			 lines[i]=br.readLine();
		}
		for ( int i = 0 ; i < nthreads; i ++ ){
			 int start = n/nthreads*i;
			 int end = (i == nthreads - 1)? n : n/nthreads*(i+1);
			 lc[i] = new LineCounter(lines, start, end);
		}
		long start = System.currentTimeMillis();
		for ( int i = 0 ; i < nthreads ; i ++ )
			lc[i].t.start();
		for ( int i = 0 ; i < nthreads; i ++){
			try{ lc[i].t.join();}catch(Exception e)	{}
		}
		long end = System.currentTimeMillis();
		for (int i = 0; i < nthreads; i ++)
			count += lc[i].count;
		System.out.println("Word count="+count);
		System.out.println("Time taken="+(end-start));
																																																																																																																																																																																																																																								
	}
}