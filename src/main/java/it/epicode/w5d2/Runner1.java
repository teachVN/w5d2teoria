package it.epicode.w5d2;

import it.epicode.w5d2.bean.Auto;
import it.epicode.w5d2.bean.Moto;
import it.epicode.w5d2.bean.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Runner1 implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger("w5d2");

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Primo Runner");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d2Application.class);

        Moto m = ctx.getBean(Moto.class);
        m.setNome("CBR");
        m.setMarca("Honda");
        m.setTipologia("Sport");

        Persona p = ctx.getBean(Persona.class);

        System.out.println(p);

        Auto auto = ctx.getBean("smart", Auto.class);

        System.out.println(auto);

        Auto auto2 = ctx.getBean("scenic", Auto.class);

        logger.info(auto2.toString());




    }
}
