package com.biswaljava.junit.model;

import java.math.BigDecimal;

public interface Amount {
	BigDecimal getValue();

	Currency getCurrency();
}
