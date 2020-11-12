package iterator;

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

		@Override
		public Object previous() {
			if(this.hasPrevious()){
				if(this.hasNext()){
				return fruits[index--];}
				else
					return fruits[--index];
			}
			return null;
		}

		@Override
		public boolean hasPrevious() {
			if(index>=0){
				return true;
			}
			return false;
		}

		public Object next() {
			if(this.hasNext()) {
				if(this.hasPrevious()){
				return fruits[index++];}
				else
					return fruits[++index];
			}
			return null;
		}
	}
	
}
