package finalproject.entities.superclasses;

import javax.persistence.*;

/**
 * Questa classe è stata creata in sostituizione alla Entity
 * per utilizzare le funzionalità di Spring JPA
 * @author Paradox
 *
 */

/*
 * L'annotazione @MappedSuperclass specifica che le proprietà di questa classe<br>
 * (e.g. @Id) saranno ereditate dalle classi figlie
 */
@MappedSuperclass
public abstract class JPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;

	public JPAEntity(int id) {
		super();
		this.id = id;
	}
	public JPAEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
