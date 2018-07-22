package br.com.ans.empresa.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ans.empresa.models.Usuario;
import br.com.ans.empresa.security.JwtUserFactory;
import br.com.ans.empresa.services.UsuarioService;

/*
 * Serviço que manipula o UserDetailService.
 */
@Service
public class JwtUserDetialsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> funcionario = usuarioService.buscarPorEmail(username);

		if (funcionario.isPresent()) {
			
			return JwtUserFactory.create(funcionario.get());
		}
		

		throw new UsernameNotFoundException("Email não encontrado.");
		
	}
	
	

}
