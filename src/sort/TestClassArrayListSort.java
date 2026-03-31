package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member { // 클래스가 패키지에서 겹치면 에러가 뜬다
	private int mno;

 public Member(int mno) {
	this.mno = mno;
}
 
 @Override
 public String toString() {
 	return "Member [mno=" + mno + "]";
}

 public int getMno() {
	return mno;
 }
	
}

public class TestClassArrayListSort {

	public static void main(String[] args) {
		
		// ArrayList 는 생성자를 통해 초기값을 설정할수있다. : java 8 이하
		/*
		ArrayList<Member> mList = new ArrayList<>(// 생성과 동시에 초기화
				Arrays.asList(
						new Member(15), new Member(3), new Member(15), 
						new Member(1), new Member(5), new Member(7) 
						)
				
		);
		*/// ArrayList 는 생성자를 통해 초기값을 설정할수있다. : java 9 이상
		List<Member> mList = new ArrayList<>(// 생성과 동시에 초기화
				List.of(
						new Member(15), new Member(3), new Member(15), 
						new Member(1), new Member(5), new Member(7) 
						)
				
		);
		
		dispList( mList );
		
		// 오름차순 정렬
		Comparator<Member> compAsc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}
		};
		Collections.sort( mList, compAsc );
		dispList( mList );
		
		
		//익명클래스 내림차순
		Comparator<Member> compDesc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}
		};
		
		Collections.sort( mList, compDesc );
		dispList( mList );
		
		// 내림차순 정렬
		/*
		Collections.sort( mList, new Comparator<Member>( ) {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}}
		
		);
		*/
		// 내림차순
		// 람다식
		Collections.sort(mList, (a,b) -> {return b.getMno() - a.getMno(); } );
		
		dispList( mList );
		
		
		
		  
	}

	private static void dispList(List<Member> mList) {
		for (Member member : mList) {
			System.out.print(member + " ");
		}		
		System.out.println();
	}

}
