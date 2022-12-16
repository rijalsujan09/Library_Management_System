package library_Management_System;

public enum UserType {
	lIBRARIAN("LIBRARIAN", 1), STUDENT("STUDENT", 2);

	private String value;
	private int id;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	UserType( String value, int id) {
		this.id = id;
		this.value = value;
	}

	static UserType getByid(int id) {
		for (UserType user : UserType.values()) {
			if (user.id == id) {
				return user;
			}
		}
		return null;

	}
}