package dev.seanycarol;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dev.seanycarol.produces.IdenticadorTransacao;
import io.quarkus.arc.Lock;

@Lock // os métodos dentro da classe não podem mais ser chamados de forma
      // concorrente/paralela. Com ele tem o controle de acesso a determinados métodos
@ApplicationScoped
public final class FruitService {

  @Inject
  IdenticadorTransacao identicadorTransacao;

  // @Lock(value = Type.READ, time = 3, unit = TimeUnit.SECONDS)
  public List<Fruit> list() {
    System.out.println(identicadorTransacao.getIdenticadorTransacao());
    return Fruit.listAll();
  }

  @Transactional
  public void create(FruitDTO fruitDTO) {
    System.out.println(identicadorTransacao.getIdenticadorTransacao());
    Fruit fruit = new Fruit();
    fruit.name = fruitDTO.getName();
    fruit.quantity = fruitDTO.getQuantity();

    fruit.persist();
  }
}
