package employee_crud_converter;

public class converterException extends Exception {

	private String detail;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public converterException(String detail) {
		super();
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "converterException [detail=" + detail + "]";
	}

	
}
