package deal.exception;

public class NotExistException extends Exception {
	public NotExistException() {}
	public NotExistException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}
