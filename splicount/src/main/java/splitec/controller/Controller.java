package splitec.controller;

import org.springframework.web.bind.annotation.*;
import splitec.entities.User;
import splitec.service.Service;

@RestController
@RequestMapping("/api")
public class Controller extends Service {

    @PostMapping("/auth")
    public String login(@RequestBody User user) throws Exception {
        try {
            return auth(user);
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }
}