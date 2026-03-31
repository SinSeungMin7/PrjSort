package testscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {  // Private 쓸때는 Field(변수들 정보), Constructor(생성자), Getter/Setter/ ToString 넣어준다
	// Field 변수들 정보
	private int num;
	private int score;
	private int rank;
	
	// Constructor 생성자
	public Student(int num, int score) { // 생성자는 굳이 모든 parameta가 필요하지않는다
		this.num = num;
		this.score = score;
	}
	
	// Getter/Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}
	
}

public class TestRank {

	public static void main(String[] args) {
		List<Student> sList = new ArrayList<>();
		sList.add( new Student( 1, 100 ));
		sList.add( new Student( 3, 76 ) );
		sList.add( new Student( 5, 63 ) );
		sList.add( new Student( 4, 88 ) );
		sList.add( new Student( 9, 88 ) );
		sList.add( new Student( 2, 25 ) );
		sList.add( new Student( 7, 75 ) );
		sList.add( new Student( 8, 0 )  );
		sList.add( new Student( 6, 100 ));
		
		dispList(sList); // dispList 로 출력
		
		// 석차 구하기
		// 1. 점수를 기준삼아 내림차순으로 
		Collections.sort( sList,(a,b) -> { return b.getScore() - a.getScore(); } ); // 람다식
		dispList(sList);
		
		// 2. 석차부여  for 문도 가능
		// getter 변수 값 가져오는것 
		// setter 변수 값 저장하는것
		sList.get(0).setRank(1); // 첫번째 줄 1등
		int rnk = 0;
		for (int i = 1; i < sList.size(); i++) {
			if( sList.get(i).getScore() == sList.get(i-1).getScore() )
				rnk = sList.get(i-1).getRank();
			else
				rnk = i + 1;
			sList.get(i).setRank(rnk);
			/*
			sList.get(i).setRank(i + 1);
			 */
		}
		dispList(sList);
		
	}
	// 출력
	private static void dispList(List<Student> sList) {
		System.out.println("-------------------------------------");
		for (Student student : sList) {
			System.out.println(student);
		}
		System.out.println("-------------------------------------");
	} 

}
