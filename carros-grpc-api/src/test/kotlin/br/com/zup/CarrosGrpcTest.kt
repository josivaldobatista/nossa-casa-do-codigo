package br.com.zup
import br.com.zup.carros.Carro
import br.com.zup.carros.CarroRepository
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false, // default=true
    transactionMode = TransactionMode.SINGLE_TRANSACTION,
    transactional = false // default=true
)
class CarrosGrpcTest {

    /**
     * Estratégias para trabalhar com banco de dados
     *
     * louça: sujou, limpou -> @AfterEach
     * louça: limpou, usou  -> @BeforeEach [x] = Escolha do Rafael Pontes
     * louça: usar loula descartavel -> "rollback=true" no @MicronautTest
     * loula: usar louça, jogo fora, comprar nova -> recriar banco a cada teste
     * */

    @Inject
    lateinit var repository: CarroRepository

    @BeforeEach
    fun setUp() {
        // Cenário
        repository.deleteAll()

        // Ação
        repository.save(Carro(modelo = "BMW Série 1", placa = "BXM1245"))
    }

    @AfterEach
    fun  cleanUp() {
        repository.deleteAll()
    }

    @Test
    fun `deve salvar um novo carro` () {
        // Validação
        assertEquals(1, repository.count())
    }

    @Test
    fun `deve encontrar carro por placa`() {
        val possivelCarro = repository.existsByPlaca("BXM1245")

        // Validação
        assertTrue(possivelCarro)
    }

}
