package it.epicode.w5d2;

import it.epicode.w5d2.bean.Auto;
import it.epicode.w5d2.bean.Moto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


@SpringBootTest
class W5d2ApplicationTests {
	static AnnotationConfigApplicationContext ctx;
	static int contatore=0;
	@BeforeAll
	static void accediAlContesto(){
		ctx = new AnnotationConfigApplicationContext(W5d2Application.class);
	}

	@Test
	void numeroPorteSmart() {
		Auto smart = ctx.getBean("smart", Auto.class);
		Assertions.assertEquals(2,smart.getNumeroPorte());
	}

	@Test
	void nomeEMarcaDaApplicationProperties(){
		Auto scenic = ctx.getBean("scenic", Auto.class);
		Assertions.assertTrue(("Scenic".equals(scenic.getNome()))&&("Renault".equals(scenic.getMarca())));
	}

	@Test
	void verificaBeanNotNull(){
		Auto scenic = ctx.getBean("scenic", Auto.class);
		Assertions.assertAll(
				()-> Assertions.assertNotNull(scenic),
				()->Assertions.assertTrue(("Scenic".equals(scenic.getNome()))&&("Renault".equals(scenic.getMarca())))
		);

	}

	@ParameterizedTest
	@ValueSource(ints = {2,5})
	void verificaNumeroPorteListaAuto(int numeroPorte){

		List<Auto> autoList = ctx.getBean("lista_auto", List.class);
		System.out.println(autoList.get(contatore));

		Assertions.assertEquals(numeroPorte,autoList.get(contatore++).getNumeroPorte());

	}

	@ParameterizedTest
	@CsvSource({"For2, 2", "Scenic, 5"})
	void verificaNumeroPorteListaAuto(String nome, int numeroPorte){

		List<Auto> autoList = ctx.getBean("lista_auto", List.class);
		Auto a = autoList.stream().filter(auto -> auto.getNome().equalsIgnoreCase(nome)).findAny().get();

		Assertions.assertEquals(numeroPorte,a.getNumeroPorte());

	}

	@Test
	void verificaMoto(){
		Moto m = ctx.getBean(Moto.class);
		System.out.println(m);
	}

	@AfterAll
	static void chiudiContesto(){
		ctx.close();
	}

}
