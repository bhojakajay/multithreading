package in.codefather.atomic;

public class AtomicInteger {
	private int value;
	private int oldValue;
	
	public AtomicInteger() {
		this.value = 0;
	}
	
	public AtomicInteger(int value) {
		this.value = value;
	}
	
	public final synchronized int get() {
		return this.value;
	}
	
	public final synchronized void set(int value) {
		this.value = value;
	}
	
	public final synchronized int getAndSet(int value) {
		this.oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	public final synchronized boolean compareAndSet(int compareToValue, int valueToSet) {
		boolean isEqual= false;
		if(this.value==compareToValue) {
			this.value = valueToSet;
			isEqual = true;
		}
		return isEqual;
	}
	
	public final synchronized int incrementAndGet() {
		return --this.value;
	}
	
	public final synchronized int getAndIncrement() {
		this.oldValue = value++;
		return oldValue;
	}
	
	public final synchronized int decrementAndGet() {
		return --this.value;
	}
	
	public final synchronized int getAndDecrement() {
		this.oldValue = this.value--;
		return value;
	}
	
	public final synchronized int addAndGet(int valueToAdd) {
		this.value += valueToAdd;
		return this.value;
	}
	
	public final synchronized int subtractAndGet(int valueToSubtract) {
		this.value -= valueToSubtract;
		return this.value;
	}
}