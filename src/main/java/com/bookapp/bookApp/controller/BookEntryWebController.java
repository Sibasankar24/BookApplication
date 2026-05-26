package com.bookapp.bookApp.controller;

import com.bookapp.bookApp.entity.BookEntry;
import com.bookapp.bookApp.service.BookEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookEntryWebController {

    @Autowired
    BookEntryService bookEntryService;

    @GetMapping
    public String viewHomePage(Model model){
        List<BookEntry> bookEntries=bookEntryService.findAllBookEntries();
        model.addAttribute("bookEntries", bookEntries);
        return "index";
    }
    @GetMapping("/showNewBookEntryForm")
    public String showNewBookEntryForm(Model model){
        BookEntry bookEntry=new BookEntry();
        model.addAttribute("bookentry",bookEntry);
        return "add-book";
    }
    /*public  String saveBookEntry(@ModelAttribute("bookentry" BookEntry bookEntry)){
        return "redirect:/";
    }*/

}
