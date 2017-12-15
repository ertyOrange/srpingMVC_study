package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


	@Controller  
	
	public class ProfileController {  
	    @Autowired  
	    private AccountService accountService;  
	  
	    /** 
	     * �˻���Ϣչʾ 
	     *  
	     * @param id 
	     * @param model 
	     * @return 
	     */  
	    @RequestMapping(value = "/profile")  
	    //@RequestMapping(method = RequestMethod.GET)  
	    public String profile(@RequestParam("id") int id, ModelMap model) {  
	        Account account = accountService.read(id);  
	        model.addAttribute("account", account);  
	  
	        // ��ת���û���Ϣҳ��  
	        return "account/profile";  
	    }  
	    
}