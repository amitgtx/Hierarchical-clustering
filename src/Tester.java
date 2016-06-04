import java.io.*;
public class Tester
{
	public static void main(String args[])throws IOException
	  {
		DataComputations r=new DataComputations();
		r.inputData();
	//	r.displayAllData();
		r.calculateDistanceAndMakeEdges();
		r.displayDistanceMatrix();
	//	Edge edges[]=r.getEdges();
	//	ClusterMaker s=new ClusterMaker();
	//	s.compute(edges,r.getBookData());
	//	s.displayCluster();
	  }
}
