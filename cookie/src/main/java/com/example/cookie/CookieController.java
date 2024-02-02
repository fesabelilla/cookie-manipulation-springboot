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


    @GetMapping("/expiry")
    public String setCookieExpiry(HttpServletResponse response) {
        int cookieAgeInSeconds = 86400;

        Cookie cookie = new Cookie("website", "https://websparrow.org");
        cookie.setMaxAge(cookieAgeInSeconds); // expire in 1 day
        response.addCookie(cookie);

        return "Cookie will expire in " + cookieAgeInSeconds + "seconds.";
    }

    @GetMapping("/delete")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("color", null);
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);

        return "Cookie deleted";
    }
}
