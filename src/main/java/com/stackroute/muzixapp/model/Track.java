package com.stackroute.muzixapp.model;


import com.mysql.cj.api.xdevapi.Collection;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Track")
//make this class as hibernate entity
public class Track {
	@Id
	private int id;

	private String name;

	private String artist;

	private String Comments;



}