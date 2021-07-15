package br.com.zup.autores

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller(value = "/api/autores")
class NovoAutorController(val autorRepository: AutorRepository) {

  @Post
  fun cadastrar(@Body @Valid request: NovoAutorRequest) {
    val autor = request.toModel()
    autorRepository.save(autor)
    println("Autor: Nome: ${autor.nome}, Email: ${autor.email}, Descrição: ${autor.descricao}")
  }
}