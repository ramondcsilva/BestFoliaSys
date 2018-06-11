package br.uefs.ecomp.bfs.util;

public interface IList{
    public boolean contains(Object data);
    
    public boolean isEmpty();

    public int size();

    public void addStart(Object o);

    public void addLast(Object o);

    public Object toRemoveStart();

    public Object toRemoveLast();

    public Object get(int index);

    public Iterator iterator();
	
}
