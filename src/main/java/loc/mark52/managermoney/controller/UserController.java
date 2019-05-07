package loc.mark52.managermoney.controller;

import loc.mark52.managermoney.data.entity.User;
import loc.mark52.managermoney.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController()
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Map<String, String> login(@RequestParam("email") String email) {
        return userToMap(userService.findByEmail(email));
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> registration(@Valid @RequestBody User user) {
        userService.save(user);
        return userToMap(user);
    }

    @GetMapping("{id}")
    public List<Map<String, String>> accounts(@PathVariable Long id) {
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, Double> accounts = userService.findById(id).getAccounts();
        for (Map.Entry<String, Double> account : accounts.entrySet()) {
            Map<String, String> result = new HashMap<>();
            result.put("currency", account.getKey());
            result.put("sum", account.getValue().toString());
            list.add(result);
        }

        return list;
    }

    private Map<String, String> userToMap(User user) {
        Map<String, String> response = new HashMap<>();
        response.put("id", Long.toString(user.getId()));
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        return response;
    }
}
