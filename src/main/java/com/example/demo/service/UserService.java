package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("Usuário com ID " + id + " não encontrado.");
        }
        return Optional.of(user.get());
    }

    public User createUser(User user) {
        // Verifica se o ID do usuário é fornecido e se já existe
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException("Usuário com ID " + user.getId() + " já está cadastrado.");
        }

        // Tenta salvar o usuário no banco de dados
        try {
            return userRepository.save(user);
        } catch (DuplicateKeyException e) {
            // Captura a exceção caso a chave única (como e-mail ou username) seja duplicada
            throw new UserAlreadyExistsException("Usuário com dados únicos fornecidos já existe.");
        }
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
