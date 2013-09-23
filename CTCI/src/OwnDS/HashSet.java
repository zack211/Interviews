package OwnDS;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSet extends AbstractSet{
	private Node[] buckets;
	private int size;
	static final int DEFAULT_SIZE = 31;
	public HashSet(){
		buckets = new Node[DEFAULT_SIZE];
		size =0;
	}
	public HashSet(int bucketsLength){
		buckets = new Node[bucketsLength];
		size =0;
	}
	public boolean contains(Object x){
		int h = x.hashCode();
		if(h < 0) h = -h;
		h = h% buckets.length;
		Node current = buckets[h];
		while(current!=null){
			if(current.data.equals(x))
				return true;
			current= current.next;
		}
		return false;
	}
	public boolean add(Object x){
		int h = x.hashCode();
		if(h < 0) h = -h;
		h = h% buckets.length;
		Node current = buckets[h];
		while(current!=null){
			if(current.data.equals(x))
				return false;
			current = current.next;
		}
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = buckets[h];
		buckets[h] = newNode;
		size++;
		return true;
	}
	public boolean remove(Object x){
		int h = Math.abs(x.hashCode())% buckets.length;
		Node current = buckets[h];
		Node previous = null;
		while(current!=null){
			if(current.data.equals(x)){
				if(previous==null){
					buckets[h] = current.next;
				}else
					previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	public Iterator iterator(){
		return new HashSetIterator();
	}
	public int size(){
		return size;
	}
	
	class Node{
		public Object data;
		public Node next;
	}
	class HashSetIterator implements Iterator{
		private int bucket;
		private Node current;
		private int previousBucket;
		private Node previous;
		public HashSetIterator(){
			current = null;
			bucket = -1;
			previous = null;
			previousBucket = -1;
		}
		public boolean hasNext(){
			if(current!=null && current.next!=null)
				return true;
			for(int b = bucket+1; b< buckets.length; b++)
				if(buckets[b]!=null)
					return true;
			return false;
		}
		public Object next(){
			previous = current;
			previousBucket = bucket;
			if(current == null || current.next == null){
				bucket++;
				while(bucket< buckets.length && buckets[bucket] == null)
					bucket++;
				if(bucket< buckets.length)
					current = buckets[bucket];
				else
					throw new NoSuchElementException();
			}else
				current = current.next;
			return current.data;
		}
		public void remove(){
			if(previous!=null && previous.next == current)
				previous.next = current.next;
			else if(previousBucket < bucket)
				buckets[bucket]= current.next;
			else
				throw new IllegalStateException();
			current = previous;
			bucket = previousBucket;
		}
	}
}