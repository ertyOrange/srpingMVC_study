package formlabel;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book_input")
	public String inputBook(Model model) {
		List<Category> categories = bookService.getAllCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		return "formBook/BookAddForm";
	}

	@RequestMapping(value = "/book_edit/{id}")
	public String editBook(Model model, @RequestParam long id) {

		List<Category> categories = bookService.getAllCategory();
		Book book = bookService.getById(id);
		model.addAttribute("categories", categories);
		model.addAttribute("book", book);
		return "formBook/BookEidtForm";
	}

	@RequestMapping(value = "/book_save")
	public String saveBook(@ModelAttribute Book book) {
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
	}

	@RequestMapping(value = "book_list")
	public String listBook(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "formBook/BookList";
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	

	
	
}
