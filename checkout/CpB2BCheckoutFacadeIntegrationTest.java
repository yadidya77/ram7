/*
 * HRO 2.0
 */
package com.cp.facades.checkout;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.b2bacceleratorfacades.api.cart.CheckoutFacade;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BPaymentTypeData;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;


/**
 * Integration test for CP B2B Checkout Facade
 */
@IntegrationTest
public class CpB2BCheckoutFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource
	private CheckoutFacade b2bCheckoutFacade;

	@Test
	public void testUpdateCheckoutCart()
	{
		CartData cartData = new CartData();
		final B2BPaymentTypeData b2bPaymentTypeData = new B2BPaymentTypeData();
		final AddressData addressData = new AddressData();
		b2bPaymentTypeData.setCode("12345");
		cartData.setPaymentType(b2bPaymentTypeData);
		cartData.setPurchaseOrderNumber("12345");
		cartData.setDeliveryAddress(addressData);

		cartData = b2bCheckoutFacade.updateCheckoutCart(cartData);

		Assert.assertNotNull(cartData);

		if (null != cartData)
		{
			Assert.assertNotNull(cartData.getPaymentType());
		    Assert.assertNotNull(cartData.getPurchaseOrderNumber());
		    Assert.assertNotNull(cartData.getDeliveryAddress());
		}
		
	}

}
