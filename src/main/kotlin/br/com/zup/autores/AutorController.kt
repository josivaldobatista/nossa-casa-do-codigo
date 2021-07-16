package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.*
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller(value = "/api/autores")
class AutorController(val autorRepository: AutorRepository) {

  @Post
  fun create(@Body @Valid request: AutorRequest): HttpResponse<Any> {
    val autor = request.toModel()
    autorRepository.save(autor)

    val uri = UriBuilder.of("/api/autores/{id}")
      .expand(mutableMapOf(Pair("id", autor.id)))

    return created(uri)
  }

  @Get
  fun read(): HttpResponse<List<AutorResponse>> {
    val autores: MutableIterable<Autor> = autorRepository.findAll()
    val resposta = autores.map { autor -> AutorResponse(autor) }
    return ok(resposta)
  }

  @Get("/buscarPor")
  fun findByEmail(@QueryValue(value = "") email: String): HttpResponse<Any> {
    if (email.isEmpty()) {
      val autores = autorRepository.findAll()
      val resposta = autores.map { autor -> AutorResponse(autor) }
      return ok(resposta)
    }
    val possivelAutor = autorRepository.findByEmail(email)
    if (possivelAutor.isEmpty) {
      return notFound()
    }
    return ok(possivelAutor.get())
  }

  @Patch("/{id}")
  fun update(@PathVariable id: Long, descricao: String): HttpResponse<Any> {
    val possivelAutor = autorRepository.findById(id)

    if (possivelAutor.isEmpty) {
      return notFound()
    }

    val autor = possivelAutor.get()
    autor.descricao = descricao
    autorRepository.update(autor)

    return ok(AutorResponse(autor))
  }

  @Delete("/{id}")
  fun delete(@PathVariable id: Long): HttpResponse<Any> {
    val possivelAutor = autorRepository.findById(id)

    if (possivelAutor.isEmpty) {
      return notFound()
    }
    autorRepository.delete(possivelAutor.get()) //<- também posso fazer assim
    //autorRepository.deleteById(id)

    return noContent()
  }
}