package com.skilldistillery.xmasList.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;



@Component
public class XmasListDAOInMemoryImpl implements XmasListDAO {

	Map<Integer, XmasList> xmasLists;
	List<XmasList> x = new ArrayList<>();
	
	public XmasListDAOInMemoryImpl() {
		xmasLists = new HashMap<>();
		loadSampleXmasLists();
	}

	private void loadSampleXmasLists() {
		xmasLists.put(1, new XmasList("Mom", "candle", 1, "it's cheap", 8.0));
		xmasLists.put(2, new XmasList("Dad", "tie", 2, "he's always at work", 17.0));
		xmasLists.put(3, new XmasList("Baby Sister", "nothing", 3, "she won't remember anyway", 0.0));
	}

	@Override
	public XmasList addXmasList(XmasList x) {
		return xmasLists.put(x.getId(), x);
	}

	@Override
	public List<XmasList> getAllXmasLists() {
		//trying to understand 
		//return new ArrayList<XmasList>(xmasLists.values());
		List<XmasList> xlist = new ArrayList<>();
		xlist = (List<XmasList>) xmasLists.values();
		return xlist;
	}

	@Override
	public XmasList getXmasListById(int id) {
		return xmasLists.get(id);
	}

	@Override
	public XmasList updateXmasList(XmasList x) {
		return xmasLists.put(x.getId(), x);
	}

	@Override
	public XmasList deleteXmasList(XmasList x) {
		return xmasLists.remove(x.getId());
	}
	
}

