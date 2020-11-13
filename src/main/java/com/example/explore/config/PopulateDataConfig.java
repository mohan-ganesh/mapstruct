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

        FriendsEntity entity = new FriendsEntity();

        entity.setId(1);
        entity.setFirstName("Yogesh");
        entity.setLastName("Sharma");
        entity.setEmailId("yogesh@gmail.com");

        repository.save(entity);


        entity = new FriendsEntity();

        entity.setId(2);
        entity.setFirstName("Mohan");
        entity.setLastName("Ganesh");
        entity.setEmailId("mohan@gmail.com");

        repository.save(entity);

        FriendsDto data = FriendsDto.builder()
                .id(1)
                .firstName("Yogesh-Copy")
                .lastName("Sharma")
                .emailId("yogesh-copy@gogesh.com")
                .build();

         repository.save(mapper.toEntity(data));

        data = FriendsDto.builder()
                .id(2)
                .firstName("Mohan-copy")
                .lastName("Ganesh-copy")
                .build();

        log.info(mapper.toEntity(data).toString());
        repository.save(mapper.toEntity(data));





    }
}
