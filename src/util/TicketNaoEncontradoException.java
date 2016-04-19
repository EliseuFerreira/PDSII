package util;

public class TicketNaoEncontradoException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public TicketNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
