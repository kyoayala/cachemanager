package org.kyo.sawyer;

import java.util.HashMap;

import org.kyo.sawyer.exception.CacheManagerException;

public class CacheManager implements CacheManagerIf {

	private HashMap<String, String> map = new HashMap<>();
	
	@Override
	public void insert(String key, String value) throws CacheManagerException {
		if(key == null || "".equals(key)) throw new CacheManagerException("key should not be null");
		
		map.put(key, value);
	}

	@Override
	public String get(String key) {
		return map.get(key);
	}

	@Override
	public String remove(String key) {
		return map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

}
