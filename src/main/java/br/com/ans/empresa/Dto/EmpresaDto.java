package br.com.ans.empresa.Dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

/*
 * DTO (Data Transfer Object) padroniza as requisições HTTP
 */
public class EmpresaDto {
	
	private Long id;
	private String razaoSocial;
	private String cnpj;
	
	public EmpresaDto() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Regras de validação são aplicadas nos DTOs.
	 * @NotEmpty da Hibernate Validator está deprecated.
	 * para as validações terem efeito, deve-se por @Valid no respectivo controller.
	 */
	@NotEmpty(message = "Razão social não pode ser vazia.")
	@Length(min = 5, max = 200, message = "Razão social deve conter 5 a 200 caracteres.")
	public String getRazaosocial() {
		return razaoSocial;
	}

	public void setRazaosocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	@NotEmpty(message = "CNPJ não pode ser vazio.")
	@CNPJ(message = "CNPJ inválido.")
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "EmpresaDto [id=" + id + ",razaoSocial=" + razaoSocial + ",cnpj=" + cnpj + "]";
	}

}
