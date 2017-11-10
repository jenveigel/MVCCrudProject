package com.skilldistillery.xmasList.data;

import java.util.List;

public interface XmasListDAO {
	XmasList addXmasList(XmasList x);
	List<XmasList> getAllXmasLists();
	XmasList getXmasListById(int id);   
			//or should this be "int id"
	XmasList updateXmasList(XmasList x);
	XmasList deleteXmasList(XmasList x);

}
