package com.hcl.poc.exception;

/**
 * Service Exception class for the application
 * @author Yogeesha R M
 *
 */
public class POCException extends Exception {
    
	private static final long serialVersionUID = 1L;
	private static final String EXCEPTION_HEADER = "POCException";
    public static final String TECHNICAL_ERROR_CODE = "0001";
    private Throwable cause;
    private String errorCode = TECHNICAL_ERROR_CODE;

    /**
     * Constructs a new POCException.
     */
    public POCException() {
        super();
    }

    /**
     * Constructs a new POCException with its detail message.
     * 
     * @param message
     *            String
     */
    public POCException(String message) {
        super(message);
    }

    /**
     * Constructs a new POCException with its detail message and cause.
     * 
     * @param message String
     * @param cause Throwable
     */
    public POCException(String message, Throwable cause) {
        super(message, cause);

        if (cause instanceof POCException) {
            this.cause = ((POCException) cause).getCause();
        } else {
            this.cause = cause;
        }
    }

    /**
     * Constructs a new POCException with its detail message and error code.
     * 
     * @param errorCode String
     * @param message String
     */
    public POCException(String errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }

    /**
     * Constructs a new POCException with error code, its detail message and actual cause.
     * 
     * @param errorCode String
     * @param message String
     * @param cause Throwable
     */
    public POCException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        setErrorCode(errorCode);
    }

    /**
     * Constructs a new POCException with actual cause.
     * 
     * @param cause Throwable
     */
    public POCException(Throwable cause) {
        this(EXCEPTION_HEADER, cause);
    }

    /**
     * returns the actual cause.
     * 
     * @return cause Throwable
     */
    public Throwable getCause() {
        return this.cause;
    }

    /**
     * returns exception message.
     * 
     * @return message String
     */
    public String getMessage() {
        String message = super.getMessage();
        if (this.cause == null) {
            return message;
        } else {
            String rootCause = this.cause.getMessage();
            if (rootCause == null) {
                return message;
            } else {
                return (message + " Root cause: " + rootCause);
            }
        }
    }

    /**
     * returns exception header.
     * 
     * @return String
     */
    public String getName() {
        return EXCEPTION_HEADER;
    }

    /**
     * returns error code.
     * 
     * @return String
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * set error code.
     * 
     * @param errorCode String
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
