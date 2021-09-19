package rocketpowers.productstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketpowers.productstore.model.AnswerModel;
import rocketpowers.productstore.model.ProductModel;
import rocketpowers.productstore.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository actions;

    //list
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductModel> listar() {
        return actions.findAll();

    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    ProductModel register(@RequestBody ProductModel product) {
        return actions.save(product);

    }

    // Filtrar produtos
    @RequestMapping(value = "/products/{code}", method = RequestMethod.GET)
    public @ResponseBody
    ProductModel filter(@PathVariable Integer code) {
        return actions.findByCode(code);
    }

    // Alterproducts
    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public @ResponseBody
    ProductModel alter(@RequestBody ProductModel product) {
        return actions.save(product);
    }

    // Remover produtos
    @RequestMapping(value = "/products/{code}", method = RequestMethod.DELETE)
    public @ResponseBody AnswerModel remove(@PathVariable Integer code) {

        AnswerModel answer = new AnswerModel();

        try {

            ProductModel product = filter(code);
            this.actions.delete(product);
            answer.setMessage("successfully delete product ");
        }catch(Exception error) {
            answer.setMessage("failed to  remove " +error.getMessage());

        }
            return answer;

        }

    }
