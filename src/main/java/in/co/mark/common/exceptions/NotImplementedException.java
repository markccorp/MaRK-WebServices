package in.co.mark.common.exceptions;

/**
 * An <i>unchecked exception</i> which can be used in the methods that are not
 * yet implemented to avoid and handle any accidental calls of those methods.
 */
public class NotImplementedException extends RuntimeException {
	@java.io.Serial
	private static final long serialVersionUID = -3536041729056300110L;

	public NotImplementedException() {
		super("This method is not yet implemented.");
	}

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(Throwable cause) {
		super(cause);
	}

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
