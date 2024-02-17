package com.uce.edu.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<String>{

	@Override
	public void accept(String arg) {
		// TODO Auto-generated method stub
		System.out.println("Se inserta");
		System.out.println(arg);
		
	}

}
