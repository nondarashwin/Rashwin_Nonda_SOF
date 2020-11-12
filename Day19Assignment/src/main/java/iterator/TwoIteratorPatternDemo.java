package iterator;

public class TwoIteratorPatternDemo {

	public static void main(String[] args) {
		FruitRepostiory fruitRepository = new FruitRepostiory();
		
		Iterator iter = fruitRepository.getIterator();
		while(iter.hasNext()) {
			String fruit = (String) iter.next();
			System.out.println(fruit);
		}
		while (iter.hasPrevious()){
			String fruit=(String) iter.previous();
			System.out.println(fruit);
		}
	}

}
