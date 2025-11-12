package in.co.mark.common.exceptions;

/**
 * An <i>unchecked exception</i> which can be used when a resource or data which
 * is being looked for, and is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
	@java.io.Serial
	private static final long serialVersionUID = 8358634591784509994L;

	public ResourceNotFoundException() {
		super("Resource not found");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
