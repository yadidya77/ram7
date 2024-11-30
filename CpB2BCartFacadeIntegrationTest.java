/*
 * HRO 2.0
 */
package com.cp.facades.cart;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.cp.facades.cart.data.CutoffInfoData;


/**
 * Integration test for CP B2B Cart Facade
 */
@IntegrationTest
public class CpB2BCartFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource(name = "cpCartFacade")
	private CpCartFacade cpCartFacade;

	@Test
	public void testGetCutOffDateTime()
	{
		final CutoffInfoData cutoffInfoData = cpCartFacade.getCutOffDateTime();
		Assert.assertNotNull(cutoffInfoData);
		Assert.assertNull(cutoffInfoData2);
	}

}
