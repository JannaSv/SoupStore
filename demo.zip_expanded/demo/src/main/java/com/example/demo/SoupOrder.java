package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Table
public class SoupOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private Date placedAt;
	
	@NotBlank(message="Заполните поле")
	private String deliveryName;
	@NotBlank(message="Заполните поле")
	private String deliveryStreet;
	@NotBlank(message="Заполните поле")
	private String deliveryCity;
	@NotBlank(message="Заполните поле")
	private String deliveryState;
	@NotBlank(message="Заполните поле")
	private String deliveryZip;
	@CreditCardNumber(message="Введите верный номер карты")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Введите дату в формате MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Неверный номер")
	private String ccCVV;
	
	private List <Soup> soups = new ArrayList<>();
	
	public void addSoup(Soup soup) {
		this.soups.add(soup);
	}
}
