package util;

public enum Status {

	FECHADO("Fechado"),ABERTO("Aberto");

	private String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
