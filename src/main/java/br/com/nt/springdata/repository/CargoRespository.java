package br.com.nt.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nt.springdata.entities.Cargo;

@Repository
public interface CargoRespository extends CrudRepository<Cargo, Integer> {

	public static void findByDesc(Cargo cargo) {}
}
