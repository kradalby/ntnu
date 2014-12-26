package oving9;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class HighscoreList extends ObservableList implements Iterable<Comparable> {

	private int maxSize;
	private List<Comparable> scores = new ArrayList<Comparable>();
	
	public HighscoreList(int max) {
		this.maxSize = max;
	}
	

	public void addResult(Comparable result) {
		if(!getList().isEmpty()) {
            for(Comparable next: scores) {
                    if(result.compareTo(next) < 0) {
                            if(this.getList().size() == this.maxSize) {
                                    this.getList().remove(this.getList().size()- 1);
                            }
                            this.addElement(this.getList().indexOf(next), result);
                            return;                        
                    }
            }
            if(this.getList().size() < this.maxSize) {
                    this.addElement(this.size(), result);                           
            }
		}
		else {
            this.addElement(0, result);
		}
	}

	@Override
	public void listChanged(ObservableList meh, int low, int high) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Comparable> iterator() {
		if (scores != null) {
			return scores.iterator();
		}
		return null;
	}

	@Override
	protected List getList() {
		return scores;
	}
	
}
