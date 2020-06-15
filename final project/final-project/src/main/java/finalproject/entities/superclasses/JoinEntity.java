package finalproject.entities.superclasses;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import finalproject.entities.keys.CompositeKey;

@MappedSuperclass
public abstract class JoinEntity {

	@JsonIgnore
	@EmbeddedId
	private CompositeKey id;

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}

	public JoinEntity() {
		super();
	}

	public JoinEntity(CompositeKey id) {
		super();
		this.id = id;
	}
	
}
