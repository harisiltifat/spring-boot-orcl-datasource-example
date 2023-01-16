package com.github.tiagomac.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Table(schema="MIGSUITE", name="PERSON")
@Entity
@Data
public class Person {
	
	@Id
	private Long id;
	
	@Column
	private String name;

}
