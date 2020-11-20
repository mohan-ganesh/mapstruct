package com.mohan.mapstruct.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohan.mapstruct.pojo.Member;
import com.mohan.mapstruct.service.IMapStructService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MapStructController {

	private final IMapStructService mapStructService;
	private final MemberMapper memberMapper;
	
	@RequestMapping(path="/{id}")
	public Member differentResponse(@PathVariable int id) {
		Member member = mapStructService.getMember(id);
		return memberMapper.fromRequest(member);
	}
}
