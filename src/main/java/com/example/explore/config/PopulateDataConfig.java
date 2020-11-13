package com.example.explore.config;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.repository.FriendsRepository;
import com.example.explore.transformation.FriendsDto;
import com.example.explore.transformation.FriendsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class PopulateDataConfig {

    @Autowired
    FriendsRepository repository;

    @Autowired
    FriendsMapper mapper;


    @PostConstruct
    public void initilizeData() {



        FriendsDto data = FriendsDto.builder()
                .id(1)
                .firstName("Yogesh")
                .lastName("Sharma")
                .emailId("yogesh@gogesh.com")
                .build();

         repository.save(mapper.toEntity(data));

        data = FriendsDto.builder()
                .id(2)
                .firstName("Mohan")
                .lastName("Ganesh")
                .emailId("mohan@test.com")
                .build();


        repository.save(mapper.toEntity(data));





    }
}
