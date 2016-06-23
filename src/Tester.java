import java.io.*;
public class Tester
{
	public static void main(String args[])throws IOException
	  {
		DataComputations r=new DataComputations();
		r.inputData();
	//	r.displayAllData();
	//	r.calculateDistanceAndMakeEdges();
	//	r.displayDistanceMatrix();
		// Edge edges[]=r.getEdges();
	//	ClusterMaker s=new ClusterMaker();
	//	s.compute(edges,r.getBookData());
	//	s.displayCluster();
		r.makeMST(0);
		Edge edges[]=r.getEdges();

	/*	for(int i=0;i<edges.length;i++)
		{
		//	if(edges[i]!=null)		
			System.out.println(edges[i].getB1()+" "+edges[i].getB2()+" "+edges[i].getWeight());
		}

		int mb = 1024*1024;
         
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
         
        System.out.println("##### Heap utilization statistics [MB] #####");
         
        //Print used memory
        System.out.println("Used Memory:"
            + (runtime.totalMemory() - runtime.freeMemory()) / mb);
 
        //Print free memory
        System.out.println("Free Memory:"
            + runtime.freeMemory() / mb);
         
        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
 
        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
	*/
        	ClusterMaker s=new ClusterMaker();
		s.compute(edges,r.getBookData());
		s.sortClusters();
		s.displayCluster();


	  }
}
