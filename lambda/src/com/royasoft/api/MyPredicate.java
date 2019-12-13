package com.royasoft.api;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
