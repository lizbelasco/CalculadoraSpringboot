package com.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soa.business.CalculadoraBusiness;

@SpringBootApplication
public class CalculadoraSpringbootApplication /* implements CommandLineRunner */ {
    
	public static void main(String[] args) {
		SpringApplication.run(CalculadoraSpringbootApplication.class, args);
	}

//   @Override
//   public void run(String... args) throws Exception {
//        System.out.println("argumentos: " + args);
//        for (String string : args) {
//            System.out.println(string);
//        }
//        System.out.println(calculadora.calcular(Double.parseDouble(args[1]), Double.parseDouble(args[2]), args[3]));
//    }

}
