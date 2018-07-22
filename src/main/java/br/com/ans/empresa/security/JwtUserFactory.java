package br.com.ans.empresa.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.ans.empresa.enums.PerfilEnum;
import br.com.ans.empresa.models.Usuario;

/*
 * Converte o usuário no usuário reconhecido pelo Spring Security.
 */
public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	
	public static JwtUser create(Usuario usuario) {
		
		return new JwtUser(usuario.getId(),
				usuario.getEmail(),
				usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getPerfil()));
		
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfil) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		authorities.add(new SimpleGrantedAuthority(perfil.toString()));
		
		return authorities;
		
	}

}
