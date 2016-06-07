import java.util.*;


public class ClusterMaker
{
	private int parent[];
	private int rank[];
	private Cluster[] clusters;
	private int totalBooks;
	private int totalEdges;

	public int find(int x)
	{
		if(parent[x]!=x)
			parent[x]=find(parent[x]);
		return parent[x];
	}


	public void unionSet(int a,int b)
	{
		int roota=find(a);
		int rootb=find(b);

		if(rank[roota]<rank[rootb])parent[roota]=rootb;
		else
		if(rank[rootb]<rank[roota])parent[rootb]=roota;
		else
		{
			parent[roota]=rootb;
			rank[rootb]++;
		}
	}

	public void makeSet(int x)
	{
		parent[x]=x;
	}

	public void displayCluster()
	{
		System.out.println("\n\n");
		for(int i=0;i<totalBooks;i++)
		{
			ArrayList<Book> temp=clusters[i].getBooks();
			if(temp.size()==0)continue;
						//	if(temp!=null)
			for(int j=0;j<temp.size();j++)
			{
				System.out.println(temp.get(j).getName());
			}
			System.out.println("\n\n");
		}
	}

	public void compute(Edge[] edges,ArrayList<Book> bookData)
	{
		int count=0;
		totalBooks=bookData.size();
		totalEdges=(totalBooks*(totalBooks-1))/2;
		parent=new int[totalBooks];
		rank=new int[totalBooks];
		clusters=new Cluster[totalBooks];

		Arrays.sort(edges,new EdgeComparator());
		for(int i=0;i<totalBooks;i++)
		{
			makeSet(i);
			clusters[i]=new Cluster();
			clusters[i].setBooks(new ArrayList<Book>());
		}
		for(int i=0;i<totalEdges;i++)
		{
			// if(count>=(totalBooks-310))break;
			if(edges[i].getWeight()<23)break;
			int node1=edges[i].getB1();
			int node2=edges[i].getB2();
			int root1=find(node1);
			int root2=find(node2);
		//	System.out.println(node1+" "+root1+" "+node2+" "+root2+" "+edges[i].getWeight());
			if(root1!=root2)
			{
				unionSet(node1,node2);
				count++;
			}

		}

	//	System.out.println("\n\nBook\tCluster");
		for(int i=0;i<totalBooks;i++)
		{
			int temp=find(i);
			//System.out.println(i+"\t"+temp);
			ArrayList<Book> b=clusters[temp].getBooks();
			Book c=bookData.get(i);
			//if(b!=null)
			b.add(c);
		}

	}


}
