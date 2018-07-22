package br.com.ans.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ans.empresa.models.Usuario;

/*
 * @Transacional torna o acesso mais rápido, já que não há nenhum tipo de lock no banco.
 */
@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
