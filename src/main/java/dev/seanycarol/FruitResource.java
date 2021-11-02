package dev.seanycarol;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/frutas")
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> list() {
        return fruitService.list();
    }

    @POST
    public void create(FruitDTO fruitDTO) {
        fruitService.create(fruitDTO);
    }
}