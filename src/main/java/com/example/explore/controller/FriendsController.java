package com.example.explore.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.exception.ResourceNotFoundException;
import com.example.explore.repository.FriendsRepository;
import com.example.explore.transformation.FriendsDto;
import com.example.explore.transformation.FriendsMapper;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class FriendsController {
    @Autowired
    private FriendsRepository  friendsRepository;

    @Autowired
    FriendsMapper mapper;

    @GetMapping("/friends")
    public List <FriendsEntity> getAllFriends() {
        return friendsRepository.findAll();
    }

    @GetMapping("/friends/{id}")
    public ResponseEntity <FriendsDto> getFriendById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {

        FriendsEntity employee = friendsRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + employeeId));


        return ResponseEntity.ok().body(mapper.toDto(employee));
    }

    @PostMapping("/friends")
    public FriendsEntity createFriend(@Valid @RequestBody FriendsDto friends) {

        return friendsRepository.save(mapper.toEntity(friends));
    }

    @PutMapping("/friends/{id}")
    public ResponseEntity <FriendsEntity> updateFriend(@PathVariable(value = "id") Long friendId,
                                                         @Valid @RequestBody FriendsEntity friendDetails) throws ResourceNotFoundException {
        FriendsEntity friends = friendsRepository.findById(friendId)
                .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + friendId));

        friends.setEmailId(friendDetails.getEmailId());
        friends.setLastName(friendDetails.getLastName());
        friends.setFirstName(friendDetails.getFirstName());

        final FriendsEntity friend= friendsRepository.save(friends);
        return ResponseEntity.ok(friend);
    }

    @DeleteMapping("/friends/{id}")
    public Map < String, Boolean > deleteFriend(@PathVariable(value = "id") Long friendId)
            throws ResourceNotFoundException {
        FriendsEntity friend = friendsRepository.findById(friendId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +friendId));

        friendsRepository.delete(friend);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
