/**
 * This class sorts the type within a heap sort style
 */
import java.util.ArrayList;

public class Heap <T extends Comparable<T>>
{

	/** private variable heap that creates a generic heap arraylist**/
	private ArrayList<T> heap;
	
	/** constructor class of heap and creates a new generic arraylist**/
	public Heap()
	{
		heap = new ArrayList<T>();
	}
	
	/** 
	 * function that returns the size of the heap
	 * @return heap.size() - an integer value of how many items are in the heap
	 */
	public int getSize()
	{
		return heap.size();
	}
	
	/**
	 * funnction that returns true or false if the heap is empty
	 * @return heap.isEmpty() - returns true or false depending if the heap is empty
	 */
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}
	
	/**
	 * function returns the node parent location 
	 * @param i 
	 * @return (i-1)/2 - the location of the node parent
	 */
	public int getPLoc(int i)
	{
		return (i-1)/2;
	}
	
	/**
	 * function returns the node left child location 
	 * @param i 
	 * @return 2*i+1 - the location of the left child node
	 */
	public int getLCLoc(int i)
	{
		return 2*i+1;
	}
	
	/**
	 * function returns the node right child location 
	 * @param i 
	 * @return 2*i+2 - the location of the right child node
	 */
	public int getRCLoc(int i)
	{
		return 2*i+2;
	}
	
	/**
	 * function returns what the value at the given node location 
	 * @param i - what node placement we want to get
	 * @return null - if item does not exist
	 * @return heap.get(i) - value of the node at the given i
	 */
	public T getNodeAt(int i)
	{
		if(heap.get(i) == null)
		{
			System.out.println("Item does not exist");
			return null;
		}
		
		else
		{
			return heap.get(i);
		}
	}
	
	/**
	 * function adds a new node to the heap sorts the newly added node into the tree
	 * @param n - generic object type n 
	 */
	public void addNode(T n)
	{
		heap.add(null);
		int index = heap.size() -1;
		while(index > 0 && getNodeAt(getPLoc(index)).compareTo(n) > 0)
		{
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		
		heap.set(index, n);
	}
	
	/**
	 * function removes the node on the top of the tree and tree will resort itself after the top of the tree has been removed
	 * @return min - sets the new value as the top of the heap
	 */
	public T removeMin()
	{
		T min = heap.get(0);
		int index = heap.size()-1;
		T last = heap.remove(index);
		
		if(index > 0)
		{
			heap.set(0, last);
			T root = heap.get(0);
			int end = heap.size()-1;
			index = 0;
			boolean done = false;
			
			while(!done)
			{
				if(getLCLoc(index)<= end)
				{
					T child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if(getRCLoc(index) <= end)
					{
						if(getNodeAt(getRCLoc(index)).compareTo(child) < 0)
						{
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					
					if(child.compareTo(root) < 0)
					{
						heap.set(index,  child);
						index = childLoc;
					}
					
					else
					{
						done = true;
					}
				}
				
				else
				{
					done = true;
				}
			}
			
			heap.set(index, root);
		}
		
		return min;
	}
	
	/**
	 * function goes through the heap tree and prints out the values in each node of the heap
	 */
	public void printHeap()
	{
		for(int i = 0; i<heap.size(); i++)
		{
			System.out.println(heap.get(i)+" ");
		}
		System.out.println();
	}
	
}
