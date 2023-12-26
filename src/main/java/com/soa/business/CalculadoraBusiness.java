/**
 * 
 */
package com.soa.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Component
 *///@Component
@Service
public class CalculadoraBusiness {
    /**
     * @param n1        Operando 1
     * @param n2        Operando 2
     * @param operacion Operación a realizar: sumar, restar, multiplicar o dividir.
     * @return
     */
    public double calcular(double n1, double n2, String operacion) {
        double resultado = 0;
        switch (operacion) {
        case "sumar":
            resultado = n1 + n2;
            break;
        case "restar":
            resultado = n1 - n2;
            break;
        case "multiplicar":
            resultado = n1 * n2;
            break;
        case "dividir":
            resultado = n1 / n2;
            break;
        default:
            throw new RuntimeException("Operación no valida");
        }
        return resultado;
    }

}
