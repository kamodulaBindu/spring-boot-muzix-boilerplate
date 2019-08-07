package com.stackroute.muzixapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Track")
//make this class as hibernate entity
public class Track {
	@Id
	private int id;

	private String name;

	private String comment;


}