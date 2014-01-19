package com.geitle.genyx.model;

public interface Repository<T> {
	T findById(int id);
}
