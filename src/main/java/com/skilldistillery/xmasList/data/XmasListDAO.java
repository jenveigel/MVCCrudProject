package com.skilldistillery.xmasList.data;

import java.util.List;

public interface XmasListDAO {
	XmasList addXmasList(XmasList x);
	List<XmasList> getAllXmasLists();
	XmasList getXmasListById(int id);   
	XmasList updateXmasList(XmasList x);
	XmasList deleteXmasList(int id);
//	List<XmasList> returnList();
//	XmasList findXmasListById(int id);

}
