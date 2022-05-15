package splitec.controller;

import org.springframework.web.bind.annotation.*;
import splitec.entities.User;
import splitec.service.Service;

/**
 * @author gabrielsperche
 */

@RestController
@RequestMapping("/api")
public class Controller extends Service {

    @PostMapping("/auth")
    public String login(@RequestBody User user) throws Exception {
        try {
            return authService(user);
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) throws Exception {
        try {
            return createUserService(user);
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
}