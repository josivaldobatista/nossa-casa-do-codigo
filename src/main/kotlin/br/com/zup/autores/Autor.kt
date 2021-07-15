package br.com.zup.autores

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_autor")
class Autor(
  val nome: String,
  val email: String,
  val descricao: String
) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null
  var uuid: String = UUID.randomUUID().toString()
  var criadoEm: LocalDateTime = LocalDateTime.now()
    private set
}
