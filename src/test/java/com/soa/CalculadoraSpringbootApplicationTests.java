package com.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soa.business.CalculadoraBusiness;

@SpringBootTest
class CalculadoraSpringbootApplicationTests {

    @Autowired
    private CalculadoraBusiness calculadora;

    @Test
    void sumarTest() {
        double resultado = calculadora.calcular(56,4,"sumar");
        assertEquals(60, resultado);
    }
    
    @Test
    void restarTest() {
        double resultado = calculadora.calcular(56,4,"restar");
        assertEquals(52, resultado);
    }
    
    @Test
    void multiplicarTest() {
        double resultado = calculadora.calcular(56,4,"multiplicar");
        assertEquals(224, resultado);
    }
    
    @Test
    void dividirTest() {
        CalculadoraBusiness calculadora = new CalculadoraBusiness();
        double resultado = calculadora.calcular(56,4,"dividir");
        assertEquals(14, resultado);
    }
    
    @Test
    void operacionInvalidaTest() {
        double resultado = calculadora.calcular(56,4,"otra");
        System.out.println(resultado);
    }
}
