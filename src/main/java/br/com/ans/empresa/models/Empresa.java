package br.com.ans.empresa.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{
	
private static final long serialVersionUID = 3960436649365666213L;
	
	private Long id;
	private String razaoSocial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	
	public Empresa() {
		
	}
	
	/*
	 * @Id anota o campo como chave primária da tabela.
	 * 
	 * @GenerateValue define como a primary key será incrementada.
	 * 
	 * @Column define um nome para o campo na tabela, e se ele pode ou não ser nulo.
	 * 
	 * @PrePersist permite executar uma ação antes de uma inserção.
	 * 
	 * @PreUpdate o mesmo que @Prepersist, mas antes de uma atualização de registro.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="razao_social", nullable=false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name="cnpj", nullable=false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name="data_criacao", nullable=false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name="data_atualização", nullable=false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	/*
	 * @Override permite sobrescrever um método.
	 */
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "," + "dataCriacao=" + dataCriacao + "," + "dataAtualizacao=" + dataAtualizacao + "]";
	}

}
