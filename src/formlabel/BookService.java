package formlabel;

import java.util.List;

public interface BookService {
	public List<Category> getAllCategory();
	public List< Book> getAllBooks();
	public Book save (Book book);
	public Book update (Book book);
	public long getNexId();
	public Book getById(long id);
	public Category getCategory(int id);
}
