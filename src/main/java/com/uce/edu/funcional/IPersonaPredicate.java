package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	public boolean evaluar(T arg);
}
