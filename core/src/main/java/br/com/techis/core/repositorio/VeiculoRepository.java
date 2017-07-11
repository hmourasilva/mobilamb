package br.com.techis.core.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.techis.core.modelo.Veiculo;

public interface VeiculoRepository extends MongoRepository<Veiculo, String>{

	public Veiculo findByPlaca(String placa);
}
