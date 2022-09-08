# project_HowAboutToday

# 프로젝트 명
## 오늘 어때 (How About Today)

# 프로젝트 개요
## 

# 조 이름
## 불사조 (Phoenix)

# 개발 환경
## 1. Intelli J
## 2. Visual Studio Code
## 3. JAVA
## 4. NodeJS
## 5. SpringBoot
## 6. React
## 7. MySql

# 상세 개발환경
## 1. Intelli J
ver. 2022.2.1 , Build: 222.3739.54

## 2. Visual Studio Code 
ver. Lastest(v.1.71 or Higher)

## 3. JAVA
ver. 11

## 4. NodeJS
ver 16.xx

## 5. SpringBoot
- Project: Gradle
- Language: Java
- Version: 2.7.3
- Packaging: Jar
- Java: 11
##Dependencies
1. MySQL Driver SQL
2. Lombok DEVELOPER TOOLS
3. Thymeleaf TEMPLATE ENGINES
4. Spring Web WEB
5. Spring Security SECURITY
6. OAuth2 Client SECURITY
7. Spring Data JPA SQL
8. Spring Boot DevTools DEVELOPER TOOLS

## 6. React
ver. 18.2.0
### Dependencies
1. testing-library/jest-dom@5.16.5
2. @testing-library/react@13.4.0
3. @testing-library/user-event@13.5.0
4. http-proxy-middleware@2.0.6  <!-- 포트번호 proxy를 위한 미들웨어 -->
5. react-dom@18.2.0
6. react-scripts@5.0.1
7. react@18.2.0
8. web-vitals@2.1.4   <!-- 성능측정 프로그램 -->

7. MySql
ver. Lastest(Version: 8.0 or Higher)

# 설치 방법
## 0. MySql 설치
[설치](https://goddaehee.tistory.com/277) 참고
[설명](https://futurists.tistory.com/11) 참고

## 1. 인텔리제이 설치
[설치](https://www.jetbrains.com/ko-kr/idea/download/#section=windows)

## 2. 자바 11 설치
[설치](https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html)

## 3. 스프링부트 설치
깃허브 Clone

## 4. 노드 설치
[설치](https://nodejs.org/ko/)

## 5. VScode 설치
[설치](https://code.visualstudio.com/)

# 실행방법
0. MySql 설치 후 데이터베이스 생성 -> 계정 생성 -> 권한주기
- 프로젝트 project_HowAboutToday\Others\DB 내의 how_about_today_table-MySql.sql 파일 상단 참고해서 생성
- DB명 how_about_today_db, 계정명 phoenix, 비밀번호 a123

1. 인텔리제이 실행 후 프로젝트 오픈
2. Gradle 로딩 후 빌드(실행)
-  첫 실행시 리액트와 같이 빌드하기 때문에 오래걸림
- MySql 미설치나 계정DB 미생성이나 이름 다를 시 오류
- 자바 11버전 설정 안되어있으면 XXXX 11 오류

3. localhost:8087 접속
4. 정상 접속시 설치 완료.


# 코딩 컨벤션

1. 자료형은 전부 클래스로(ex int(X) -> Integer(O))
2. api 요청은 요청에 맞게
- 읽기 get, 생성(쓰기) post, 수정 put or patch, 삭제 delete
