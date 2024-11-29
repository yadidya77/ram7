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

import com.cp.facades.cart.middleware.CpMiddlewareCartFacade;
import com.google.gson.JsonObject;


public class CpMiddlewareCartFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	public static final String ERP_CUSTOMERID = "ERP_CUSTOMERID";
	public static final String ERP_CONTACTID = "ERP_CONTACTID";
	public static final String CRM_CONTACTID = "CRM_CONTACTID";
	public static final String SHIP_TO = "SHIP_TO";
	public static final String SALES_ORG = "SALES_ORG";
	public static final String PO_NUMBER = "PO_NUMBER";
	public static final String PROMO_CODE = "PROMO_CODE";
	public static final String SHIP_TYPE = "SHIP_TYPE";
	public static final String MATERIAL = "MATERIAL";
	public static final String QTY = "QTY";
	public static final String UOM = "UOM";
	public static final String REQ_DLVDATE = "REQ_DLVDATE";
	public static final String ITEM_LIST = "ITEM_LIST";

	@Resource
	private CpMiddlewareCartFacade cpMiddlewareCartFacade;

	/**
	 * "ZHYBRIS_GET_CART_PRICE_NEW"
	 */
	@Test
	public void testGetCartPrice()
	{
		final Map<String, Object> inputParameters = new HashMap<String, Object>();
		final Map<String, Object> cartItem;
    
		//cart items 
		final List<Object> items = new ArrayList<Object>();
    
		inputParameters.put(ERP_CUSTOMERID, "0000644053");
		inputParameters.put(CRM_CONTACTID, "");
		inputParameters.put(ERP_CONTACTID, "");
		inputParameters.put(SHIP_TO, "0000602387");
		inputParameters.put(SALES_ORG, "USHD");
		inputParameters.put(PO_NUMBER, "");
		inputParameters.put(PROMO_CODE, "");
		inputParameters.put(SHIP_TYPE, "GROUND");

		cartItem = new HashMap<String, Object>();
    
		cartItem.put(MATERIAL, "2534");
		cartItem.put(QTY, 3);
		cartItem.put(UOM, "BAG");
    
		items.add(cartItem);
    
		inputParameters.put(ITEM_LIST, items);

		final JsonObject result = cpMiddlewareCartFacade.getCartPrice(inputParameters);

		Assert.assertTrue(result.isJsonObject());

	}

	/**
	 * "ZHYBRIS_GET_CART_PRICE_ATP"
	 */
	@Test
	public void testGetCartPriceAtp()
	{
		final Map<String, Object> inputParameters = new HashMap<String, Object>();
		final Map<String, Object> cartItem;
    
		//cart items 
		final List<Object> items = new ArrayList<Object>();
    
		inputParameters.put(ERP_CUSTOMERID, "0000644053");
		inputParameters.put(CRM_CONTACTID, "");
		inputParameters.put(ERP_CONTACTID, "");
		inputParameters.put(SHIP_TO, "0000602387");
		inputParameters.put(SALES_ORG, "USHD");
		inputParameters.put(PO_NUMBER, "");
		inputParameters.put(PROMO_CODE, "");
		inputParameters.put(SHIP_TYPE, "GROUND");
		inputParameters.put(REQ_DLVDATE, "20200715");

		cartItem = new HashMap<String, Object>();
    
		cartItem.put(MATERIAL, "2534");
		cartItem.put(QTY, 3);
		cartItem.put(UOM, "BAG");
    
		items.add(cartItem);
    
		inputParameters.put(ITEM_LIST, items);

		final JsonObject result = cpMiddlewareCartFacade.getCartPriceAtp(inputParameters);

		Assert.assertTrue(result.isJsonObject());

	}

	/**
	 * "ZHYBRIS_OPENORDERS_NEW"
	 */
	@Test
	public void testListOpenOrders()
	{
		// Need sample input list
	}

}
