package org.zer0.pocs.rest.servicioExpuesto.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.zer0.pocs.rest.servicioExpuesto.dto.Contrato;
import org.zer0.pocs.rest.servicioExpuesto.dto.Empleado;
import org.zer0.pocs.rest.servicioExpuesto.dto.Proyecto;

public class DBDatos {

	private static List<Proyecto> lstProyectos=new ArrayList<>();
	private static List<Empleado> lstEmpleadosTotal=new ArrayList<>();
	
	static {
		Proyecto proyecto1=new Proyecto("Prima","Primasurac SAC");
		Proyecto proyecto2=new Proyecto("MEF","MEF GOB");
		
		Empleado empleado1=new Empleado("42584153","Alex","Salvatierra","Perez",30,"M",new Contrato(2500.0, "GMD", 6));
		Empleado empleado2=new Empleado("92517478","Jorge","Carrasco","Soto",25,"M",new Contrato(2000.0, "CANVIA", 3));
		Empleado empleado3=new Empleado("17151968","Alberto","Cerreno","Mamani",23,"M",new Contrato(3500.0, "Indra", 12));
		Empleado empleado4=new Empleado("44818518","Maria","Guerra","Portocarrero",29,"M",new Contrato(2500.0, "Everis", 6));
		Empleado empleado5=new Empleado("42481715","Javier","Diaz","Abanto",31,"M",new Contrato(2400.0, "Tata", 3));
		Empleado empleado6=new Empleado("35843618","Luis","Menacho","Casas",32,"M",new Contrato(1500.0, "GMD", 6));
		Empleado empleado7=new Empleado("30584841","Denis","Montes","Meza",25,"M",new Contrato(3000.0, "Everis", 12));
		Empleado empleado8=new Empleado("28181876","Carmen","Salazar","Moron",26,"M",new Contrato(3500.0, "IBM", 6));
		List<Empleado> lstEmpleados=new ArrayList<>();
		lstEmpleados.add(empleado1);
		lstEmpleados.add(empleado2);
		lstEmpleados.add(empleado3);
		lstEmpleados.add(empleado4);
		lstEmpleados.add(empleado5);
		lstEmpleados.add(empleado6);
		lstEmpleados.add(empleado7);
		lstEmpleados.add(empleado8);
		
		proyecto1.setLstEmpleados(lstEmpleados);
		lstProyectos.add(proyecto1);
		lstProyectos.add(proyecto2);
		lstEmpleadosTotal.addAll(lstEmpleados);
	}
	
	
	public static Stream<Proyecto> getProyecto(String nombreProyecto){
		return lstProyectos.stream()
						.filter((proyecto)->proyecto.getNombreProyecto().equals(nombreProyecto));
	}
	
	public static Stream<Empleado> getEmpleados() {
		return lstEmpleadosTotal.stream();
	}
	
	public static void saveEmpleado(Optional<Empleado> empleado) {
		empleado.ifPresent(lstEmpleadosTotal::add);
//		TODO
//		for (Proyecto proyecto: lstProyectos) {
//			
//		}
	}
}
