package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaFunction<T,R>{
	public T aplicar(R arg);

}
