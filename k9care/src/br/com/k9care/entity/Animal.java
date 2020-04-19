package br.com.k9care.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.k9care.enums.Especie;

@Entity
@Table(name="tb_animal")
@SequenceGenerator(name = "animal", sequenceName = "animal_sequence", allocationSize = 1)
public class Animal {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "animal", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="especie", nullable = false)
	@Enumerated(EnumType.STRING)
	private Especie especie;
	
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name="pedigree_id", nullable = false)
	private Pedigree pedigree;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "adocao_id", nullable = true)
	private Adocao adocao;
	
	public Animal() {}
	
	public Animal(Especie especie, Pedigree pedigree) {
		this.especie = especie;
		this.pedigree = pedigree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	public Pedigree getPedigree() {
		return pedigree;
	}
	public void setPedigree(Pedigree pedigree) {
		this.pedigree = pedigree;
	}
	public Adocao getAdocao() {
		return adocao;
	}
	public void setAdocao(Adocao adocao) {
		this.adocao = adocao;
	}
}
