/*
 * HRO 2.0
 */
package com.cp.facades.order;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import javax.annotation.Resource;

import org.junit.Test;


/**
 * Integration test for CP B2B Cart Facade
 */
@IntegrationTest
public class CpB2BOrderFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource(name = "cpOrderFacade")
	private CpOrderFacade cpOrderFacade;

	@Test
	public void testSavedEditedOrder()
	{
		final OrderData orderData = new OrderData();
		cpOrderFacade.saveEditedOrder(orderData);
	}

}
