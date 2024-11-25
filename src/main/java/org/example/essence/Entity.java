package org.example.essence;

public class Entity <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> implements Comparable<Entity <T1, T2, T3>> {
	
	private T1 firstParam;
	private T2 secondParam;
	private T3 thirdParam;

	public Entity(T1 firstParam, T2 secondParam, T3 thirdParam) {
		this.firstParam = firstParam;
		this.secondParam = secondParam;
		this.thirdParam = thirdParam;
	}

	public T1 getFirstParam() {
		return firstParam;
	}

	public T2 getSecondParam() {
		return secondParam;
	}

	public T3 getThirdParam() {
		return thirdParam;
	}

	@Override
	public int compareTo(Entity<T1, T2, T3> o) {
		int firstParamComparison = this.firstParam.compareTo(o.firstParam);
		if (firstParamComparison != 0) {
			return firstParamComparison;
		}

		int secondParamComparison = this.secondParam.compareTo(o.secondParam);
		if (secondParamComparison != 0) {
			return secondParamComparison; 
		}

		return this.thirdParam.compareTo(o.thirdParam);
	}

	@Override
	public String toString() {
		return firstParam.toString() + secondParam.toString() + thirdParam.toString();
	}
}
