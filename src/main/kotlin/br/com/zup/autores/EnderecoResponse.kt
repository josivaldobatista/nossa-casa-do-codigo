package br.com.zup.autores

data class EnderecoResponse(
  val logradouro: String,
  val cidade: String,
  val estado: String,
  val numero: String,
  val cep: String
)
