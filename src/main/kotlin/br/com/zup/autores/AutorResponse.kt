package br.com.zup.autores

class AutorResponse(autor: Autor) {

  val nome = autor.nome
  val email = autor.email
  val descicao = autor.descricao

}
