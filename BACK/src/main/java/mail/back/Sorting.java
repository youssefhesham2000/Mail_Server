package mail.back;

import eg.edu.alexu.csd.datastructure.stack.Classes.Stack;
import mail.back.interfaces.ISort;

public class Sorting {
	public  void quickSort(DoubleLinkedList arr, ISort comp)
	{
		if (arr.size() != 0)
			_quickSort(arr, 0, arr.size()-1, comp);
	}
	
	public void _quickSort(DoubleLinkedList arr, int l, int h, ISort comp) {
		
		//Changed from StackDS because the jar we have imported it is called Stack
		Stack stack = new Stack();
		stack.push(l);
		stack.push(h);
		 
		while(!stack.isEmpty()){
			h = (int) stack.pop();
			l = (int) stack.pop();
			
			int p = partition(arr, l, h, comp); 
			if (p - 1 > l) { 
	            stack.push(l);
	            stack.push(p-1);
	        }
			
			if (p + 1 < h) { 
				stack.push(p + 1);
				stack.push(h);
	        }
		}
	}
	
	
	private int partition(DoubleLinkedList arr, int l, int h, ISort c) 
	{ 
		Object x = arr.get(h); 
		
		sortComparator comp = (sortComparator)c;
	    int i = (l - 1); 
	  
	    for (int j = l; j <= h - 1; j++) { 
	    	if (comp.mycompare(arr.get(j), x) <= 0) {
	    		i++;
	    		Object temp = arr.get(i);
	    		arr.set(i, arr.get(j));
	    		arr.set(j, temp);
	    	}
	    } 
	    
	    Object temp = arr.get(i+1);
	    arr.set(i+1, arr.get(h));
	    arr.set(h, temp);
	    return (i + 1); 
	} 
	
	
}

