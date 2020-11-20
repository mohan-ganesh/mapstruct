package com.mohan.mapstruct.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 68088997580844652L;
	private String memberName;
	private String onlyMobile;
	private String onlyWeb;
	private String onlyVoice;
	private int id;
}
