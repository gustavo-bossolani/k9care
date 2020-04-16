package br.com.k9care.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.k9care.enums.Sexo;

@Entity
@Table(name="tb_padrinho")
public class Padrinho {

	@Id
	@Column(name="cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nome", length = 80)
	private String nome;
	
	@Column(name = "celular", length = 11)
	private BigInteger celular;
	
	@Column(name="sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "padrinho")
	private Adocao adocao;
	
	public Padrinho() {}
	
	public Padrinho(String cpf, String nome, BigInteger celular, Sexo sexo) {
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigInteger getCelular() {
		return celular;
	}
	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Adocao getAdocao() {
		return adocao;
	}
	public void setAdocao(Adocao adocao) {
		this.adocao = adocao;
	}
}
