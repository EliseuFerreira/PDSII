package util;

public class DepartamentoNaoEncontradoException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public DepartamentoNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
