//package com.skilldistillery.xmasList.data;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class XmasListDAOInMemoryImpl implements XmasListDAO {
//
//	Map<Integer, XmasList> xmasLists;
//	
//	private int id = 1;
//	
//	public XmasListDAOInMemoryImpl() {
//		xmasLists = new HashMap<>();
//		loadSampleXmasLists();
//	}
//
//	private void loadSampleXmasLists() {
//		xmasLists.put(id, new XmasList(id++, "Mom", "candle", "it's cheap", 8.0));
//		xmasLists.put(id, new XmasList(id++, "Dad", "tie", "he's always at work", 17.0));
//		xmasLists.put(id, new XmasList(id++, "Baby Sister", "nothing", "she won't remember anyway", 0.0));
//	}
//
//	@Override
//	public XmasList getXmasListById(int id) {
//		return xmasLists.get(id);
//	}

//	@Override
//	public List<XmasList> getAllXmasLists() {
//		//trying to understand 
//		return new ArrayList<XmasList>(xmasLists.values());
//	}

////	@Override
////	public XmasList addXmasList(XmasList x) {
////		x.setId(id++);
////		return xmasLists.put(x.getId(), x);
////	}

//	@Override
//	public XmasList updateXmasList(XmasList x) {
//		return xmasLists.put(x.getId(), x);
//	}
//
////	@Override
////	public XmasList deleteXmasList(XmasList x) {
////		return xmasLists.remove(x.getId());
////	}
//
//	@Override
//	public void deleteXmasList(int id) {
//		// TODO Auto-generated method stub	
//	}
//	
//}
//
