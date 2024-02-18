package com.uce.edu.funcional;

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

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		// Metodos referenciados

		// 2. Consumer
		System.out.println("***********CONSUMER");
		// Clases
		System.out.println("Clase");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		// Lambda
		System.out.println("Lambda");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");

		// 3. Predicate
		System.out.println("********************PREDICATE");

		// Lambda
		System.out.println("Lambda");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda1 = letra -> "Michael".contains(letra);
		System.out.println(predicateLambda1.evaluar("o"));

		// 4. FUNCTION
		System.out.println("**********************************FUNCTION");

		// Lambdas
		System.out.println("Impl Lambdas");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numString = numero.toString().concat("-Valor");
			return numString;
		};
		System.out.println(functionLambda.aplicar(7));
		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciu = new Ciudadano();
		ciu.setApellido("Cevallos");
		ciu.setNombre("Michael");
		ciu.setProvincia("Pichincha");
		System.out.println(functionLambda1.aplicar(ciu));

		// Metodos Referenciados
		System.out.println("Impl Metodo Referenciado");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
		Empleado e = new Empleado();
		e.setNombreCompleto("Juan Perez");
		e.setPais("Ecuador");
		System.out.println(function2.aplicar(e));

		// 4. UNARY OPERATOR
		System.out.println("**********************************UNARY OPERATOR");

		// Lambdas
		System.out.println("Impl Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunctionLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorFunctionLambda.aplicar(14));

		// Metodos Referenciados
		System.out.println("Impl Metodo Referenciado");
		IPersonaUnaryOperatorFunction<Empleado> unaryOperator1 = met::procesar;
		Empleado empl3 = unaryOperator1.aplicar(e);
		System.out.println(empl3);

	}

}
