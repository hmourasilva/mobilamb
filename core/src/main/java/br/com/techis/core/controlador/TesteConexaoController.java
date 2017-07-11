package br.com.techis.core.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techis.core.modelo.Veiculo;
import br.com.techis.core.repositorio.VeiculoRepository;

@RestController
public class TesteConexaoController {
	private static final Logger logger = LoggerFactory.getLogger(TesteConexaoController.class);

	@Autowired
	private VeiculoRepository repositorio;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/listarVeiculos")
	public List<Veiculo> listaServicos() {

		List<Veiculo> veiculos = repositorio.findAll();
		for (Veiculo veiculo : veiculos) {
			logger.debug(String.format("[VEICULO] (ID: %s) (PLACA: %s) (FROTA: %s)", veiculo.getId(), veiculo.getPlaca(), veiculo.getFrota()));
		}

		return veiculos;
	}

	@RequestMapping("/buscarVeiculo/{placa}")
	public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable("placa") String placa) {
		logger.debug("Placa recebida pelo metodo (" + placa + ")");
		HttpStatus status = HttpStatus.OK;

		Veiculo veiculo = repositorio.findByPlaca(placa);
		if (veiculo == null) {
			status = HttpStatus.NOT_FOUND;
		} else {
			logger.debug(String.format("Veiculo retornado (ID: %s) (PLACA: %s) (FROTA: %s)", veiculo.getId(), veiculo.getPlaca(), veiculo.getFrota()));
		}

		return new ResponseEntity<Veiculo>(veiculo, status);
	}

	@RequestMapping("/adicionarVeiculo/{placa},{frota}")
	public ResponseEntity<Veiculo> adicionarVeiculo(@PathVariable("placa") String placa, @PathVariable("frota") String frota) {
		HttpStatus status = HttpStatus.OK;

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setFrota(frota);
		veiculo = repositorio.insert(veiculo);

		if (veiculo == null) {
			status = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<Veiculo>(veiculo, status);
	}
}
