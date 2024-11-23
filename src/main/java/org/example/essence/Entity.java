package org.example.essence;

/**
 * <p>Заглушка общего класса</p>
 * <p>compareTo не наследовать с другим типом аргумента</p>
 */
public abstract class Entity implements Comparable<Entity> {
	
	private String str;

	@Override
	public int compareTo(Entity o) {
		return this.str.compareTo(o.str);
	}

	@Override
	public String toString() {
		return str;
	}
}
