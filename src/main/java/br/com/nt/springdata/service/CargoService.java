package br.com.nt.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.nt.springdata.entities.Cargo;
import br.com.nt.springdata.repository.CargoRespository;

@Service
public class CargoService {

	private CargoRespository cargoRespository;

	public CargoService(CargoRespository cargoRespository) {
		this.cargoRespository = cargoRespository;
	}

	public void iniciar(Scanner scanner) {
		salvar(scanner);
	}

	public void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRespository.save(cargo);
	}
}
