package org.kyo.sawyer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kyo.sawyer.exception.CacheManagerException;

public class CacheManagerTest {

	private CacheManager cacheManager;
	String keyToRemove = "toRemove";
	String keyToGet = "toGet";
	
	@Before
	public void setUp() throws Exception {
		
		cacheManager = new CacheManager();
		cacheManager.insert(keyToGet, keyToGet);
		cacheManager.insert(keyToRemove, keyToRemove);
	}

	@After
	public void tearDown() throws Exception {
		cacheManager = null;
	}

	@Test
	public void testInsert_pass() throws CacheManagerException {
		cacheManager.insert("Nuevo", "Value1");
		//fail("Not yet implemented");
	}
	
	@Test
	public void testInsert_failNull(){
		
		try {
			cacheManager.insert(null, "Value1");
			
			fail("Exception Not throwed!");
		} catch (CacheManagerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testInsert_failEmpty(){
		
		try {
			cacheManager.insert("", "Value1");
			
			fail("Exception Not throwed!");
		} catch (CacheManagerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGet() {
		String value = cacheManager.get(keyToGet);
		
		assertTrue(keyToGet.equals(value));
		
	}

	@Test
	public void testRemove() {
		String valueRemoved = cacheManager.remove(keyToRemove);
		assertTrue(keyToRemove.equals(valueRemoved));
		
		String nullSupposed = cacheManager.remove(keyToRemove);
		assertTrue(nullSupposed == null);
	}

	@Test
	public void testClear() {
		cacheManager.clear();
		
		String valueToGet = cacheManager.get(keyToGet);
		String valueToRemove = cacheManager.get(keyToRemove);
		
		assertTrue(valueToGet == null);
		assertTrue(valueToRemove == null);
	}


}
