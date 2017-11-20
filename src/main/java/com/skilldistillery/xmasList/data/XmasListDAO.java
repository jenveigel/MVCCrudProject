package com.skilldistillery.xmasList.data;

import java.util.List;

public interface XmasListDAO {
	void addXmasList(XmasList x);
	List<XmasList> getAllXmasLists();
	XmasList getXmasListById(int id);   
	void updateXmasList(XmasList x);
	XmasList deleteXmasList(int id);
//	List<XmasList> returnList();
//	XmasList findXmasListById(int id);

}
