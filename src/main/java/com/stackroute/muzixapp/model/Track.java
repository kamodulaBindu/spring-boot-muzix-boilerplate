package com.stackroute.muzixapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

//make this class as hibernate entity
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {

	@Id
	private int id;

	private String name;

	private String comment;

	}