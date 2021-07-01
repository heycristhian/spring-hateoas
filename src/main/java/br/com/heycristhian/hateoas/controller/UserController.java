package br.com.heycristhian.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.heycristhian.hateoas.entity.domain.User;
import br.com.heycristhian.hateoas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.findAll();
        users.forEach(user -> user.add(linkTo(methodOn(UserController.class).getUser(user.getUuid())).withSelfRel()));
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> getUser(@PathVariable UUID uuid) {
        User user = service.findById(uuid).orElseThrow(IllegalArgumentException::new);
        user.add(linkTo(methodOn(UserController.class).getUsers()).withRel("List of Products"));
        return ResponseEntity.ok(user);
    }
}
