/*******************************************************************************
 * Copyright (c) 2014 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *      Dmitry Kornilov - initial implementation
 ******************************************************************************/
package org.eclipse.persistence.jpars.test.server.v2;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.jpa.rs.PersistenceContext;
import org.eclipse.persistence.jpa.rs.PersistenceFactoryBase;
import org.eclipse.persistence.jpars.test.model.basket.Basket;
import org.eclipse.persistence.jpars.test.model.basket.BasketItem;
import org.eclipse.persistence.jpars.test.util.ExamplePropertiesLoader;
import org.eclipse.persistence.jpars.test.util.RestUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * This class tests fields filtering feature introduced in V2.
 *
 * @author Dmitry Kornilov
 */
public class ServerFieldsFilteringTest {
    private static final Logger logger = Logger.getLogger("org.eclipse.persistence.jpars.test.server");
    private static final String JPARS_VERSION = "v2.0";
    private static final String DEFAULT_PU = "jpars_basket-static";

    private static PersistenceContext context;

    @BeforeClass
    public static void setup() throws Exception {
        final Map<String, Object> properties = new HashMap<String, Object>();
        ExamplePropertiesLoader.loadProperties(properties);
        properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, null);
        properties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
        properties.put(PersistenceUnitProperties.CLASSLOADER, new DynamicClassLoader(Thread.currentThread().getContextClassLoader()));
        final PersistenceFactoryBase factory = new PersistenceFactoryBase();
        context = factory.bootstrapPersistenceContext(DEFAULT_PU, Persistence.createEntityManagerFactory(DEFAULT_PU, properties), RestUtils.getServerURI(JPARS_VERSION), JPARS_VERSION, true);
        initData();
    }

    @AfterClass
    public static void cleanup() throws URISyntaxException {
        RestUtils.restUpdateQuery(context, "BasketItem.deleteAll", "BasketItem", null, null, MediaType.APPLICATION_JSON_TYPE);
        RestUtils.restUpdateQuery(context, "Basket.deleteAll", "Basket", null, null, MediaType.APPLICATION_JSON_TYPE);
    }

    private static void initData() throws Exception {
        // Create a basket
        Basket basket = new Basket();
        basket.setId(1);
        basket.setName("Basket1");
        basket = RestUtils.restCreate(context, basket, Basket.class.getSimpleName(), Basket.class, null, MediaType.APPLICATION_XML_TYPE, true);
        assertNotNull("Basket create failed.", basket);

        // Add items
        for (int j=1; j<=5; j++) {
            BasketItem basketItem = new BasketItem();
            basketItem.setId(j);
            basketItem.setName("BasketItem" + j);
            RestUtils.restUpdate(context, basketItem, BasketItem.class.getSimpleName(), BasketItem.class, null, MediaType.APPLICATION_XML_TYPE, false);
            RestUtils.restUpdateBidirectionalRelationship(context, String.valueOf(basket.getId()), Basket.class.getSimpleName(), "basketItems", basketItem, MediaType.APPLICATION_XML_TYPE, "basket", true);
        }
    }

    @Test
    public void testFieldsJson() throws URISyntaxException {
        // fields parameter
        final Map<String, String> hints = new HashMap<String, String>(1);
        hints.put("fields", "name,id");

        // Get BasketItem with id = 1
        String queryResult = RestUtils.restReadWithHints(context, 1, Basket.class.getSimpleName(), hints, MediaType.APPLICATION_JSON_TYPE);
        logger.info(queryResult);

        // Check that 'name' and 'id' fields are present in the response and other fields are not
        assertTrue(queryResult.contains("\"id\":1,\"name\":\"Basket1\""));
        assertFalse(queryResult.contains("\"basketItems\":[\n{"));
        assertTrue(checkLinkJson(queryResult, "self", "/entity/Basket/1?fields=name,id"));
        assertTrue(checkLinkJson(queryResult, "canonical", "/entity/Basket/1"));
    }

    @Test
    public void testFieldsXml() throws URISyntaxException {
        // fields parameter
        final Map<String, String> hints = new HashMap<String, String>(1);
        hints.put("fields", "name,id");

        // Get BasketItem with id = 1
        String queryResult = RestUtils.restReadWithHints(context, 1, Basket.class.getSimpleName(), hints, MediaType.APPLICATION_XML_TYPE);
        logger.info(queryResult);

        // Check that 'name' and 'id' fields are present in the response and other fields are not
        assertTrue(queryResult.contains("<id>1</id>"));
        assertTrue(queryResult.contains("<name>Basket1</name>"));
        assertFalse(queryResult.contains("<basketItems>"));
        assertFalse(queryResult.contains("</basketItems>"));
        assertTrue(checkLinkXml(queryResult, "self", "/entity/Basket/1?fields=name,id"));
        assertTrue(checkLinkXml(queryResult, "canonical", "/entity/Basket/1"));
    }

    @Test
    public void testExcludeFieldsJson() throws URISyntaxException {
        // excludeFields parameter
        final Map<String, String> hints = new HashMap<String, String>(1);
        hints.put("excludeFields", "basketItems,name");

        // Get BasketItem with id = 1
        String queryResult = RestUtils.restReadWithHints(context, 1, Basket.class.getSimpleName(), hints, MediaType.APPLICATION_JSON_TYPE);
        logger.info(queryResult);

        // Check that 'name' and 'id' fields are present in the response and other fields are not
        assertTrue(queryResult.contains("\"id\":1"));
        assertFalse(queryResult.contains("\"basketItems\":[\n{"));
        assertTrue(checkLinkJson(queryResult, "self", "/entity/Basket/1?excludeFields=basketItems,name"));
        assertTrue(checkLinkJson(queryResult, "canonical", "/entity/Basket/1"));
    }

    @Test
    public void testExcludeFieldsXml() throws URISyntaxException {
        // excludeFields parameter
        final Map<String, String> hints = new HashMap<String, String>(1);
        hints.put("excludeFields", "basketItems,name");

        // Get BasketItem with id = 1
        String queryResult = RestUtils.restReadWithHints(context, 1, Basket.class.getSimpleName(), hints, MediaType.APPLICATION_XML_TYPE);
        logger.info(queryResult);

        // Check that 'name' and 'id' fields are present in the response and other fields are not
        assertTrue(queryResult.contains("<id>1</id>"));
        assertFalse(queryResult.contains("<basketItems>"));
        assertFalse(queryResult.contains("</basketItems>"));
        assertTrue(checkLinkXml(queryResult, "self", "/entity/Basket/1?excludeFields=basketItems,name"));
        assertTrue(checkLinkXml(queryResult, "canonical", "/entity/Basket/1"));
    }

    @Test(expected = Exception.class)
    public void testBothParametersPresent() throws URISyntaxException {
        // excludeFields parameter
        final Map<String, String> hints = new HashMap<String, String>(1);
        hints.put("excludeFields", "basketItems,name");
        hints.put("fields", "name,id");

        // Get BasketItem with id = 1. Exception must be thrown because both 'fields' and 'excludeFields' parameters
        // cannot be present in the same request.
        RestUtils.restReadWithHints(context, 1, Basket.class.getSimpleName(), hints, MediaType.APPLICATION_XML_TYPE);
    }

    private boolean checkLinkXml(String response, String rel, String uri) throws URISyntaxException {
        final String link = "<links rel=\"" + rel + "\" href=\"" + RestUtils.getServerURI(context.getVersion()) + context.getName() + uri + "\"/>";
        return response.contains(link);
    }

    private boolean checkLinkJson(String response, String rel, String uri) throws URISyntaxException {
        final String link = "{\"rel\":\"" + rel + "\",\"href\":\"" + RestUtils.getServerURI(context.getVersion()) + context.getName() + uri + "\"}";
        return response.contains(link);
    }
}