package cl.sermaluc.intranet.config.soap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapws/*");
    }

    @Bean(name = "type-user")
    public DefaultWsdl11Definition defaultWsdl11DefinitionTypeUser(@Qualifier("type-user-schema") XsdSchema typeUserSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TypeUserPort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://www.sermaluc.cl/soap/resources/type-user");
        wsdl11Definition.setSchema(typeUserSchema);
        return wsdl11Definition;
    }

    @Bean(name = "type-user-schema")
    public XsdSchema typeUserSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/domain/type-user.xsd"));
    }

    @Bean(name = "status")
    public DefaultWsdl11Definition defaultWsdl11DefinitionStatus(@Qualifier("status-schema") XsdSchema statusSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StatusPort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://www.sermaluc.cl/soap/resources/status");
        wsdl11Definition.setSchema(statusSchema);
        return wsdl11Definition;
    }

    @Bean(name = "status-schema")
    public XsdSchema statusSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/domain/status.xsd"));
    }
}
