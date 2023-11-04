package com.Darshan.CategoryProductCMS.Model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = "name")
	    }
	)
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
public class Category {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	@Column(unique =  true)
	private String name;
	
	@Column(length = 200)
	private String description;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Product> product;
	


}
