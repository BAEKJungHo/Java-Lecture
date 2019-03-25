package Openchallenge;

public class InvalidLoginIdException extends Exception {
	public InvalidLoginIdException() { }
	public InvalidLoginIdException(String message) {
		super(message);
	}
}
