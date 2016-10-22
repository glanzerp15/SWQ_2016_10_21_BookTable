package at.fhj.itm.swq.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book
{
	public Book(int id, String title, String... authors)
	{
		setId(id);
		setTitle(title);
		setAuthors(Arrays.asList(authors));
	}
	

	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors()
	{
		return authors;
	}
	public void setAuthors(List<String> authors)
	{
		this.authors = authors;
	}
	
	public String toSting()
	{
		return getId() + "," + getTitle() + "," + getAuthors();
	}
}
