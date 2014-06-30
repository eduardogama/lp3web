package usertype;

public enum UserType {

	ELECTOR("Eleitor"), JOURNALIST("Jornalista"), ADMIN("Administrador");

	private String text;

	private UserType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
