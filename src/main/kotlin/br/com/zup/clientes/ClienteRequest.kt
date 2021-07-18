package br.com.zup.clientes

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class ClienteRequest(
  @field:NotBlank val nome: String,
  @field:NotBlank @field:CpfOuCnpjValid val documento: String,
  @field:NotBlank val email: String
) {
  fun toModel(): Cliente {
    return Cliente(nome, documento, email)
  }
}
