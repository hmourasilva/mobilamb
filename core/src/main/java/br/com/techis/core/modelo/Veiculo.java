package br.com.techis.core.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="veiculo")
public class Veiculo {
	
	@Id
	private String id;
	
	private String placa;
	private String frota;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getFrota() {
		return frota;
	}
	public void setFrota(String frota) {
		this.frota = frota;
	}
	
}
