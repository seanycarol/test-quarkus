package dev.seanycarol.produces;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

//O Produces é uma forma de dizer como que o container vai criar a classe
//que você quer injetar 
public class IdentificadorTransacaoProducer {

  @Produces
  @DefaultBean
  @RequestScoped
  public IdenticadorTransacao produceTest() {
    return new IdenticadorTransacao("Teste-");
  }

  @Produces
  @IfBuildProfile("prod")
  @RequestScoped
  public IdenticadorTransacao produceProd() {
    return new IdenticadorTransacao("Prod-");
  }
}
