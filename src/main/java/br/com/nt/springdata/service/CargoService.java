package br.com.nt.springdata.service;

import java.util.Optional;
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
		System.out.println("Registo Salvo");

	}

	public void deletar(Scanner scanner) {
		System.out.println("ID Cargo");
		int id = scanner.nextInt();
		Optional<Cargo> descricao = cargoRespository.findById(id);
		System.out.println("Id selecionado :: " + id + " " + descricao.get().getDescricao());
		cargoRespository.deleteById(id);
		System.out.println("Registro deletado");

	}

	public void atualizar(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		System.out.println("Id selecionado :: " + id);
		System.out.println("Cargo informado :: " + descricao);
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRespository.save(cargo);
		System.out.println("Registro Atualizado");
	}
	
	
}
