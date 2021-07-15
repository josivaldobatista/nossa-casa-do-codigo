package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.created
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller(value = "/api/autores")
class AutorController(val autorRepository: AutorRepository) {

  @Post
  fun cadastrar(@Body @Valid request: AutorRequest): HttpResponse<Any> {
    val autor = request.toModel()
    autorRepository.save(autor)

    val uri = UriBuilder.of("/api/autores/{id}")
      .expand(mutableMapOf(Pair("id", autor.id)))

    return created(uri)
  }

  @Get
  fun buscarAutores(): HttpResponse<List<AutorResponse>> {
    val autores: MutableIterable<Autor> = autorRepository.findAll()
    val resposta = autores.map { autor -> AutorResponse(autor) }
    return ok(resposta)
  }
}