import java.util.*;
import java.io.*;
 
class CuttingRod {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=0;z<t;z++)
        {
            int n=sc.nextInt();
            n++;
            int c=0;
            while(n!=1)
            {
              c=c+1;
              n=n>>1;
            }
            System.out.println(c-1);
        }
    }
}