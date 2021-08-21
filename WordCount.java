package multiThreading;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class WordCount
{  
    static int wordCount = 0; 
    public static int countWords(String sentence[]){
          int words=0;
    	for(int i=0;i<sentence.length;i++) {
    		String str[]=sentence[i].split(" ");
    		words+=str.length;
    	}
        return words;
    }
    
    public static void main(String[] args) throws IOException {  
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of lines");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println("Enter "+x+" lines ");
        String[] s=new String[x];
        for(int i=0;i<x;i++) {
        	s[i]=br.readLine();
        }
        long startTime = System.currentTimeMillis();
        int wordCount=countWords(s); 
        long stopTime = System.currentTimeMillis();
        long result=stopTime - startTime;        
        //Displays the total number of words present in the given string  
        System.out.println("Total number of words in the given string: " + wordCount); 
        System.out.println("Time : " + result); 
    }  
    
}
