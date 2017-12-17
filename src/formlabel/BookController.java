package formlabel;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.tools.internal.ws.processor.model.Model;

@Controller
public class BookController implements Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private BookService bookService;
	
	@RequestMapping (value ="/book_input")
	public String inputBook(Model model){
		List<Category> categories=bookService.getAllCategory();
		return null;
	}
	
}
