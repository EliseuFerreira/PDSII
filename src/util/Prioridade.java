package util;

public enum Prioridade {

	BAIXA("Baixa"), MEDIA("Media"), ALTA("Alta"), URGENTE("Urgente");

	private String prioridade;

	Prioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getPrioridade() {
		return prioridade;
	}

}
