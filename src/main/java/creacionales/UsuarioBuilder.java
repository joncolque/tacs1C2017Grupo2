package creacionales;

import model.Rol;
import model.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;
	
	public UsuarioBuilder(String name) {
		usuario = new Usuario();
		usuario.setUsername(name);
	}

	public UsuarioBuilder pass(String pass) {
		usuario.setPassword(pass);
		return this;
	}

	public UsuarioBuilder rol(Rol rol) {
		usuario.setRol(rol);
		return this;
	}
	
	public Usuario build() {
		return usuario;
	}
}
