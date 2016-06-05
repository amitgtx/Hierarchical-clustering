import java.io.*;
import java.util.*;

public class A implements Comparable<A>
{
	int node;
	double distance;
	

	// public boolean equals(A x)
	// {
		 // if(this.node==x.node && this.distance==x.distance)return true;
		 // else return false;
	// }

	public int compareTo(A x)
		{
			if(this.distance>x.distance)return -1;
			else if(this.distance<x.distance)return 1;
			else 
				{
					if(this.node>x.node)return -1;
					else if(this.node<x.node)return 1;
					else return 0;
				}
		}
	
}


class AComparator implements Comparator<A>
{
		public int compare(A x1,A x2)
		{
			if(x1.distance>x2.distance)return -1;
			else if(x1.distance<x2.distance)return 1;
			else 
				{
					if(x1.node>x2.node)return -1;
					else if(x1.node<x2.node)return 1;
					else return 0;
				}
		}

}


