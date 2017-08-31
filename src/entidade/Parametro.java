package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 *Parametro para notificação
 */

@Entity
public class Parametro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private float tamanho;
	
	@Column
	private int distancia;
	
	@OneToOne
	@Column(name="endereco_inical")
	private Endereco enderecoInicial;
	
	@OneToOne
	@Column(name="endereco_final")
	private Endereco enderencoFinal;
	
	@OneToOne
	private Peso peso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public Endereco getEnderecoInicial() {
		return enderecoInicial;
	}

	public void setEnderecoInicial(Endereco enderecoInicial) {
		this.enderecoInicial = enderecoInicial;
	}

	public Endereco getEnderencoFinal() {
		return enderencoFinal;
	}

	public void setEnderencoFinal(Endereco enderencoFinal) {
		this.enderencoFinal = enderencoFinal;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}
	
}
