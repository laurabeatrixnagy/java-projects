package PT2020.assign1.Assignment1.controller;

public class MissingInputException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MissingInputException(String msg) {
		super(msg);
	}
}

