package util;

public class TecnicoNaoEncontradoException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public TecnicoNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
