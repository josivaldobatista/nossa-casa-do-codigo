package br.com.zup.autores

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest //<- Diz que os testes serão feitos a parti do contexto do Micronaut
internal class AutorControllerTest {

  @field:Inject
  lateinit var autorRepository: AutorRepository

  @field:Inject //<- Semelhante ao @Autowired do Spring
  @field:Client("/") //<- Vai atender as requisições a parti do "/" raiz do projeto
  lateinit var client: HttpClient

  private lateinit var autor: Autor

  @BeforeEach
  internal fun setUp() {
    val enderecoResponse = EnderecoResponse(
      logradouro = "Rua das Rosas", cidade = "São Paulo", estado = "SP", "44B", cep = "98654123"
    )
    val endereco = Endereco(enderecoResponse, "44B")

    autor = Autor(
      nome = "Bob Brown", email = "bob@email.com", descricao = "Escritor Bob Brown nascido hoje", endereco
    )
    autorRepository.save(autor)
  }

  @AfterEach
  internal fun tearDown() {
    autorRepository.deleteAll()
  }

  @Test
  fun `deve retorna os detalhes de um autor`() {

    val response = client.toBlocking().exchange(
      "/api/autores/buscarPor?email=${autor.email}", AutorResponse::class.java
    )

    assertEquals(HttpStatus.OK, response.status)
    assertNotNull(response.body())

    assertEquals(autor.nome, response.body().nome)
    assertEquals(autor.email, response.body().email)
    assertEquals(autor.descricao, response.body().descricao)
  }


}