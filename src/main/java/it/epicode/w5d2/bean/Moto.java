package it.epicode.w5d2.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("moto")
public class Moto extends Veicolo{
    private String tipologia;

    @Override
    public String toString() {
        return "Moto{" + super.toString() +
                "tipologia='" + tipologia + '\'' +
                '}';
    }
}
