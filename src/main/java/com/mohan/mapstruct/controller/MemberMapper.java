package com.mohan.mapstruct.controller;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.mohan.mapstruct.pojo.Member;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MemberMapper {

	@Mapping(source = "source", target = "onlyMobile", qualifiedByName = "onlyMobile")
	@Mapping(source = "source", target = "onlyWeb", qualifiedByName = "onlyWeb")
	@Mapping(source = "source", target = "onlyVoice", qualifiedByName = "onlyVoice")
    Member fromRequest(Member source);
    
    @Named("onlyMobile")
    default String onlyMobile(Member member) {
        if(member.getId()==1)
        	return member.getOnlyMobile();
		return null;
    }

    @Named("onlyWeb")
    default String onlyWeb(Member member) {
        if(member.getId()==2)
        	return member.getOnlyWeb();
		return null;
    }
    
    @Named("onlyVoice")
    default String onlyVoice(Member member) {
        if(member.getId()==3)
        	return member.getOnlyVoice();
		return null;
    }
}
