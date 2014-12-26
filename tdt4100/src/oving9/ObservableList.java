package oving9;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList implements ListListener{

	private ArrayList<ListListener> lists = new ArrayList<ListListener>();
	
	public void addListListener(ListListener meh) {
		if (meh != null && !lists.contains(meh)) {
			lists.add(meh);
		}
	}
	
	public void removeListListener(ListListener meh) {
		if (lists.contains(meh)) {
			lists.remove(meh);
		}
	}
	
	protected void fireListChanged(int low, int high) {
		for (ListListener i: lists) {
			i.listChanged(this, low, high);
		}
	}
	

	protected abstract List getList();

	public int size() {
		return this.getList().size();
	}
	
	protected void addElement(int index, Object element) {
		this.getList().add(index, element);
		this.fireListChanged(index, this.getList().size()-1);
	}
	
	protected void removeElement(int index) {
		this.getList().remove(index);
		this.fireListChanged(index, this.getList().size());
	}
	
}	