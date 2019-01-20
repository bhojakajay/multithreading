package in.codefather.atomic;

public class AtomicLong {
	private long value;
	private long oldValue;

	public AtomicLong() {
		this.value = 0l;
	}

	public AtomicLong(final long value) {
		this.value = value;
	}

	public synchronized final long get() {
		return this.value;
	}

	public synchronized final void set(long value) {
		this.value = value;
	}

	public synchronized final long getAndSet(final long value) {
		this.oldValue = this.value;
		this.value = value;
		return this.oldValue;
	}

	public synchronized final boolean compareAndSet(final long compareToValue, final long valueToSet) {
		boolean isEqual = false;
		if(this.value==compareToValue) {
			this.value = valueToSet;
			isEqual = true;
		}
		return isEqual;
	}
	
	public synchronized final long incrementAndGet() {
		return ++this.value;
	}
	
	public synchronized final long getAndIncrement() {
		return this.value++;
	}
	
	public synchronized final long decrementAndGet() {
		return --this.value;
	}
	
	public synchronized final long getAndDecrement() {
		return this.value--;
	}
	
	public synchronized final long addAndGet(final long valueToAdd) {
		this.value += valueToAdd;
		return this.value;
	}
	
	public synchronized final long subtractAndGet(final long valueToSubtract) {
		this.value -= valueToSubtract;
		return this.value;
	}
}