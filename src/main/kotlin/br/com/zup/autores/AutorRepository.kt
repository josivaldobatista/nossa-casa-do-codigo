package br.com.zup.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface AutorRepository : CrudRepository<Autor, Long> {
  fun findByEmail(email: String): Optional<Autor>

  @Query("SELECT a FROM Autor a WHERE a.email = :email")
  fun buscarByEmailQueryJpql(email: String): Optional<Autor>
}