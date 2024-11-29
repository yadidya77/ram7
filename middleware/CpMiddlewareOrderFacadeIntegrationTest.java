/*
 * HRO 2.0
 */

package com.cp.facades.middleware;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.cp.facades.order.middleware.CpMiddlewareOrderFacade;
import com.google.gson.JsonObject;


/**
 * Integration test suite for RestBridge Middleware Facades.
 */
@IntegrationTest
public class CpMiddlewareOrderFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	public static final String ORDER_NUMBER = "ORDER_NUMBER";
	public static final String SHIP_TO = "SHIP_TO";
	public static final String EMAIL = "EMAIL";
	public static final String REQ_DATE = "REQ_DATE";
	public static final String MATERIAL = "MATERIAL";
	public static final String QUANTITY = "QUANTITY";
	public static final String PO_NUMBER = "PO_NUMBER";
	public static final String ORDER_ITEMS = "ORDER_ITEMS";

	@Resource
	private CpMiddlewareOrderFacade cpMiddlewareOrderFacade;

	/**
	 * "ZHYBRIS_CREATE_ORDER_NEW"
	 */
	@Test
	public void createOrder(final Map<String, Object> inputData)
	{
		// Need sample input list
	}

	/**
	 * "ZHYBRIS_CREATE_RETURN_ORDER"
	 */
	@Test
	public void testCreateReturnOrder()
	{
		// Need sample input list
	}

	/**
	 * "ZHYBRIS_MAINTAIN_SALESORDER"
	 */
	@Test
	public void testMaintainSalesOrder()
	{
		
		final Map<String, Object> inputParameters = new HashMap<String, Object>();
		inputParameters.put(ORDER_NUMBER, "0624236172");
		inputParameters.put(SHIP_TO, "0000602387");
		inputParameters.put(REQ_DATE, "20200710");
		inputParameters.put(EMAIL, "angie.stevens.test@gmail.com");

		final Map<String, Object> orderItem;

		//order items table type input
		final List<Object> items = new ArrayList<Object>();

		orderItem = new HashMap<String, Object>();
		orderItem.put(MATERIAL, "10803");
		orderItem.put(QUANTITY, 3);
		orderItem.put(PO_NUMBER, "test2");

		items.add(orderItem);

        inputParameters.put(ORDER_ITEMS, items);

		final JsonObject result = cpMiddlewareOrderFacade.maintainSalesOrder(inputParameters);

		Assert.assertTrue(result.isJsonObject());

	}

	/**
	 * "ZHYBRIS_MERGE_SALESORDER"
	 */
	@Test
	public void mergeSalesOrder()
	{
		// Need sample input list
	}

}
