/**
 * 
 */
package com.soa.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

/**
 * 
 */
@EnableWs
@Configuration
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/calcular/*");
    }
    
    @Bean
    public SimpleXsdSchema calculadoraSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calculadora.xsd"));
    }

    @Bean(name = "calculadora") // Change the bean name to "calculadora"
    public Wsdl11Definition customWsdlDefinition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("calculadora.wsdl"));
        return wsdl11Definition;
    }

//    @Bean(name = "calculadora") // Change the bean name to "calculadora"
//    public Wsdl11Definition customXsdlDefinition() {
//        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
//        wsdl11Definition.setWsdl(new ClassPathResource("calculadora.xsd"));
//        return wsdl11Definition;
//    }
//    Definicion del mismo metodo sin tener el wsdl solo el schema, conviene más tener el wsdl
//    @Bean(name = "calculadora")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema calculadoraSchema) {
//    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("CalcularPort");
//        wsdl11Definition.setLocationUri("/calcular");
//        wsdl11Definition.setTargetNamespace("http://itq.edu/soa");
//        wsdl11Definition.setSchema(calculadoraSchema);
//        return wsdl11Definition;
//    }
}
