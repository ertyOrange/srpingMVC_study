package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")  
public class LoginController {
	@Autowired
	private  AccountService accountService;
	
//	@ModelAttribute
//	public Account read(Integer id) {  
//        Account account = new Account();  
//        account.setId(1);  
//        account.setUsername("snowolf");  
//        account.setPassword("zlex");  
//        return account;  
//    }
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Account account = new Account();
		model.addAttribute("account", account);
		// 直接跳转到登录页面
		return "account/login";
	}
	
	@RequestMapping( method = RequestMethod.POST)  
    public String login(@ModelAttribute("account") Account account) {  
        Account acc = accountService.read(account.getUsername(), account  
                .getPassword());  
        if (acc != null) {  
            return "redirect:profile.do?id=" + acc.getId();  
        } else {  
            return "redirect:login";  
        }  
    }  
}
