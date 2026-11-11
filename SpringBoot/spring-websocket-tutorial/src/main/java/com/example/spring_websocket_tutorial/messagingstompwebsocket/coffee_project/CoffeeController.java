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
@RequestMapping("/coffees")
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

    @GetMapping
    Iterable<Coffee> getCoffee(){
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c : coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return new ResponseEntity<>(coffee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCoffee(@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
