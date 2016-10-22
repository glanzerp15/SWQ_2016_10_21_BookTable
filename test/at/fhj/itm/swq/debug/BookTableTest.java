package at.fhj.itm.swq.debug;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import at.fhj.itm.swq.debug.Book;
import at.fhj.itm.swq.debug.BookTable;

public class BookTableTest
{
	@Rule
	public TestName testname = new TestName();
	final static Logger logger = Logger.getLogger("Testlogger");

	private BookTable table;
	
	@Before
	public void setup()
	{
		logger.info("Starting test: " + testname.getMethodName());
		
		table = new BookTable();
		table.insert(new Book(1, "Effective Java: A Programming Language Guide", "Joshua Bloch"));
		table.insert(new Book(2, "Design Patterns. Elements of Reusable Object-Oriented Software",
				"Erich Gamma", "Richard Helm", "Ralph E. Johnson", "John Vlissides"));
		table.insert(new Book(3, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"));
		table.insert(new Book(3, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"));		
	}
	
	
	@Test
	public void testFindById()
	{
		Book book = table.findById(1);
		
		Assert.assertEquals("Effective Java: A Programming Language Guide", book.getTitle());
		Assert.assertEquals(1, book.getAuthors().size());
		Assert.assertEquals("Joshua Bloch", book.getAuthors().get(0));
	}
	
	
	@Test
	public void testFindAll()
	{
		Set<Book> books = table.findAll();	
		Assert.assertEquals(3, books.size());
	}


	@Test
	public void testBookToString()
	{
		Book book = new Book(1, "Effective Java: A Programming Language Guide", "Joshua Bloch");		
		Assert.assertEquals("1,Effective Java: A Programming Language Guide,[Joshua Bloch]", book.toString());
	}
	
	
	@Test
	public void testBookPriceTable()
	{
		Map<Book,Long> books = new HashMap<Book,Long>();
		
		books.put(new Book(1, "Effective Java: A Programming Language Guide", "Joshua Bloch"), 3495L);
		books.put(new Book(3, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"), 4195L);
		
		Book book = new Book(1, "Effective Java: A Programming Language Guide", "Joshua Bloch");
		Assert.assertTrue(books.containsKey(book));
		long price = books.get(book);
		Assert.assertEquals(3495L, price);
	}
}

