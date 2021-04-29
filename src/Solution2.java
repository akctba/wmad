import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
	
	private static boolean flag;
	private static int B, H;

	static {
	    try {
	    	Scanner scan=new Scanner(System.in);
		    B = scan.nextInt();
		    H = scan.nextInt();
		    scan.close();
		    if (B <= 0 || H <= 0) {
		        throw new Exception("Breadth and height must be positive");
		    }
		    flag = true;
	    } catch (Exception e) {
	    	flag = false;
	    	System.out.println(e);
	    }
	}

	public static void main(String[] args){
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		}//end of main

	}//end of class


