package com.projeto.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="veiculos")
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String modelo;
    private String marca;
    private String cor;
    private int anoFabricacao;
    private String placa;
    private boolean reservado;

    public boolean possuiReserva(){
        return this.reservado;
    }
    
}
