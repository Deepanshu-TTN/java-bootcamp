package com.ttn.restful.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    MessageSource messageSource;

    public HelloController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/hello", params = {"username"})
    public String helloUser(@Param("username") String username){
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale);
        String greeting = messageSource.getMessage(
                "greeting.message",
                null,
                "Default IG",
                locale);
        return String.format("%s %s!", greeting, username);
    }
}
