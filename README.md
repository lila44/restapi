개발프레임워크 릴리즈노트
  - 2017.02.13
      * 서버별 빌드 추가
      * yaml 추가

  - 2017.02.04
      * 예외 처리 공통 정보 패키지 수정(exception : exception.common)
      * NoDataException 추가(해당 정보가 없습니다.)
      * BizException : SystemException 명칭 변경

  - 2017.01.31
      * JPA 기반 CRUD 소스 자동 생성기 추가

  - 2017.01.23
      * 쿼리 빌더(queryDSL) 개발 샘플 추가
      * 쿼리 빌더(queryDSL) 개발 샘플 테스트 케이스 추가
      * 개발 패키지 수정
      * ModelMapper(org.modelmapper) 유틸 추가

  - 2017.01.19
      * JPA SQL 로그를 상세 하게 보기 위한 LOG4JDBC 추가
      * 공통적 사용자 요청 정보 파라미터 초기화 공통화(AOP) 추가
      * 사용자 응답 정보 반환 공통화(AOP) 추가(Controller 리턴 시 ResponseEntity 를 감싸서 반환)
      * 다국어 메세지 설정 및 메세지 헬퍼 추가

  - 2017.01.16
      * REST API 문서 자동화(Swagger) 추가
      * 사용자 요청 정보 유효성 검증 공통화(AOP) 추가
      * 비지니스 로직 예외 처리 공통화(AOP)  추가

  - 2017.01.12
      * 중복 코드 방지를 위한 LOMBOK 추가
      * 단위 테스트 시 테스트 후 데이터 롤백 추가

  - 2017.01.10
      * application log 추가

  - 2017.01.09
      * Rest Api Test Case 추가
      * Transaction Test Case 추가


이하 환경 구성
  - Spring Tool Suite : 3.8.3.RELEASE
  - Spring Boot : 1.4.3.RELEASE
  - Buildship Gradle : 1.0
  - JDK : 1.8.0_40
  - APACHE TOMCAT : 8.5.6
  - H2 : 1.4.193
  - SPRING FRAMEWORK : 4.3.5.RELEASE
  - SPRING DATA JPA : 5.0.11.Fanal
  - JUNIT : 4.12
  - MOCKITO : 1.10.19
  - FREEMARKER : 2.3.25
  - SWAGGER2 : 2.6.1
  - SWAGGER2-UI : 2.6.1
  - LOMBOK : 1.16.12
  - LOG4JDBC : 2.6.1
  - QUERYDSL : 4.1.4
  - JSON-SIMPLE : 1.1.1
  - COMMONS-LANG : 3.5
  - MODELMAPPER-SPRING : 0.7.7
