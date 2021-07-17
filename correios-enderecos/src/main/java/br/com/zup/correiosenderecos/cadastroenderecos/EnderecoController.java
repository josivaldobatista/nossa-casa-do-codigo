package br.com.zup.correiosenderecos.cadastroenderecos;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/enderecos", produces = MediaType.APPLICATION_XML_VALUE)
public class EnderecoController {

	private EnderecoRepository repository;

	public EnderecoController(EnderecoRepository repository) {
		this.repository = repository;
	}

	@PostMapping
  public ResponseEntity<?> salvar(@RequestBody EnderecoRequest request) {
    Endereco endereco = request.toModel();
    repository.save(endereco);
  	
  	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(endereco.getId()).toUri();
  	
    return ResponseEntity.created(uri).body(endereco);
  }
	
	@GetMapping(value = "/{cep}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> buscarPorCep(@PathVariable("cep")  String cep) {
		Optional<Endereco> possivelEndereco = repository.findByCep(cep);
		
		return ResponseEntity.ok(possivelEndereco);
	}

}
