package model;

import java.util.ArrayList;
import java.util.List;

public class Rol {

	private String name;
	private List<Usuario> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Usuario> getUsers() {
		return users;
	}
	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	public Rol(String name) {
		this.name = name;
		this.users = new ArrayList<Usuario>();
	}
	
}
