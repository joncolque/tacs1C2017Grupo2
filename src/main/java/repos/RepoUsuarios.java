package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import model.Usuario;;

@Component
public class RepoUsuarios {

	private static RepoUsuarios instance;
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static int counter = 1;
	
	public static RepoUsuarios getInstance() {
		if (instance == null) {
			instance = new RepoUsuarios();
		}
		return instance;
	}
	
	public void addUsuario(Usuario unUsuario) {
		unUsuario.setId(counter);
		usuarios.add(unUsuario);		
		counter++;
	}
	
	public  Usuario buscarUsuario(String nombre, String pass) throws Exception{
		List<Usuario> auxUsers = usuarios.stream().filter(usuario -> usuario.getUsername().toUpperCase().equals(nombre.toUpperCase()) && usuario.getPassword().equals(pass)).collect(Collectors.toList());
		
		if(auxUsers.isEmpty()){
			throw new Exception("Usuario Incorrecto");
		}
		
		return auxUsers.get(0);
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarios;
	}	
	
}
