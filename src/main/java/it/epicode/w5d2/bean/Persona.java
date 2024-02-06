package it.epicode.w5d2.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    @Autowired
    @Qualifier("smart")
    private Veicolo veicolo;

//    @Autowired //inizione di un veicolo di tipo moto attraverso il costruttore
//    public Persona(@Qualifier("moto") Veicolo veicolo){
//        this.veicolo=veicolo;
//        this.nome="Gaia";
//        this.cognome="Castello";
//        this.dataNascita=LocalDate.of(2020,2,2);
//    }
}
