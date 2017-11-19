package fr.bigtao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bigta on 18/11/2017.
 */
@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter  {

    public static void main(String ... args) {
        SpringApplication.run(fr.bigtao.ResourceServer.class, args);
    }


    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        tokenService.setClientId("resource-server");
        tokenService.setClientSecret("resource-server");
        return tokenService;
    }

    @RequestMapping(path = "/secured")
    public String securedRessource() {
        return "Hello World";
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenService()).resourceId("my-secured-data");
    }
}
