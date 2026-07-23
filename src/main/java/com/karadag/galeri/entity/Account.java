package com.karadag.galeri.entity;

import java.math.BigDecimal;

import com.karadag.galeri.enums.CurrencyType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Account extends BaseEntity {

	private String accountNo;

	private String iban;

	private BigDecimal balance;

	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;

}
