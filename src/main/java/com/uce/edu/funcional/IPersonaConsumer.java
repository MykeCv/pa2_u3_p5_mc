package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	public void accept(T arg);
}
