
package com.example.productapi.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(indexes=@Index(name="idx_product_name",columnList="productName")) 
public class Product{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotBlank
private String productName;

private String createdBy;
private LocalDateTime createdOn=LocalDateTime.now();

@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
private List<Item> items;


public Long getId(){return id;}
public void setId(Long id){this.id=id;}
public String getProductName(){return productName;}
public void setProductName(String productName){this.productName=productName;}
public String getCreatedBy(){return createdBy;}
public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
public LocalDateTime getCreatedOn(){return createdOn;}
public void setCreatedOn(LocalDateTime createdOn){this.createdOn=createdOn;}
public List<Item> getItems(){return items;}
public void setItems(List<Item> items){this.items=items;}
}
