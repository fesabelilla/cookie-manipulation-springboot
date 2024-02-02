package com.example.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Reff : https://websparrow.org/spring/spring-boot-cookies-example
@RestController
public class CookieController {

    @GetMapping("/set")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("test", "1_2_3_4_5");
        response.addCookie(cookie);
        return "Spring Boot Cookies";
    }


    @GetMapping("/get")
    public String getCookie(@CookieValue(value = "test", defaultValue = "Test") String test) {
        System.out.println(test);
        return test;
    }
}
