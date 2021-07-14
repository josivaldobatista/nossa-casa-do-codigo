package br.com.zup.autores

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller(value = "/api/autores")
class NovoAutorController {

  @Post
  fun cadastrar(@Body request: NovoAutorRequest) {
    println(request)
  }
}