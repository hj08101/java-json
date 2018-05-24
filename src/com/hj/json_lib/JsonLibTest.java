package com.hj.json_lib;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonLibTest {
	public static void main(String[] args) {
		
		toJson();
	}
	
	//解析Json
	public static void parseJson() {
		//对象
		System.out.println("\n--------- 对象 ---------");
		String personJsonStr = "{\"name\":\"张三\", \"age\":18}";
		JSONObject personObj = JSONObject.fromObject(personJsonStr);
		
		String name = personObj.getString("name");
		int age = personObj.getInt("age");
		System.out.println("姓名:" + name + ", 年龄:" + age);
		
		//数组
		System.out.println("\n--------- 数组 ---------");
		String arrJsonStr = "[\"苹果\", \"香蕉\", \"菠萝\"]";
		JSONArray jsonArr = JSONArray.fromObject(arrJsonStr);
		for (int i = 0; i < jsonArr.size(); i++) {
			String fruit = jsonArr.getString(i);
			System.out.println(fruit);
		}
		
		//集合存对象\n
		System.out.println("\n--------- 数组存对象---------");
		String stuArrJsonStr = "[{\"name\":\"小明\", \"age\":8}, {\"name\":\"小红\", \"age\":11}]";
		JSONArray stuJsonArr= JSONArray.fromObject(stuArrJsonStr);
		List<Student> stuList = JSONArray.toList(stuJsonArr, Student.class);
		for (Student student : stuList) {
			System.out.println(student);
		}
		
		//嵌套
		System.out.println("\n--------- 嵌套 ---------");
		String stuJsonStr = "{\"name\":\"小明\", \"age\":18, \"books\":[{\"bookName\":\"红楼梦\", \"price\":88}, {\"bookName\":\"红楼梦\", \"price\":88}]}";
		JSONObject stuJsonObj = JSONObject.fromObject(stuJsonStr);
		Student stu = (Student)JSONObject.toBean(stuJsonObj, Student.class);
		System.out.println(stu);
	}
	
	//转Json
	public static void toJson() {
		Student stu1 = new Student("小明", 18, new Book[2]);
		stu1.getBooks()[0] = new Book("红楼梦", 99);
		stu1.getBooks()[1] = new Book("三国演义", 89);
		
		Student stu2 = new Student("小红", 17, new Book[2]);
		stu2.getBooks()[0] = new Book("水浒传", 79);
		stu2.getBooks()[1] = new Book("西游记", 88);
		
		Student[] stuArr = new Student[] {stu1, stu2};
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Student s : stuArr) {
			sb.append("{");
			sb.append("\"name\":\"" + s.getName() + "\",");
			sb.append("\"age\":" + s.getAge() + ",");
			
			//-------书---------
			sb.append("\"books\":");
			sb.append("[");
			for (Book book : s.getBooks()) {
				sb.append("{");
				sb.append("\"bookName\":\"" + book.getBookName() + "\",");
				sb.append("\"price\":" + book.getPrice() + ",");
				sb.deleteCharAt(sb.length()-1);
				sb.append("},");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			//-----------
			
			//
			sb.append("},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		
//		System.out.println(sb);
		
		JSONArray jsonArray = JSONArray.fromObject(stuArr);
		String string = jsonArray.toString();
		System.out.println(string);
	}
}





