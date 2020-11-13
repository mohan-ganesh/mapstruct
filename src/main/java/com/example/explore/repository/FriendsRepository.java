package com.example.explore.repository;

import com.example.explore.entity.FriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsEntity, Long> {


}
