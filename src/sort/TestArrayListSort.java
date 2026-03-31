package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TestArrayListSort {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(); // 빨간줄일땐 ctrl + shift + O : Import해줘야한다
		list.add(10);
		list.add(5);
		list.add(34);
		list.add(28);
		list.add(16);
		
		// 익명클래스를 사용하여 코딩을 부여하면 Interface 도 new 가능
		// 모든 인터페이스의 코딩은 끝에 중괄호 {} 를 써야한다
		
		// 오름차순
		Comparator<Integer> compAsc = new Comparator<Integer>() {
                          // compare Ascending
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2; // Ascending
			}
			
		};
		
		// 내림차순
		Comparator<Integer> compDsc = new Comparator<Integer>() {
            // compare Descending
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // Descending
			}

};
		
		line();
		disp_list(list);
		
		// 오름차순 정렬
		Collections.sort(list, compAsc); // 오름차순 
		disp_list(list);
		
		// 내림차순 정렬
		Collections.sort(list, compDsc); // 내림차순 
		disp_list(list);
		line(); // 라인 함수
//---------------------------------------------------------------------
		// 문자열 배열
		ArrayList<String> names = new ArrayList<>();
		names.add("이순신");
		names.add("김유신");
		names.add("강감찬");
		names.add("을지문덕");
		names.add("권율");
		
		disp_name(names);
		
		// 오름차순 Ascending Sort
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);  // 문자를 비교하기떄문에 compareTo 를 사용
			}
		});
		disp_name(names);
		
		// 내림차순 Descending Sort 
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		disp_name(names);
		
	}

	private static void disp_name(ArrayList<String> names) {
		for (String name : names) {
			System.out.print(name + ",");
		}
		System.out.println();
	}
	

	private static void line() { // 라인 함수
		System.out.println("==============");
		
	}

	private static void disp_list(ArrayList<Integer> list) {
		
		for (Integer num : list) {
			System.out.print( num + "," );
		}
		System.out.println();
		
	}

}
