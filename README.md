# Spring_LEVEL1
 -  CREATE => POST
 - READ => GET
 - SELECT READ =>GET
 - UPDATE => PUT
 - DELETE => DELETE
 - Misson Complete!!!

# 페어와 함께 답변을 작성해보세요
1.수정,삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
정답은 body 파라미터를 @RequestBody RequestDto requestDto로 받았음 

2.어떤 상황에 어떤 방식의 request를 써야하나요?
요청의 처리 방식은 주로 RESTful API 설계에 따라 결정됩니다.
HTTP 메소드에따른 관례
GET 데이터를 조회를할 때
POST 데이터를 생성할 때
PUT 데이터를 수정할 때
DELETE 데이터를 삭제할 때

3.RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
잘한부분
(1)HTTP 메서드 사용 GET POST PUT DELETE 사용
(2)URL구조 URL 패턴이 의미있고 일관성 있게 구성하였음

잘못한부분
실력이 모자라서 어떤 부분을 잘못한부분인지 찾지 못했습니다.

4.적절한 관심사 분리를 적용하였나요?(Controller, Repository, Service)

Controller : 컨트롤러 계층은 HTTP 요청을 받아들이고, 해당 요청을 처리하는 역할을 합니다.
클라이언트의 요청을 분석하고, 적절한 서비스 메소드를 호출하여 비즈니스 로직을 실행합니다.
요청과 응답에 관련한 처리를 담당합니다.

Service : 비즈니스 로직을 처리하는 부분입니다.
서비스 계층은 컨트롤러로부터 받은 요청을 처리하고, 필요한 데이터베이스 조작을 위해 리포지토리 계층을 사용할 수 있습니다.
데이터 조작, 비즈니스 규칙 및 로직 구현, 데이터 변환 등을 수행합니다.

Repository : 데이터베이스와 직접적인 상호작용을 담당하는 부분입니다.
데이터베이스에서 데이터를 조회, 저장, 업데이트, 삭제하는 역할을 수행합니다.
JPA와 같은 ORM을 사용한다면, 엔티티 클래스와 데이터베이스 사이의 매핑을 처리합니다.

5.API 명세서 작성 가이드란을 검색하여 직접 작성한 API 명세서와 비교해보세요!
PostMan을 사용하여 확인해본결과 입력값과 출력값이 일치하였습니다. 삐빅!!!
