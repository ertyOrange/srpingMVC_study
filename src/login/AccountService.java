package login;

public interface AccountService {
	Account read(String username, String password);

	/**
	 * ����˻�
	 * 
	 * @param id
	 * @return
	 */
	Account read(int id);

}
