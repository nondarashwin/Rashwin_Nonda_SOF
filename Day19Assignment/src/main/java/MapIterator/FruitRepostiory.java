/*package MapIterator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitRepostiory implements Container {
	public Map<Integer,String> fruits =new Map<Integer, String>() {
		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean containsKey(Object o) {
			return false;
		}

		@Override
		public boolean containsValue(Object o) {
			return false;
		}

		@Override
		public String get(Object o) {
			return null;
		}

		@Override
		public String put(Integer integer, String s) {
			return null;
		}

		@Override
		public String remove(Object o) {
			return null;
		}

		@Override
		public void putAll(Map<? extends Integer, ? extends String> map) {

		}

		@Override
		public void clear() {

		}

		@Override
		public Set<Integer> keySet() {
			return null;
		}

		@Override
		public Collection<String> values() {
			return null;
		}

		@Override
		public Set<Entry<Integer, String>> entrySet() {
			return null;
		}
	}
	@Override
	public Iterator getIterator() {
		return new FruitIterator();
	}

	private class FruitIterator implements Iterator {
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

}*/
