package br.com.k9care.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.k9care.enums.Sexo;

@Entity
@Table(name="tb_pedigree")
@SequenceGenerator(name = "pedigree", sequenceName = "pedigree_sequence", allocationSize = 1)
public class Pedigree {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "pedigree", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nome", nullable = false, length = 80)
	private String nome;
	
	@Column(name="raca", nullable = false)
	private String raca;
	
	@Column(name="sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name="cor", nullable = false)
	private String cor;
	
	@Column(name="data_emissao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataEmissao;
	
	@Column(name="data_nascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "pedigree")
	private Animal animal;
	
	public Pedigree() {}

	public Pedigree(String nome, String raca, Sexo sexo, String cor, Calendar dataNascimento) {
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.cor = cor;
		this.dataEmissao = new GregorianCalendar();
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Calendar getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
