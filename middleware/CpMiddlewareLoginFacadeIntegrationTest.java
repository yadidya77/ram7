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

import com.cp.facades.login.middleware.CpMiddlewareLoginFacade;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;

/**
 * Integration test suite for RestBridge Middleware Facades}.
 */
@IntegrationTest
public class CpMiddlewareLoginFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	public static final String NAME = "NAME";
	public static final String VALUE = "VALUE";
	public static final String EMAIL = "EMAIL";
	public static final String ERPCUSTOMERID = "ERPCUSTOMERID";
	public static final String INPUT_LIST = "INPUT_LIST";

	@Resource
	private CpMiddlewareLoginFacade cpMiddlewareLoginFacade;

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
	public void testCustomerCheckNew()
	{

		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
				.put(EMAIL, "angie.stevens.test@gmail.com")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareLoginFacade.customerCheck(
				(Map)ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());
	}

	@Test
	public void testInitialDataLoadNew()
	{
		final Map<String, Object> inputParameters = new ImmutableMap.Builder<String, Object>()
				.put(EMAIL, "angie.stevens.test@gmail.com")
				.put(ERPCUSTOMERID, "0000644053")
				.build();

		final JsonObject result = cpMiddlewareLoginFacade.initialDataLoad(
				(Map)ImmutableMap.<String, List<Map<String, Object>>> of(INPUT_LIST, getInputParameterMap(inputParameters)));

		Assert.assertTrue(result.isJsonObject());

	}

}
