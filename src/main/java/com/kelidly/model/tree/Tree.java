package com.kelidly.model.tree;

import java.util.List;

public interface Tree<T>{
	public  boolean hasChild();
	public List<Tree> getChild();
	public Tree getParent();
	public T getModel();
	public void addChild(Tree t);
}
