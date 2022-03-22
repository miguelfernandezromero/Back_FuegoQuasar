package com.edesafio.quasar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionDto {
	
	@JsonProperty("x")
	private Double x;
	
	@JsonProperty("y")
	private Double y;

}
