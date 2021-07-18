package br.com.zup.correiosenderecos.cadastroenderecos;

public class EnderecoRequest {

  private String logradouro;
  private String cidade;
  private String estado;
  private String numero;
  private String cep;

  public EnderecoRequest(String logradouro, String cidade, String estado, String numero, String cep) {
    this.logradouro = logradouro;
    this.cidade = cidade;
    this.estado = estado;
    this.numero = numero;
    this.cep = cep;
  }

	public Endereco toModel() {
		return new Endereco(logradouro, cidade, estado, numero, cep);
	}

  
}
