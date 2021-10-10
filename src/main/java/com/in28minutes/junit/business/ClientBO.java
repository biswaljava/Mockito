package com.biswaljava.junit.business;

import java.util.List;

import com.biswaljava.junit.business.exception.DifferentCurrenciesException;
import com.biswaljava.junit.model.Amount;
import com.biswaljava.junit.model.Product;

public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}