package com.mohan.mapstruct.service;

import org.springframework.stereotype.Service;

import com.mohan.mapstruct.pojo.Member;

@Service
public class MapStructService implements IMapStructService{

	public Member getMember(int id) {
		return Member.builder()
				.onlyMobile("Hello World")
				.onlyVoice("Hello World")
				.onlyWeb("Hello World")
				.memberName("Mohan")
				.id(id)
				.build();
	}
}
