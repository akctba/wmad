import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
        
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            String sor=scan.nextLine();
            if(sor == null || "".equals(sor))
            	break;
            list.add(sor);
        }

        scan.close();

        int linha = 1;
        for(String s : list) {
            System.out.printf("%d %s%n", linha++, s);
        }
	}

}
