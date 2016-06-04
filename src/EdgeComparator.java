import java.util.*;
public class EdgeComparator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Edge e1=(Edge)o1;
		Edge e2=(Edge)o2;
		if(e1.getWeight()>e2.getWeight())return -1;
		else if(e1.getWeight()<e2.getWeight())return 1;
		else return 0;
	}
}
