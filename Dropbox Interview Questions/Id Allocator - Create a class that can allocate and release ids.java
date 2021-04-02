// Brute Force
// Queue version with O(n) and O(1) allocate and release
public class Allocator{
	private Queue<Integer> freeList;
	private Set<Integer> allocated;
	private final int MAX_ID;
	public Allocator(int maxId) {
		this.MAX_ID  = maxId;
		this.freeList = new LinkedList<>();
		for(int i=0; i<maxId; i++) {
			freeList.offer(i);
		}
		this.allocated = new HashSet<>();
	}	
	public int allocate() {
		if(freeList.isEmpty()) 
			return -1;
		int id = freeList.poll();
		allocated.add(id);
		return id;
	}
	public void release(int id) {
		if(id<0 || id>=MAX_ID || !allocated.contains(id)) 
			return;
		allocated.remove(id);
		freeList.add(id);
	}
	public boolean check(int id) {
	// unnecessary check, the set contains can handle
	// if(id<0 || id>=MAX_ID) return false;
		return !allocated.contains(id);
	}


// Optimized Ver 1
// Much space efficient but worst case is O(n) in term of searching
public class Allocator{
	private final int MAX_ID;
	private BitSet bitSet;
	private int nextAvailable;
	public Allocator(int maxId) {
		this.MAX_ID = maxId;
		this.bitSet = new BitSet(maxId);
		this.nextAvailable = 0;
	}
	public int allocate() {
		if(nextAvailable==MAX_ID) return -1;
		int num = nextAvailable;
		bitSet.set(num);
		nextAvailable = bitSet.nextClearBit(num);
		return num;
	}
	public void release(int id) {
		if(id<0 || id>=MAX_ID) return;
		if(bitSet.get(id)) {
			bitSet.clear(id);
			nextAvailable = Math.min(nextAvailable, id);
		}
	}
	public boolean check(int id) {
		if(id<0 || id>=MAX_ID) return false;
		return !bitSet.get(id);
	}
}


// Optimized Ver 2
public class Allocator{
	private final int MAX_ID;
	private BitSet bitSet;
	public Allocator(int maxId) {
	this.MAX_ID = maxId;
	this.bitSet = new BitSet(maxId*2-1);
	}
	public int allocate() {
		int index=0;
		while(index<MAX_ID-1) {
		if(!bitSet.get(index*2+1)) {
			index = index*2+1;
		} else if(!bitSet.get(index*2+2)) {
			index = index*2+2;
		} else {
			return -1;
		}
	}
	bitSet.set(index);
	updateTree(index);
	return index-MAX_ID+1;
	}
	public void updateTree(int index) {
		while(index>0) {
			int parent = (index-1)/2;
			if(index%2==1) { //left child
				if(bitSet.get(index) && bitSet.get(index+1)) {
					bitSet.set(parent);
				} else {
				bitSet.clear(parent); //it is required for
				release id;
				} 
			} else {
				if(bitSet.get(index) && bitSet.get(index-1)) {
					bitSet.set(parent);
				} else {
					bitSet.clear(parent);
				}
			}
		index = parent;
		}
	}
	public void release(int id) {
		if(id<0 || id>=MAX_ID) return;
		if(bitSet.get(id+MAX_ID-1)) {
			bitSet.clear(id+MAX_ID-1);
			updateTree(id+MAX_ID-1);
		}
	}
	public boolean check(int id) {
		if(id<0 || id>=MAX_ID) return false;
		return !bitSet.get(id+MAX_ID-1);
	}
}