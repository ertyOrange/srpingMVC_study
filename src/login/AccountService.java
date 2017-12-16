package login;

public interface AccountService {
	Account read(String username, String password);

	/**
	 * ªÒµ√’Àªß
	 * 
	 * @param id
	 * @return
	 */
	Account read(int id);

}
