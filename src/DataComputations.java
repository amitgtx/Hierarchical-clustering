import java.io.*;
import java.util.*;
public class DataComputations
{
	private ArrayList<Book> bookData;
	private Edge[] edges;
	private double[][] distance;

  public Edge[] getEdges()
  {
    return edges;
  }

  public ArrayList<Book> getBookData()
  {
    return bookData;
  }


	public void inputData()throws IOException
	{
		bookData=new ArrayList<Book>(50000);
		int c=1;
		BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
	    String s=k.readLine();

	try
	{
	    while(s!=null)
	    {
	      StringTokenizer st=new StringTokenizer(s,",<,>");
	      Book temp=new Book();
	 //     while(st.hasMoreTokens())
	   //   {
	      	
	        temp.setName(st.nextToken().trim());
	       
	        temp.setAuthor(st.nextToken().trim());

	        int d=0;
	        ArrayList<String> keywords=temp.getKeywords();
	        while(st.hasMoreTokens()&&(d<=1))
	        {
	           
		 	   String p=st.nextToken().trim();
	           if(p.equals(""))continue;
	           keywords.add(p);
	           d++;
	        }
	  
	        

	//      }
	      if(d!=0)bookData.add(temp);
	   
	      s=k.readLine();
	      c++;
	    }
    }
	  
    catch(Exception e)
	{
	    System.out.println(c +"\t"+e.getMessage());
	}
  }



	public void displayAllData()
	{
		for(int i=0;i<bookData.size();i++)
	    {
	      Book temp=bookData.get(i);
	      System.out.println("Book name :"+temp.getName());
	     System.out.println("Author :"+temp.getAuthor());
	      System.out.println("Keywords :");
	      for(int j=0;j<temp.getKeywords().size();j++)
	      {
	        System.out.println(temp.getKeywords().get(j));
	      }

	      System.out.println();
	  
	 
	    }
	  
	}

	public int min(int a,int b)
	{
		return a<b?a:b;
	}

	public double compareBook(Book b1,Book b2)
	{
		ArrayList<String> keywords1=b1.getKeywords();
		ArrayList<String> keywords2=b2.getKeywords();
   		if(keywords1.contains("NULL"))return 0;
   		if(keywords2.contains("NULL"))return 0;
		// int c=1;
		int sum=0;
  //  System.out.println(b1.getName()+"\t"+b2.getName());
		//for(int i=0;i<keywords1.size();i++)
		for(int i=0;i<keywords1.size();i++)
		{
			String temp=keywords1.get(i);
		//	if(temp.equalsIgnoreCase("NULL"))continue;
			if(keywords2.contains(temp))
    			  {
    				//    System.out.println(temp);
    				// sum+=(10000-c);
    			    // c=2*c;
    			    if(i==0)sum+=20;
    			    else sum+=3;
   			  }
		}

		// return ((2*(double)c)/(keywords1.size()+keywords2.size()))*100.0;
	return sum;

	}

	public void calculateDistanceAndMakeEdges()
	{
		int size=bookData.size();
		distance=new double[size][];
//		edges=new Edge[(size*(size-1))/2];
		int c=0;
		
		for(int i=0;i<size;i++)
			distance[i]=new double[size];
			
		for(int i=0;i<size;i++)
		{
			Book b1=bookData.get(i);
			for(int j=(i+1);j<size;j++)
			{
				if(i==j)
				{
					distance[i][j]=b1.getKeywords().size();
      				  	distance[j][i]=b1.getKeywords().size();
					continue;
				}
				Book b2=bookData.get(j);
        			double dist=compareBook(b1,b2);
				distance[i][j]=dist;
       				distance[j][i]=dist;
//				edges[c]=new Edge();
//				edges[c].setB1(i);
//				edges[c].setB2(j);
//        			edges[c].setWeight(dist);
//     				c++;
			}
		}
	}

	public void displayDistanceMatrix()
	{
		int size=bookData.size();
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print("\t"+(int)distance[i][j]);
			}
			System.out.println();
		}
	}


 
	public void makeMST(int start)
	{
			int size=bookData.size();
			// System.out.println("Size : "+size);
			double D[]=new double[size];
			int parent[]=new int[size];
			int visited[]=new int[size];
			TreeSet<A> s=new TreeSet<A>();
			edges=new Edge[size];

	

			



		D[start]=0;
		parent[start]=start;
		A temp=new A();
		temp.distance=D[start];
		temp.node=start;
		s.add(temp);
		int c=0;
		while(!s.isEmpty())
		{
			
			A top=s.pollFirst();
			int x=top.node;
			double xd=top.distance;
			visited[x]=1;
			Edge te=new Edge();
			te.setB1(parent[x]);
			te.setB2(x);
			te.setWeight(xd);
			edges[c]=te;
			c++;
			for(int y=0;y<size;y++)
			{
				if(y==x)continue;
				Book b1=bookData.get(x);
				Book b2=bookData.get(y);
				double yd=compareBook(b1,b2);

				if((yd>=D[y]) && (visited[y]==0))
				{
					A temp2=new A();
					temp2.distance=D[y];
					temp2.node=y;

					if(s.contains(temp2))
						s.remove(temp2);	

					A temp3=new A();
					temp3.distance=yd;
					temp3.node=y;
					
					D[y]=yd;
					parent[y]=x;
					s.add(temp3);

				}

			}


		}
	

	}
	



}
