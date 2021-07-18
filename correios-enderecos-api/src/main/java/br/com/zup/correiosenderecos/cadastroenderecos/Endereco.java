package br.com.zup.correiosenderecos.cadastroenderecos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty
  private String logradouro;
  
  @JsonProperty
  private String cidade;
  
  @JsonProperty
  private String estado;

  @JsonProperty
  private String numero;
  
  @JsonProperty
  private String cep;

  @Deprecated
  public Endereco() {
  }

  public Endereco(String logradouro, String cidade, String estado, String numero, String cep) {
    this.logradouro = logradouro;
    this.cidade = cidade;
    this.estado = estado;
    this.numero = numero;
    this.cep = cep;
  }
  
  public Long getId() {
		return id;
	}
  
}
