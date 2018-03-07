import java.util.*;
import java.io.*;

public class btc {

	public static void main(String[] args) {
		int i,j,n;
		Scanner in= new Scanner(System.in);
		System.out.println("Bitcoin question, enter n and maxsize followed by each block size and fees corresponding to the blocks");
		/*
		Enter input in this following format:
		12 1000000
		7247 8732 34928 7275 9240 5440 0820 39603 3718 143807 190457 40572
		0.0887 0.1856 0.2307 0.1522 0.0532 0.0250 0.1409 0.2541 0.1147 0.2660 0.2933 0.0686
		*/
		n=in.nextInt();
		int mSize=in.nextInt();
		int[] bSize=new int[n];
		float[] fee= new float[n];
		float[][] dp=new float[n+1][mSize+1];
		for(i=0;i<n;i++){
			bSize[i]=in.nextInt();
		}
		for(i=0;i<n;i++){
			fee[i]=in.nextFloat();
			a+=fee[i];
		}
		for (i = 0; i <= n; i++)
	     {
	         for (j = 0; j <= mSize; j++)
	         {
	             if (i==0||j==0)
	                  dp[i][j] = 0;
	             else if (bSize[i-1] <= j)
	                   dp[i][j] = Math.max(fee[i-1] + dp[i-1][j-bSize[i-1]],  dp[i-1][j]);
	             else
	                   dp[i][j] = dp[i-1][j];
	         }
	      }
		System.out.println("Total fee for the block using these transactions : "+dp[n][mSize]);
	}

}
