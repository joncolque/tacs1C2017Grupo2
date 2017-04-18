package tacs;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.Usuario;
import repos.RepoUsuarios;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario user = RepoUsuarios.getInstance().buscarUsuario(userName);
		if(user == null)
			throw new UsernameNotFoundException(userName);
		
		return new UserDetailsImpl(user);
	}

}
