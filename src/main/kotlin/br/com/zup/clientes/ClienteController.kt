package br.com.zup.clientes

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller(value = "/api/clientes")
class ClienteController(val repository: ClienteRepository) {

  @Post
  fun salvar(
    @Valid request: ClienteRequest): HttpResponse<Any> {
    val cliente: Cliente = request.toModel()
    repository.save(cliente)

    val uri = UriBuilder.of("/api/clientes/{id}")
      .expand(mutableMapOf(Pair("id", cliente.id)))

    return HttpResponse.created<Any?>(uri).body(request);
  }
}