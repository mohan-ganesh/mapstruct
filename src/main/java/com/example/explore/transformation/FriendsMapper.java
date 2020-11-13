package com.example.explore.transformation;

import com.example.explore.entity.FriendsEntity;
import org.mapstruct.Mapper;


@Mapper (componentModel = "spring")
public abstract class FriendsMapper {


    public abstract FriendsDto toDto(FriendsEntity friendsEntity);

    public abstract FriendsEntity toEntity(FriendsDto friendsDto);


}
