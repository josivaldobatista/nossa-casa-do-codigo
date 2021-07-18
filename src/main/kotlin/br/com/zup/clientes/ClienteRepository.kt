package br.com.zup.clientes

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ClienteRepository: CrudRepository<Cliente, Long>