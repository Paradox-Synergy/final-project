package finalproject.entities.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CompositeKey implements Serializable {

	@Column(name = "id1")
	private int id1;
	
	@Column(name = "id2")
	private int id2;

	public CompositeKey() {
		super();
	}

	public CompositeKey(int id1, int id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}
	
	public CompositeKey getCompositeId() {
		return new CompositeKey(id1, id2);
	}

	public boolean hasValidId() {
		return id1 != 0 && id2 != 0;
	}
	
	@Override
	public String toString() {
		return "[" + id1 + ", "+ id2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id1;
		result = prime * result + id2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		if (id1 != other.id1)
			return false;
		if (id2 != other.id2)
			return false;
		return true;
	}
	
}
