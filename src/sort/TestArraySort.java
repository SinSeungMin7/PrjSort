package sort;

import java.util.Arrays;
import java.util.Collections;

public class TestArraySort { // 배열 정렬

	public static void main(String[] args) {
		// 정렬 : Sort
		// int [] 은 람다식 사용불가
		int [] arr1 = new int[] {1, 5, 3, 2, 4};
		// 배열 출력
		System.out.println( Arrays.toString(arr1) );
		Arrays.sort(arr1);
		System.out.println( Arrays.toString(arr1) );
//		Arrays.sort(arr1, (a, b) -> { return b - a; } ); // Error
		// The method sort(int[]) in the type Arrays is not applicable for the arguments (int[], (<no type> a, <no type> b) -> {})
		// 메소드 sort 에 int 배열을 입력하면 적용할수없다 왜냐면 파라메타가 int 배열이라서
		System.out.println("===============");
		// --------------------------------------
		
		Integer [] arr2 = new Integer[] {1, 5, 3, 2, 4}; // int 를 Integer 로 바꿧을뿐 에러는 없다
		System.out.println( Arrays.toString(arr2) );
		Arrays.sort(arr2, (a, b) -> { return b - a; } ); // 내림차순 // int 는 안되지만 Integer 은 가능한 특이한 규칙이있다 Java 에서만
		System.out.println( Arrays.toString(arr2) );
		Arrays.sort(arr2, (a, b) -> { return a - b; } ); // 오름차순
		System.out.println( Arrays.toString(arr2) );
		System.out.println("========================");
		// --------------------------------------
		
		Double [] arr3 = {12.3, 3.8, 2.145, 16.8};
		System.out.println( Arrays.toString(arr3) );
		Arrays.sort(arr3); // 오름차순
		// Arrays.toString(arr3) : 주소를 출력하는것이 아니라 그안에 들어있는 실제 데이터를 꺼내 문자열로 만들어주는 도구
		System.out.println( Arrays.toString(arr3) );
		Arrays.sort( arr3, Collections.reverseOrder() ); // 내림차순
		System.out.println( Arrays.toString(arr3) ); 
		System.out.println("========================");
		// --------------------------------------
		
		String [] names = {"유진", "카리나", "윈터", "가을", "이서"};
		System.out.println( Arrays.toString(names) );
		Arrays.sort(names, (a, b) -> { return a.compareTo(b); } ); // 오름차순 // 람다식 : 함수의 줄임표현
        // 배열을 사용한다는 전제하에 
		// a - b 대신 a.compareTo(b) 쓰는이유 글자를 비교하기때문 // a-b는 숫자를 비교 
		System.out.println( Arrays.toString(names) );
		Arrays.sort(names, (a, b) -> { return b.compareTo(a); } ); // 내림차순
		System.out.println( Arrays.toString(names) );
		
	}

}
