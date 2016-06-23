import java.util.*;
public class Cluster implements Comparable<Cluster>
{
	private ArrayList<Book> books;

	public ArrayList<Book> getBooks()
	{
		return books;
	}

	public void setBooks(ArrayList<Book> books)
	{
		this.books=books;
	}

	public int compareTo(Cluster c)
	{
		if(this.getBooks().size()>c.getBooks().size())return -1;
			else if(this.getBooks().size()<c.getBooks().size())return 1;
			else return 0;
	}
}


class ClusterComparator implements Comparator<Cluster>
{
		public int compare(Cluster c1,Cluster c2)
		{
			if(c1.getBooks().size()>c2.getBooks().size())return -1;
			else if(c1.getBooks().size()<c2.getBooks().size())return 1;
			else return 0;
		}

}
