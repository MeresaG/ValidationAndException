package edu.miu.validationAndexception.controller;

import edu.miu.validationAndexception.dto.UserDto;
import edu.miu.validationAndexception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Optional<UserDto> optionalUser = Optional.ofNullable(userService.getById(id));
        return optionalUser.isPresent() ? new ResponseEntity<>(userService.getById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UserDto u) {
        Optional<UserDto> userDto = Optional.ofNullable(userService.save(u));
        return new ResponseEntity<>(userDto.get(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        Optional<UserDto> userDto = Optional.ofNullable(userService.delete(id));
        return userDto.isPresent() ? new ResponseEntity<>(userDto.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
