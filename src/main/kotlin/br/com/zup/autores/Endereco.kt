package br.com.zup.autores

import javax.persistence.Embeddable

@Embeddable
class Endereco(
  enderecoResponse: EnderecoResponse,
  val numero: String
) {
  val logradouro = enderecoResponse.logradouro
  val cidade = enderecoResponse.cidade
  val estado = enderecoResponse.estado
  val cep = enderecoResponse.cep
}
