package br.com.zup.clientes

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_cliente")
class Cliente(
  val nome: String,
  val documento: String,
  val email: String
) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null

  var uuid: String = UUID.randomUUID().toString()
}