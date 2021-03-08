package br.com.nt.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.nt.springdata.entities.UnidadeTrabalho;

@Repository
public interface UnidadeRepository extends CrudRepository<UnidadeTrabalho, Integer> {

}
