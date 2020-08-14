package club.banyuan.mall.common;

public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
	}

	public MyException(String message) {
		super(message);
	}

	public static void fail(String message) {
		throw new MyException(message);
	}

}
