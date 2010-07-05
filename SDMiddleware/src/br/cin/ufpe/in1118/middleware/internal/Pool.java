package br.cin.ufpe.in1118.middleware.internal;

import java.util.Hashtable;

import br.cin.ufpe.in1118.middleware.internal.exceptions.NoObjectFoundException;


public abstract class Pool <T> {

	private Hashtable<Object, T> pool;
	
	public Pool() {
		this.pool = new Hashtable<Object, T>();
	}
	
	public void putIntoPool(Object key, T t) {
		this.pool.put(key, t);
	}
	
	public T getFromPool(Object key) throws NoObjectFoundException{
		T t = this.pool.get(key);
		if (t == null) {
			throw new NoObjectFoundException(key.toString());
		}
		return t;
	}	
	
}
