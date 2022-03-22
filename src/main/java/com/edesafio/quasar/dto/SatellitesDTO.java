package com.edesafio.quasar.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@ApiModel(value = "Satellites")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SatellitesDTO {
	
	@JsonProperty("satellites")
	private List<SatelliteDTO> satellite;

}
