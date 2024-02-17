package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	public T aplicar(T arg);

}
