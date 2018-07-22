package br.com.ans.empresa.services;

import java.util.Optional;

import br.com.ans.empresa.models.Usuario;

public interface UsuarioService {
	
	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
