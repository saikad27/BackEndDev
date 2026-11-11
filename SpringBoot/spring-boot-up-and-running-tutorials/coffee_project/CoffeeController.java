package com.example.spring_websocket_tutorial.messagingstompwebsocket.coffee_project;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CoffeeController {

    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeController(){
        coffees.addAll(List.of(
                new Coffee("Espresso"),
                new Coffee("Latte"),
                new Coffee("Cappuccino"),
                new Coffee("Americano")
        ));
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    @RequestMapping(value="/coffees",method = RequestMethod.GET)
    Iterable<Coffee> getCoffee(){
        return coffees;
    }

    @RequestMapping(value="/coffees/{id}", method = RequestMethod.GET)
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c : coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @RequestMapping(value="/coffees", method = RequestMethod.POST)
    ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return new ResponseEntity<>(coffee, HttpStatus.CREATED);
    }

    @RequestMapping(value="/coffees/{id}", method = RequestMethod.PUT)
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int idx = -1;
        for(Coffee c : coffees){
            if(c.getId().equals(id)){
                idx = coffees.indexOf(c);
                coffees.set(idx,coffee);

            }
        }
        if(idx!=-1)
            return new ResponseEntity<>(coffee,HttpStatus.OK);
        return postCoffee(coffee);
    }

    @RequestMapping(value="/coffees/{id}",method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCoffee(@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
