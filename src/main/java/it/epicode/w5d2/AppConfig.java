package it.epicode.w5d2;

import it.epicode.w5d2.bean.Auto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean("smart")
    public Auto smart(){
        Auto auto = new Auto();
        auto.setNome("For2");
        auto.setMarca("Smart");
        auto.setNumeroPorte(2);
        return auto;
    }

    @Bean("scenic")//bean che recupera nome e cognome dell'auto dall'application.properties
    public Auto scenic(@Value("${w5d2.nome}") String nome, @Value("${w5d2.marca}") String marca){
        Auto auto = new Auto();
        auto.setNome(nome);
        auto.setMarca(marca);
        auto.setNumeroPorte(5);
        return auto;
    }
}
