package login;

import org.springframework.stereotype.Service;

@Service 
public class AccountServiceImpl implements AccountService {

	  
	    @Override  
	    public Account read(String username, String password) {  
	        Account account = null;  
	        if (username.equals("snowolf") && password.equals("zlex")) {  
	            account = new Account();  
	            account.setId(1);  
	            account.setUsername(username);  
	            account.setPassword(password);  
	        }  
	        return account;  
	    }  
	  
	    @Override  
	    public Account read(int id) {  
	        Account account = new Account();  
	        account.setId(1);  
	        account.setUsername("snowolf");  
	        account.setPassword("zlex");  
	        return account;  
	    }  

}
