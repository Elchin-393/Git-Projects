package Model;

public class User {
	public User(int iD, String tcno, String name, String password, String type) {
		ID = iD;
		Tcno = tcno;
		Name = name;
		Password = password;
		Type = type;
	}
	
	public User() {}
	
	private int ID;
	String Tcno,Name,Password,Type;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTcno() {
		return Tcno;
	}
	public void setTcno(String tcno) {
		Tcno = tcno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

}
