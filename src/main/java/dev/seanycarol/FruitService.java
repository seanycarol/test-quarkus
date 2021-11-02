package dev.seanycarol;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.arc.Lock;

@Lock // os métodos dentro da classe não podem mais ser chamados de forma
      // concorrente/paralela. Com ele tem o controle de acesso a determinados métodos
@ApplicationScoped
public final class FruitService {

  // @Lock(value = Type.READ, time = 3, unit = TimeUnit.SECONDS)
  public List<Fruit> list() {
    return Fruit.listAll();
  }

  @Transactional
  public void create(FruitDTO fruitDTO) {
    Fruit fruit = new Fruit();
    fruit.name = fruitDTO.getName();
    fruit.quantity = fruitDTO.getQuantity();

    fruit.persist();
  }
}
