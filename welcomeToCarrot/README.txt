	
	[ 김명지 ]
	
	1. 주제 :
		- 중고 직거래 ( like 당근마켓 .. )
	
	2. 구조 :
		- Controller
			- DealController.java
				- public void getAllDeals(){}
				- public void insertDeal(DealConfirmation newDeal){}
				- public boolean checkCanDeal() {}
				- public DealConfirmation findThingName(String thingName) {}
				- public boolean compareWishPrice(DealConfirmation deal, int wishBuyPrice) {}
				- public void updateDeal(DealConfirmation deal, Customer customer){}
				- public void deleteDeal(){}
				
		
		- Service
			- DealService.java (3번 참고)
		
		- DAO
			- DealDAO.java
				- private ArrayList<DealConfirmation> deals = new ArrayList<>();
				
				- public static DealDAO getInstance(){}
				- public ArrayList<DealConfirmation> getDealList(){}
				- public void insertDeal(DealConfirmation newDeal){}
				- public void updateDeal(DealConfirmation deal, People people){}
				- public void deleteDeal(DealConfirmation deal){}
				
		- DTO
			- DealConfirmation.java
				- idx			(거래 활동 고유 번호)
				- title			(거래 활동 제목 = 거래 물건과 같은 이름)
				- state 		(거래 완료, 거래 미완료)
		
			- People.java 			
				- id			(아이디)
				- residence		(거주지)
				
			- Seller.java
				- wishSellThing	(판매를 희망하는 물건)
				- wishSellPrice (판매를 희망하는 최소 가격)
				
			- Customer.java
				- wishBuything 	(구입을 희망하는 물건)
				- wishBuyPrice	(구입을 희망하는 최대 가격)
				
		- View
			- EndView.java
			- FailView.java
			- StartView.java
			
		
	3. 기능 :
		[Service]
		- select
			- public ArrayList<DealConfirmation> getAllDeals(){}
			- public DealConfirmation getDeal(String thingName){}
			
		- insert
			- public void insertDeal(DealConfirmation deal){}
		
		- update
			- public void updateDeal(DealConfirmation deal, Customer customer) {}
		- delete
			- public void deleteDeal() {}


	4. 실행 :
		[메인 메뉴 (4-1, 4-2, 4-3, 4-4, 4-5)]
		4-1. 전체 거래 목록 확인 (getAllDeals)
			ex. 
			[NO.1]
			[Title: 따끈따끈호빵, State: 거래 완료, 
				판매자 정보 : [아이디 : ddingji, 거주지 : 서울, 판매 희망 가격 : 5000원], 
				구매자 정보 : [아이디 : itsmine, 거주지 : 서울, 구입 희망 가격 : 6000원]]
			
			[NO.2]
			[Title: 얼죽아, State: 거래 미완료, 
				판매자 정보 : [아이디 : ddingji, 거주지 : 서울, 판매 희망 가격 : 5000원], 
				구매자 정보 : [아이디 : (미정), 거주지 : (미정), 구입 희망 가격 : --원]]
			
			or 
			
			현재 진행 중인 거래 목록이 없습니다.

		4-2. 판매할 물건 등록 (insertDeal)
			ex.
			판매자의 정보를 입력해주세요. (아이디, 거주지)
			 >> ddingji
			 >> 서울
			판매를 원하는 물품에 대한 정보를 입력해주세요. (물품 이름, 판매 희망 가격)
			 >> 따끈따끈호빵
			 >> 5000
			
		4-3. 거래 요청하기 (updateDeal)
			ex.
			본인의 정보를 입력해주세요. (아이디, 거주지)
			 >> itsmine
			 >> 서울
			
			구매를 원하는 물품 이름을 입력해주세요.
			 >> 추워추워호빵
			  Info : 해당 물품은 아직 올라오지 않았습니다.
			 >> 따끈따끈호빵
			
			구매를 원하는 가격을 입력해주세요.
			 >> 4000
			  Info : 4000원으로 구매할 수 있는 따끈따끈호빵은 없습니다.
			 >> 5000
			  Info : 거래가 완료되었습니다. 거래 목록을 확인해주세요.
		
			
		4-4. 거래 완료 목록 삭제 (deleteDeal) : state가 거래 완료인 목록들 전체 삭제
			ex.
			거래가 완료된 모든 목록을 삭제했습니다.
			
		4-5. 서비스 종료 (System.exit(0))



	5. 더 구현시키고 싶은 부분 (21.12.29 기준)
		5-1. 거래 요청
			- state가 "거래 완료"일 때는 소비자 정보 업데이트가 가능하지 않도록
			
		5-2. 추가 서비스
			- 글 내리기
			  > (1) '거래 미완료'인 목록 중에서 (2) '판매자'만 글 내릴 수 있음
			  > (3) 아이디, 물품이 기존에 업로드된 정보랑 일치하는지 체크
			  >> 코드가 굉장히 지저분해질 것 같은 느낌적인 느낌 ..
			  
		5-3. 4번 옵션 서비스에 대한 아쉬움
			- Delete를 구현하기 위해 추가했지만, 
			  사실상 소비자와 관리자 입장에서 모두 없어도 되는 서비스임
			  
		5-4. 깔끔한 예외처리 (해결!)
			- StartView.java 중 3번 옵션에 대한 부분에서 이중 try문이 적용되었음
			- 더 깔끔하게 쓸 수는 없을까?
	
		