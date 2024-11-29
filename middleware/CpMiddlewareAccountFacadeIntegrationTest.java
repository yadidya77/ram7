/*
 * HRO 2.0
 */
package com.cp.facades.middleware;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.cp.facades.myaccount.middleware.CpMiddlewareAccountFacade;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;


/**
 * Integration test suite for RestBridge Middleware Facades}.
 */
@IntegrationTest
public class CpMiddlewareAccountFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	public static final String NAME = "NAME";
	public static final String VALUE = "VALUE";
	public static final String EMAIL = "EMAIL";
	public static final String ERPCUSTOMERID = "ERPCUSTOMERID";
	public static final String CONTACTID = "CONTACTID";
	public static final String ORD_DATE_FROM = "ORD_DATE_FROM";
	public static final String ORD_DATE_TO = "ORD_DATE_TO";
	public static final String ORDERNUM = "ORDERNUM";
	public static final String INVOICE_NUM = "INVOICE_NUM";
	public static final String INV_DATE_FROM = "INV_DATE_FROM";
	public static final String INV_DATE_TO = "INV_DATE_TO";
	public static final String RECORD_FROM = "RECORD_FROM";
	public static final String RECORD_TO = "RECORD_TO";
	public static final String MAXROWS = "MAXROWS";
	public static final String SHIP_TO = "SHIP_TO";
	public static final String ORDERTYPE = "ORDERTYPE";
	public static final String INPUT_LIST = "INPUT_LIST";

	@Resource
	private CpMiddlewareAccountFacade cpMiddlewareAccountFacade;

	public static List<Map<String, Object>> getInputParameterMap(final Map<String, Object> inputParameters)
	{
		final List<Map<String, Object>> temp = new ArrayList<Map<String, Object>>();

		/* format with NAME and VALUE properties needed for SAP NAMEVALUE type */
		inputParameters.forEach((k, v) -> {
			temp.add(getInputParameter(k, v));
		});

		return ImmutableList.<Map<String, Object>> copyOf(temp);
	}

	public static Map<String, Object> getInputParameter(final String name, final Object value)
	{
		return ImmutableMap.<String, Object> of(NAME, name, VALUE, value);
	}

	@Test
	public void testUpdateContactNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
				.put(EMAIL, "angie.stevens.test@gmail.com")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareAccountFacade
				.updateContact(
				(Map) ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

	@Test
	public void testDeleteContactCoreNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
				.put(EMAIL, "angie.stevens.test@gmail.com")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareAccountFacade
				.deleteContactCore(
				(Map) ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

	@Test
	public void testGetOrderInvoiceHistoryNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
		        .put(ERPCUSTOMERID, "0000644053")
				.put(ORD_DATE_FROM, "20200601")
				.put(ORD_DATE_TO, "20200630")
				.put(INV_DATE_FROM, "20200601")
				.put(INV_DATE_TO, "20200630")
				.put(RECORD_FROM, "20200601")
				.put(RECORD_TO, "20200630")
				.put(MAXROWS, "10")
				.put(SHIP_TO, "0000644053")
				.put(ORDERTYPE, "NEW")
				.build();

		final JsonObject result = cpMiddlewareAccountFacade
				.getOrderInvoiceHistory(
				(Map) ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

	@Test
	public void testGetOrderHistoryDetailNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
		        .put(ORDERNUM, "123456")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareAccountFacade
				.getOrderHistoryDetail(
				(Map) ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

	@Test
	public void testGetInvoicePdfNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
		        .put(INVOICE_NUM, "123456")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareAccountFacade
				.getInvoicePdf(
				(Map) ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

}
