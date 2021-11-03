package dev.seanycarol.produces;

import java.time.Instant;
import java.util.Random;

public class IdenticadorTransacao {
  private String prefixo;
  private int idTransacao;
  private Instant inicio;

  public IdenticadorTransacao(String prefixo) {
    super();
    this.prefixo = prefixo;
    this.idTransacao = new Random().nextInt();
    this.inicio = Instant.now();
  }

  public String getIdenticadorTransacao() {
    return prefixo + idTransacao + " - " + inicio;
  }
}
