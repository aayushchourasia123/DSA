import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    //tc=O(n^2.5)
    //sc=O(1)
    static boolean isPrime(int n){
         for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
   }

    static int FindValue(int n){
        int count=0;
        for(int i=3;i<=n;i++){
            if(!isPrime(i)){
                continue;
            }
            int sum=0;
            int value=i;
            for(int j=2;j<value;j++){
                if(isPrime(j)){
                    sum+=j;
                    if(sum==value){
                        count++;
                        break;
                    }
                }
                else continue;
            }
            
        }
        return count;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=FindValue(n);
        System.out.println(res);
	}
}
