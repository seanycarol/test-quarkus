package dev.seanycarol;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FruitServiceTest {

  @Inject
  FruitService fruitService;

  @Test
  public void testListFruits() {
    List<Fruit> list = fruitService.list();
    assertFalse(list.isEmpty());
  }
}
