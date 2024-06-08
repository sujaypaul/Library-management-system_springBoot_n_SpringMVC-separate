package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.User;

public class UserLogin {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static User getUser(String uname) {
        Map<String, String> param = new HashMap<>();
        param.put("id", uname);

        try {
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            User result = restTemplate.getForObject(GET_USER_BY_ID_API, User.class, param);

            return result;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static boolean checkUsername(String uname) {
        try {
            User user = getUser(uname);
            if (user != null && user.getUsername().equals(uname)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkPassword(String uname, String upass) {
        User user = getUser(uname);
        if (user != null && user.getPassword().equals(upass))
            return true;
        else
            return false;
    }
}

