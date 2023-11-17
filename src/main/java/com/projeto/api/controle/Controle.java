    package com.projeto.api.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.api.modelo.Veiculo;
import com.projeto.api.repositorio.Repositorio;

@RestController
@CrossOrigin(origins="*")
public class Controle { 

    @Autowired   
    private Repositorio acao;

    @PostMapping("/veiculos")
    public Veiculo cadastrar(@RequestBody Veiculo v){
        return acao.save(v);
    }

    

  

    @GetMapping("/veiculos/disponiveis")
public Iterable<Veiculo> buscarVeiculosDisponiveis() {
    return acao.findByReservadoFalse();
}


    @GetMapping("/veiculos")
    public Iterable<Veiculo> selecionar(){
        return acao.findAll();
    }

    @PutMapping("/veiculos")
public ResponseEntity<Veiculo> editar(@RequestBody Veiculo veiculoRecebido) {
    Optional<Veiculo> optionalVeiculo = acao.findById(veiculoRecebido.getId());

    if (optionalVeiculo.isPresent()) {
        Veiculo veiculo = optionalVeiculo.get();
        veiculo.setReservado(true); // Define o campo reservado como true

        
        veiculo = veiculoRecebido;

        
        acao.save(veiculo);

        return ResponseEntity.ok(veiculo); 
    } else {
        return ResponseEntity.notFound().build(); 
    }
}

    



    @DeleteMapping("/veiculos/{id}")
    public void remover(@PathVariable long id){
        acao.deleteById(id);
    }


    
}
