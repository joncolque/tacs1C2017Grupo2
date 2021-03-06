package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hierarchyOfExceptions.UserNotFoundException;
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
			throw new UserNotFoundException("Usuario Incorrecto");
		}
		
		return auxUsers.get(0);
	}
	
	public  Usuario buscarUsuario(String nombre){
		List<Usuario> auxUsers = usuarios.stream().filter(usuario -> usuario.getUsername().toUpperCase().equals(nombre.toUpperCase())).collect(Collectors.toList());
		
//		if(auxUsers.isEmpty()){
//			throw new Exception("Usuario Incorrecto");
//		}
		
		return auxUsers.get(0);
	}
	
	public Usuario getUserById(long id) throws UserNotFoundException {
		for(Usuario u : usuarios) {
			if (u.getId() == (id)) {
				return u;
			}
		}
		
		throw new UserNotFoundException("Usuario invalido.");
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarios;
	}	
	
}
