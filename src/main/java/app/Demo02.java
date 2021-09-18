package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// 1. especificar la conexi�n de BD - DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		// procesos...actualizar un usuario
		Usuario u = new Usuario();
		u.setCodigo(12);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("mika@gmail.com");
		u.setClave("titan");
		u.setFnacim("2010/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg, act, elim  -> Transacciones
		
		try {
			em.getTransaction().begin();
			em.merge(u);  // actualizar -> si existe c�d / si no existe lo crea
			em.getTransaction().commit();
			System.out.println("Actualizaci�n Ok");
		} catch (Exception e) {
			System.out.println("Error : " + e.getClass().getTypeName());
		}
		em.close();
		
	}
}
