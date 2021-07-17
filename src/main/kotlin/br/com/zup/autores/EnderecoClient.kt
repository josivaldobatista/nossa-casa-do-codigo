package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.annotation.Client

/**
 * Para testar esse client foi criado uma api simples apenas para
 * devolver o endereço buscando pelo CEP. Essa API, foi feita em JAVA
 * usando Spring Boot.
 * */

@Client(value = "http://localhost:8081")
interface EnderecoClient {

  @Get(
    value = "/api/enderecos/{cep}",
    consumes = [MediaType.APPLICATION_XML], //<- receber XML
    //produces = [MediaType.APPLICATION_XML]  //<- enviar XML
  )
  // @Consumes(MediaType.APPLICATION_XML) //<- Posso usar essa anotação em vez do código acima
  // @Produces(MediaType.APPLICATION_XML) //<- Posso usar essa anotação em vez do código acima
  fun consulta(cep: String): HttpResponse<EnderecoResponse>
}