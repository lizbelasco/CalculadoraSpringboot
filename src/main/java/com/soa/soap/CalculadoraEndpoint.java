/**
 * 
 */
package com.soa.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soa.business.CalculadoraBusiness;

import edu.itq.soa.EntradaCalculadora;
import edu.itq.soa.SalidaCalculadora;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class CalculadoraEndpoint {
    
    /*Objeto inyectado de la capa de negocio*/
    @Autowired
    private CalculadoraBusiness calculadora;
    
    /** target name space */
    private static final String NAMESPACE_URI = "http://itq.edu/soa";

    /**
     * Operación SOAP expuesta en http
     * @param request Objeto con datos de entrada. (Capa Modelo)
     * @return objeto con datos de salida (Capa de Modelo)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EntradaCalculadora")
    @ResponsePayload
    public SalidaCalculadora calcularOperation(@RequestPayload EntradaCalculadora request) {
        SalidaCalculadora out = new SalidaCalculadora();
        //Invocamos a la capa de negocio (control).
        double resultado = calculadora.calcular(request.getNumero1(),request.getNumero2(),request.getOperacion());
        out.setResultado(resultado);

        return out;
    }
}
