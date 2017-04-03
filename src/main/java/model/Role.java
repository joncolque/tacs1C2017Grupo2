package model;

import java.util.ArrayList;
import java.util.List;

public class Role {

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
	public Role(String name) {
		this.name = name;
		this.users = new ArrayList<Usuario>();
	}
	
}
