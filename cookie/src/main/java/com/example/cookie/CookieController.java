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
        Cookie cookie = new Cookie("user_name", "fesabelilla");
        response.addCookie(cookie);
        return "Cookie Set Successfully";
    }

    @GetMapping("/get")
    public String getCookie(@CookieValue(value = "user_name", defaultValue = "Test") String cookie) {
        if(cookie.equals("Test")) {
            return "No Cookie Found";
        }
        return cookie;
    }

    @GetMapping("/expiry")
    public String setCookieExpiry(HttpServletResponse response) {
        int cookieAgeInSeconds = 2;
        Cookie cookie = new Cookie("user_name", "fesabelilla");
        cookie.setMaxAge(cookieAgeInSeconds); // expire in 2 minutes
        response.addCookie(cookie);
        return "Cookie will expire in " + cookieAgeInSeconds + "seconds.";
    }

    @GetMapping("/delete")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user_name", null);
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);
        return "Cookie Deleted";
    }
}
