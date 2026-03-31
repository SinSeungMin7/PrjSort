package cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//카페 주문 정산 프로그램
/*
O1001,최지우,A,5,4500.0,Y
O1002,김서연,L,2,5200.0,N
O1003,박하준,D,3,10000.0,Y
O1004,박상준,T,3,6800.0,Y
O1005, 박준,D,4,3800.0,N
quit
*/

//주문금액 = 수량 * 단가
//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
//최종금액 = 주문금액 + 포장비
//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
//포장상태 = Y:포장, N:매장

//금액은 소수이하 두자리로 반올림
//모든 기능은 class에 구현한다.

interface Ipo {
	void input();
	void process();
	void output();
}

class CafeVo { // 데이터 그대로 처리하는것은 Dto
	//Field
//입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
	//      num, name, menuCode, qty, price, packed
	private String num;
	private String name;
	private char   menuCode;
	private int    qty; 
	private double price;
	private char   packed;
//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태
	//      num, name, menuName, ordKum, packMoney, kum, packedName
	private String menuName;
	private double ordKum; //주문금액 = 수량 * 단가
	private double packMoney; //포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
	private double kum;
	private String packedName;
	
	// 생성자 Constructor
	public CafeVo(String num, String name, char menuCode, int qty, double price, char packed) {
	
		this.num = num;
		this.name = name;
		this.menuCode = menuCode;
		this.qty = qty;
		this.price = price;
		this.packed = packed;
	}
	
	// Getter/Setter
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getMenuCode() {
		return menuCode;
	}
	
	public void setMenuCode(char menuCode) {
		this.menuCode = menuCode;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public char getPacked() {
		return packed;
	}
	
	public void setPacked(char packed) {
		this.packed = packed;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public double getOrdKum() {
		return ordKum;
	}
	
	public void setOrdKum(double ordKum) {
		this.ordKum = ordKum;
	}
	
	public double getPackMoney() {
		return packMoney;
	}
	
	public void setPackMoney(double packMoney) {
		this.packMoney = packMoney;
	}
	
	public double getKum() {
		return kum;
	}
	
	public void setKum(double kum) {
		this.kum = kum;
	}
	
	public String getPackedName() {
		return packedName;
	}
	
	public void setPackedName(String packedName) {
		this.packedName = packedName;
	}
	
	// toString
	@Override
	public String toString() {
		return "CafeVo [num=" + num + ", name=" + name + ", menuCode=" + menuCode + ", qty=" + qty + ", price=" + price
				+ ", packed=" + packed + ", menuName=" + menuName + ", ordKum=" + ordKum + ", packMoney=" + packMoney
				+ ", kum=" + kum + ", packedName=" + packedName + "]";
	}

} // class CafeVo end

class CafeOrder implements Ipo{ // add on implements 한다
	
	List<CafeVo> cafeList = new ArrayList<>(); // 배열 크기가 변하는
	

	@Override
	public void input() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("입력: 주문번호,고객명,메뉴코드,수량,단가,포장여부");
	//	for ( ; ; ) { // for 로 무한 루프
		int i = 0;
		while(true) { // while 무한루프
			String line = in.nextLine();
			if (line.equals("quit")) {
			System.out.println(  );
			break;
			}
			
			String [] li     = line.trim().split(","); // li 앞뒤 공백제거trim(), 콤마기준으로 자른다 split(",")
			String num       = li[0].trim();
			String name      = li[1].trim();
			char   menuCode  = li[2].toUpperCase().charAt(0); // char 한 단어만 때오기
			int    qty       = Integer.parseInt( li[3].trim() ); // 문자열을 정수로 변환 Integer.parseInt
			double price     = Double.parseDouble( li[4].trim() ); // 문자열을 double 로 변환 Double.parseDouble
			char   packed    = li[5].toUpperCase().charAt(0);
			
			CafeVo cafeVo = new CafeVo(num, name, menuCode, qty, price, packed);
			
			// 한번에 여러개 입력 받기 위해
			cafeList.add(cafeVo);
		//	System.out.println(cafeList.get(i));
			i++;
		}
		
	} // input end

	@Override
	public void process() {
		for (int i = 0; i < cafeList.size(); i++) {
			CafeVo vo = cafeList.get(i);
			//주문금액 = 수량 * 단가
			int qty = vo.getQty();
			double price = vo.getPrice();
			double ordKum =  qty * price;
			vo.setOrdKum(ordKum);
			
			//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
			// 포장여부는 arraylist 안에있기에 가져와야해서 getter 를 사용한다
			double packMoney = 0.0;
			if( vo.getPacked() == 'Y' ) // 가지고온 글자가 Y 이면
				packMoney = ordKum * 0.03;
			vo.setPackMoney( packMoney );
			
			//최종금액 = 주문금액 + 포장비
			double kum = ordKum + packMoney;
			vo.setKum( kum );
			
			//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
			Map< Character, String > map = new HashMap<>();
			map.put('A', "아메리카노");
			map.put('L', "라떼");
			map.put('T', "차");
			map.put('D', "디저트");
			char   menuCode = vo.getMenuCode();
			String menuName = map.get( menuCode );
			vo.setMenuName( menuName );
			
			/*
			switch (vo.getMenuCode()) { // get 으로 코드네임을 들고와야하기 때문
			case 'A' : vo.setMenuName("아메리카노"); break;// set 으로 입력을 받아야하기때문
			case 'L' : vo.setMenuName("라떼"); break;
			case 'T' : vo.setMenuName("차"); break;
			case 'D' : vo.setMenuName("디저트"); break;
			
			}
			*/
			
			//포장상태 = Y:포장, N:매장
			String packedName = (vo.getPacked() == 'Y') ? "포장": "매장";
			vo.setPackedName(packedName);
			/*
			if (vo.getPacked() == 'Y') // '' -> char , "" -> String
				vo.setPackedName("포장");
			else
				vo.setPackedName("매장");
			*/
		
			
				
		}
			//입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
			//      num, name, menuCode, qty, price, packed

	} // process end

	@Override
	public void output() {
		//금액은 소수이하 두자리로 반올림
		//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태
		//      num, name, menuName, ordKum, packMoney, kum, packedName
		//      %s   %s   %s        %.2f    %.2f       %.2f   %s
		String title = "주문번호 고객명 메뉴명 주문금액 포장비 최종금액 포장상태";
		System.out.println(title);
		
		String fmt = "%s   %s    %s   %.2f    %.2f       %.2f    %s";
		for (CafeVo cafeVo : cafeList) { // 교수님 방법 : for each 사용
			String num        = cafeVo.getNum(); // 이렇게 하는것이 오류도 보기 편하다
			String name       = cafeVo.getName();
			String menuName   = cafeVo.getMenuName();
			double ordKum     = cafeVo.getOrdKum();
			double packMoney  = cafeVo.getPackMoney();
			double kum        = cafeVo.getKum();
			String packedName = cafeVo.getPackedName();
			
			String msg = String.format(fmt,
					num, name, menuName, ordKum, packMoney, kum, packedName);
			System.out.println(msg);
		//	System.out.println(cafeVo);
		}
		/*
		String title = "주문번호,  고객명,   메뉴명,     주문금액,    포장비,      최종금액,    포장상태";
		System.out.println(title);
		
		String fmt   = "%s   %s    %s   %.2f    %.2f       %.2f    %s";
		for (int i = 0; i < cafeList.size(); i++) {
			CafeVo vo = cafeList.get(i);
			
			System.out.printf(fmt+"\n",
					vo.getNum(),
					vo.getName(),
					vo.getMenuName(),
					vo.getOrdKum(),
					vo.getPackMoney(),
					vo.getKum(),
					vo.getPackedName()
					);
		}
		*/ // 내가 한것
	}//output end
	
}

public class TestCafe {

	public static void main(String[] args) {
		// 출력할 모양 만들기
		CafeOrder cafeOrder = new CafeOrder();
		cafeOrder.input();
		cafeOrder.process();
		cafeOrder.output();
		 
		

	} // main end

} // TestCafe end
