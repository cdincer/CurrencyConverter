package com.cdincer.CurrencyConverter;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import com.cdincer.CurrencyConverter.Rest.CCLController;
import com.cdincer.CurrencyConverter.Rest.CurrencyConversionController;
import com.cdincer.CurrencyConverter.Rest.ExchangeRateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyConverterApplicationTests {

	@Autowired
	private ExchangeRateController mRateController;

	@Autowired
	private CurrencyConversionController mCCController;

	@Autowired
	private CCLController mCCLController;

	@Test
	void contextLoads() {

	}


	@Test
	void CurrencyServiceMain(){
		//Just tap the API source to see if everything is fine
		assertThat(mRateController.ExchangeRate("GBP","USD")).isNotEmpty();
	}

	@Test
	void CurrencyConversionService(){
		boolean CheckMessage = mCCController.ExchangeRate("GBP","USD","100").contains(" is your transaction ID. Your conversions comes to ");
		if(!CheckMessage)
			fail("Transactions are broken");
	}


	@Test
	void CCListService(){
		//See if our database iniated properly and our search works. Check our data.sql to see what we put in there.
		if (mCCLController.ExchangeRate("USD","").size()  == 0)
		fail("Not enough results");


		if (mCCLController.ExchangeRate("","2020-06-18").size()  <= 1)
			fail("Not enough results");

		if (mCCLController.ExchangeRate("EUR","2020-06-18").size()  <= 1)
			fail("Not enough results");
	}

}
