package br.com.zup.carros

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "tb_carros")
class Carro(

  @field:NotBlank
  @Column(nullable = false)
  val modelo: String,

  @field:NotBlank
  @Column(nullable = false, unique = true)
  val placa: String
) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null
}