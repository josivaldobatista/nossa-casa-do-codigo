package br.com.zup.autores

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class AutorRequest(
  @field:NotBlank val nome: String,
  @field:NotBlank @field:Email val email: String,
  @field:NotBlank @field:Size(max = 400) val descricao: String,
  @field:NotNull val numero: String,
  @field:NotNull val cep: String
) {

  fun toModel(enderecoResponse: EnderecoResponse): Autor {
    val endereco = Endereco(enderecoResponse, numero)
    return Autor(nome, email, descricao, endereco)
  }
}
