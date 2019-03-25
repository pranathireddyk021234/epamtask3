import java.util.*;
public class IndianArmy {
    public static void main(String args[]) {
       	Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		long s = sc.nextLong();
		long e = sc.nextLong();
		TreeMap<Long,Long> t1=new TreeMap<Long,Long>();
		TreeMap<Long,Long> t2=new TreeMap<Long,Long>();
		for(int i=0;i<n;i++)
		{
			long x = sc.nextLong();
			long p = sc.nextLong();
			t1.put((x-p),(x+p));
		
    }
    List<Long> l1=new ArrayList<Long>(t1.keySet());
    List<Long> l2=new ArrayList<Long>(t1.values());
    	long c = l1.get(0);
		long d = l2.get(0);
		for(int i=1;i<t1.size();i++)
		{
			if(l1.get(i)<=d)
				d = Math.max(d,l2.get(i));
			else
			{
				
				t2.put(c,d);
				c = l1.get(i);
				d = l2.get(i);
			}
			
		}
		t2.put(c,d);
	 	int i;
		long ans = 0;
    l1=new ArrayList<Long>(t2.keySet());
    l2=new ArrayList<Long>(t2.values());
 
		
		for(i=0;i<l1.size();i++)
		{
			if(s>=e)
			{
				s=e;
				break;
			}
			if(l1.get(i)<=s && s<=l2.get(i))
				s = l2.get(i);
			else if(s<=l1.get(i) && e>=l2.get(i))
			{
				ans+=l1.get(i)-s;
				s = l2.get(i);
				
			}
			else if(s<=l1.get(i) && e>=l1.get(i) &&  e<=l2.get(i))
			{
				ans+=l1.get(i)-s;
				s = e;
			}
			//if starting position & ending position are before the current segment
			else if(s<=l1.get(i) && e<=l1.get(i))
			{
				ans+=e-s;
				s = e;
			}
		}
		//add the distance which is not covered in above segments
		if(s<e)
			ans+=e-s;
		System.out.println(ans);
	}
}