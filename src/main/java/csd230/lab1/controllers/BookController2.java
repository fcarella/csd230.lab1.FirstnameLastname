package csd230.lab1.controllers;

import csd230.lab1.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import csd230.lab1.repositories.*;

import java.util.Optional;

@Controller
@RequestMapping("/books2")
public class BookController2 {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList2";
    }


    @GetMapping("/data")
    @ResponseBody
    public MyData getData() {
        return new MyData("Hello", "World"); // Returns a JSON response
    }

    static class MyData{
        private String name;
        private String value;

        public MyData(String name, String value){
            this.name = name;
            this.value = value;
        }
        public String getName(){
            return name;
        }
        public String getValue(){
            return value;
        }
    }

    @GetMapping("/search")
    @ResponseBody
    public MyData search(@RequestParam String name, @RequestParam(required = false) String value) {
        // you could use query and category to filter your results
        return new MyData(name, value); // Returns a JSON response
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Book bookDetails(@PathVariable Long id) {
        // You could use the id to get data from the database.
        Optional<Book> book = bookRepository.findById(id);
        Book b=null;
        if(book.isPresent()){
            b = book.get();
        }
        return b; // Returns the view name "product-details"
    }





}
