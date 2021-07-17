package br.com.zup.autores

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_autor")
class Autor(
  val nome: String,
  val email: String,
  var descricao: String,
  val endereco: Endereco
) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null
  var uuid: String = UUID.randomUUID().toString()

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  var criadoEm: LocalDateTime = LocalDateTime.now()
  private set
}
