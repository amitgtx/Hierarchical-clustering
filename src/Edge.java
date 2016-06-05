import java.util.*;
public class Edge
{
	private int b1;
	private int b2;
	private double weight;

	public int getB1() {
		return b1;
	}
	public void setB1(int b1) {
		this.b1 = b1;
	}
	public int getB2() {
		return b2;
	}
	public void setB2(int b2) {
		this.b2 = b2;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

}

class EdgeComparator implements Comparator<Edge>	
{
	@Override
	public int compare(Edge e1,Edge e2)
	{
	//	Edge e1=(Edge)o1;
	//	Edge e2=(Edge)o2;
		if(e1.getWeight()>e2.getWeight())return -1;
		else if(e1.getWeight()<e2.getWeight())return 1;
		else return 0;
	}
}
