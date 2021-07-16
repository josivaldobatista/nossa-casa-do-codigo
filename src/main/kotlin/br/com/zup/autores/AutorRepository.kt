package br.com.zup.autores

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface AutorRepository : CrudRepository<Autor, Long> {
  fun findByEmail(email: String): Optional<Autor>
}