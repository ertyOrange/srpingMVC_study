package formlabel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class BookServiceImp implements BookService {

	private List<Category> categories;
	private List<Book> books;

	public BookServiceImp() {
		categories = new ArrayList<Category>();
		Category Category1 = new Category(1, "Category1");
		Category Category2 = new Category(2, "Category2");
		Category Category3 = new Category(3, "Category3");

		categories.add(Category1);
		categories.add(Category2);
		categories.add(Category3);

		books = new ArrayList<Book>();
		books.add(0, new Book(0, "123", "java", Category1, "javasky1"));
		books.add(1, new Book(1, "345", "c++", Category1, "javasky2"));
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public Book save(Book book) {
		book.setId(getNexId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		int bookCount = books.size();
		for (int i = 0; i < bookCount; i++) {
			Book saveBook = books.get(i);
			if (saveBook.getId() == book.getId()) {
				books.set(i, book);
				return book;
			}
		}
		return book;
	}

	@Override
	public long getNexId() {
		long id = 0L;
		for (Book book : books) {
			long bookId = book.getId();
			if (bookId > id) {
				return id = bookId;
			}
		}
		return id + 1;
	}

	@Override
	public Book getById(long id) {

		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Category getCategory(int id) {
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
