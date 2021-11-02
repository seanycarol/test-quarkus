package dev.seanycarol;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/frutas")
public class FruitResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> list() {
        return Fruit.listAll();
    }

    @POST
    @Transactional
    public Fruit create() {
        Fruit fruit = new Fruit();
        fruit.name = "Maçã";
        fruit.quantity = 5;

        fruit.persist();
        return fruit;
    }
}