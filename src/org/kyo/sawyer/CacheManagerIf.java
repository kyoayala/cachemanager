package org.kyo.sawyer;

import org.kyo.sawyer.exception.CacheManagerException;

public interface CacheManagerIf {

	void insert(String key, String value) throws CacheManagerException;
	String get(String key);
	String remove(String key);
	void clear();
	
}
