package br.com.gradle.utilizando.gradle.demo;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class HttpsRedirectConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainerCustomizer() {
        return server -> server.addConnectorCustomizers(connector -> {
            connector.setScheme("http");
            connector.setSecure(false);
            connector.setRedirectPort(443);
        });
    }
}