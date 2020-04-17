package br.com.k9care.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_adocao")
@SequenceGenerator(name = "adocao", sequenceName = "adocao_sequence",allocationSize = 1)
public class Adocao {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "adocao", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@OneToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="padrinho_cpf")
	private Padrinho padrinho;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "adocao")
	private List<Animal> animais =  new ArrayList<>();
	
	public Adocao() {}
	
	public Adocao(Padrinho padrinho) {
		this.data = new GregorianCalendar();
		this.padrinho = padrinho;
	}
	
	public void adotar(Animal animal) {
		this.animais.add(animal);
		animal.setAdocao(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public List<Animal> getAnimal() {
		return Collections.unmodifiableList(animais);
	}
	public void setAnimal(List<Animal> animais) {
		this.animais = animais;
	}
	public Padrinho getPadrinho() {
		return padrinho;
	}
	public void setPadrinho(Padrinho padrinho) {
		this.padrinho = padrinho;
	}
}
