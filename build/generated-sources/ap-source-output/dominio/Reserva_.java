package dominio;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, String> obs;
	public static volatile SingularAttribute<Reserva, String> cpf;
	public static volatile SingularAttribute<Reserva, String> nome;
	public static volatile SingularAttribute<Reserva, Integer> id;
	public static volatile SingularAttribute<Reserva, Integer> numPessoas;
	public static volatile SingularAttribute<Reserva, Timestamp> ts;

}

