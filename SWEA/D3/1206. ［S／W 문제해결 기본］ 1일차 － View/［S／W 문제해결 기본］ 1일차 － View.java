
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc;
        sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int answer=0;
            int n = sc.nextInt();
            int[] buildings = new int[n];
            for(int i=0; i<n; i++){
                int h = sc.nextInt();
				buildings[i]=h;
            }
            
            for(int i=2; i<n-2; i++){
            	int leftMax = Math.max(buildings[i-2], buildings[i-1]);
               	int rightMax = Math.max(buildings[i+2], buildings[i+1]);
                int maxVal = Math.max(leftMax, rightMax);
                if (buildings[i]> maxVal){
                	answer+=buildings[i]-maxVal;
                }
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}