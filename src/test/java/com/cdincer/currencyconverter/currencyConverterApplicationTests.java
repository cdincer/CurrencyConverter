package com.cdincer.currencyconverter;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import com.cdincer.currencyconverter.rest.CclController;
import com.cdincer.currencyconverter.rest.CurrencyConversionController;
import com.cdincer.currencyconverter.rest.ExchangeRateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class currencyConverterApplicationTests {

	@Autowired
	private ExchangeRateController mRateController;

	@Autowired
	private CurrencyConversionController mCCController;

	@Autowired
	private CclController mCclController;



	@Test
	void CurrencyServiceMain(){
		//Just tap the API source to see if everything is fine
		assertThat(mRateController.exchangeRate("GBP","USD")).isNotEmpty();
	}

	@Test
	void CurrencyConversionService(){
		boolean CheckMessage = mCCController.exchangeRate("GBP","USD","100").contains(" is your transaction ID. Your conversions comes to ");
		if(!CheckMessage)
			fail("Transactions are broken");
	}


	@Test
	void CCListService(){
		//See if our database iniated properly and our search works. Check our data.sql to see what we put in there.
		if (mCclController.exchangeRate("USD","").size()  == 0)
		fail("Not enough results");


		if (mCclController.exchangeRate("","2020-06-18").size()  <= 1)
			fail("Not enough results");

		if (mCclController.exchangeRate("EUR","2020-06-18").size()  <= 1)
			fail("Not enough results");
	}

}
