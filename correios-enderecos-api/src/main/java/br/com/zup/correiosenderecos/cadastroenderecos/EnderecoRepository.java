package br.com.zup.correiosenderecos.cadastroenderecos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	Optional<Endereco> findByCep(String cep);
}
