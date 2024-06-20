package com.pedro.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // preciso método controller apresentar formulario html
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // preciso metodo controller para processar o formulario lido
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    /* preciso metodo controller para ler dados do formulario
     e adicionar no Model*/
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // Ler parametros do request
        String name = request.getParameter("studentName");

        // Converter dados em UpperCase
        name = name.toUpperCase();

        // adicionar mensagem ao Model
        model.addAttribute("message", "Olá! " + name);

        // retorna página html com atributos modificados!
        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
        // Converter dados em UpperCase
        name = name.toUpperCase();

        // adicionar mensagem ao Model
        model.addAttribute("message", "Olá! " + name);

        // retorna página html com atributos modificados!
        return "helloworld";
    }
}
