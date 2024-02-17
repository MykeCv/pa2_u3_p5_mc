package com.uce.edu.funcional;

import org.springframework.util.SystemPropertyUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println("SUPPLIER");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		System.out.println("Lambda");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1724362106";
			cedula = cedula + " canton";
			return cedula;	
		};
		System.out.println(supplierLambda.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "1724362106" + " pais";
		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = ()-> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1* Integer.valueOf(50)/Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		
		//Metodos referenciados 
		
		//2. Consumer 
		System.out.println("***********CONSUMER");
		//Clases
		System.out.println("Clase");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		//Lambda
		System.out.println("Lambda");
		IPersonaConsumer<String> consumerLambda = cadena-> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		
		//3. Predicate 
		System.out.println("********************PREDICATE");
		
		//Lambda
		System.out.println("Lambda");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda1 = letra -> "Michael".contains(letra);
		System.out.println(predicateLambda1.evaluar("o"));
	}
		
}
