package org.sai.tacocloud;

import org.sai.tacocloud.Ingredients.Type;

import java.util.List;

import java.util.Arrays;

/*
 import org.springframework.validation.Errors;
 import javax.validation.Valid;
 import org.springframework.web.bind.annotation.PostMapping;
 import java.util.stream.Collectors;
 import org.sai.tacocloud.Ingredients;
 import org.sai.tacocloud.Taco;
*/

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("FLTO","Flour Tortilla",Type.WRAP),
                new Ingredients("COTO","Corn Tortilla",Type.WRAP),
                new Ingredients("CHIK","Chicken",Type.PROTEIN),
                new Ingredients("LAM","Lamb",Type.PROTEIN),
                new Ingredients("TMTO","Diced Tomatoes",Type.VEGGIE),
                new Ingredients("LETC","Lettuce",Type.VEGGIE),
                new Ingredients("CHED","Cheddar",Type.CHEESE),
                new Ingredients("JACK","Monterrey Jack",Type.CHEESE),
                new Ingredients("SLSA","Salsa",Type.SAUCE),
                new Ingredients("SRCR","Sour Cream",Type.SAUCE)
        );
        Type[] types = Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),null);
        }
        model.addAttribute("design",null);
        return "design";
    }
}
