package com.projeto.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.api.modelo.Veiculo;

@Repository
public interface Repositorio extends CrudRepository<Veiculo, Long >{

    Iterable<Veiculo> findByReservadoFalse();

    

    

   
    
}
