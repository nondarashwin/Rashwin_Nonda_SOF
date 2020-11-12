package com.manipal.dp.behavioural.iterator;

public class FruitRepostiory implements Container {
	public String [] fruits = {"Banana","Orange","Mango","Watermelon"};
	@Override
	public Iterator getIterator() {
		return new FruitIterator();
	}

	private class FruitIterator implements Iterator{
		int index;
		
		public boolean hasNext() {
			if(index < fruits.length)
				return true;
			return false;
						
		}
		
		public Object next() {
			if(this.hasNext()) {
				return fruits[index++];
			}
			return null;
		}
	}
	
}
