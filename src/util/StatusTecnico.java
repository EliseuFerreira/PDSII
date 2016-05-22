package util;

public enum StatusTecnico {

	INATIVO("Inativo"),ATIVO("Ativo");

	private String status;

	StatusTecnico(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
