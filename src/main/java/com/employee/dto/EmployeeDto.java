package com.employee.dto;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import org.immutables.value.Value.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize(as = ImmutableEmployeeDto.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface EmployeeDto {
	
	@Nullable 
	UUID getId();
	
	@NotNull
	String getName();
	
	@NotNull
	String getDob();
	
	@NotNull
	Double getSalary();
	
	@Nullable
	String getDesignation();
	
	@NotNull
	String getJoiningDate();
	
	@Nullable
	String getExitDate();
	
	@NotNull
	UUID getManagerId();

	@NotNull
	UUID getSystemId();

}
