package com.bf.container.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MapDemo03 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		exam(list);		
		

		Map<String,ClassRoom> rooms = new HashMap<String,ClassRoom>();
		count(rooms,list);

		printScore(rooms);
	}
	
	/**
	 *
	 */
	public static void printScore(Map<String,ClassRoom> rooms){
		Set<Map.Entry<String,ClassRoom>> entrySet =rooms.entrySet();
		Iterator<Map.Entry<String,ClassRoom>> it =entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String,ClassRoom> entry =it.next();
			ClassRoom room = entry.getValue();
			double avg = room.getTotal()/room.getStus().size();
			System.out.println("班级号:"+room.getNo()+",班级总分"+room.getTotal()+",编辑平均分"+avg);
		}		
	}
	
	
	/**
	 *
	 */
	public static void count(Map<String,ClassRoom> rooms,List<Student> list){
		for(Student stu:list){
			String no = stu.getNo();
			double score = stu.getScore();
			ClassRoom room = rooms.get(no);
			if(null==room){  //
				room = new ClassRoom(no);
				rooms.put(no, room);
			}			

			room.setTotal(room.getTotal()+score);
			room.getStus().add(stu);
		}
	}
	
	

	public static void exam(List<Student> list){
		list.add(new Student("a","001",80));
		list.add(new Student("b","001",80));
		list.add(new Student("a","002",80));
		list.add(new Student("c","003",80));
		list.add(new Student("d","003",80));
		list.add(new Student("e","004",80));
	}
}
