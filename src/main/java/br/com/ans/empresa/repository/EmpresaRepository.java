package br.com.ans.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ans.empresa.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findByCnpj(String cnpj);

}
