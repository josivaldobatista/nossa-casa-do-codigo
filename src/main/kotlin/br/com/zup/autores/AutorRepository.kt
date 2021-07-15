package br.com.zup.autores

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface AutorRepository : CrudRepository<Autor, Long> {
}