package br.com.ans.empresa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ans.empresa.models.Usuario;
import br.com.ans.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> buscarPorEmail(String email) {

		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
		
	}

}
