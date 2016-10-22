package at.fhj.itm.swq.debug;

import java.util.Set;

public class BookTable
{
	private Set<Book> books;
	
	public void insert(Book book)
	{
		if(book == null)
			throw new IllegalArgumentException();
		books.add(book);
	}

	// ...
	
	public Book findById(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		
		for(Book b: books)
		{
			if(getId() == id)
				return b;
		}
		return null;
	}

	public Set<Book> findAll()
	{
		return books;
	}
	
	private int getId()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
