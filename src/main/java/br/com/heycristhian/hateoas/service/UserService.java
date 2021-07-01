package br.com.heycristhian.hateoas.service;

import br.com.heycristhian.hateoas.entity.domain.User;
import br.com.heycristhian.hateoas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired private UserRepository repository;

    public Optional<User> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }
}
