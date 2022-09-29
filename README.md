## 2022-09-29일 수정사항
- template 폴더에 있던 .html 파일들 접두사에 맞게 정리
- 패키지를 db에 맞게 일부분 생성


## issue
- 폴더 변경으로 인해서 .html 파일들의 경로가 모두 달라져서 실행 후 연결이 안되어있음.
- 각자 맡은 부분별로 연결해서 실행하면 될듯
- .html파일이든 패키지든 만드는 사람 맘대로 수정가능








## 프로젝트 명
### 오늘 어때 (How About Today)

## 프로젝트 개요
### 

## 조 이름
### 불사조 (Phoenix)

## 개발 환경
### 1. Intelli J
### 2. Visual Studio Code
### 3. JAVA
### 4. SpringBoot
### 5. MySql

## 상세 개발환경
### 1. Intelli J
ver. 2022.2.1 , Build: 222.3739.54

### 2. Visual Studio Code 
ver. Lastest(v.1.71 or Higher)

### 3. JAVA
ver. 11

### 4. SpringBoot
- Project: Gradle
- Language: Java
- Version: 2.7.3
- Packaging: Jar
- Java: 11
### Dependencies
1. MySQL Driver SQL
2. Lombok DEVELOPER TOOLS
3. Thymeleaf TEMPLATE ENGINES
4. Spring Web WEB
5. Spring Security SECURITY
6. OAuth2 Client SECURITY
7. Spring Data JPA SQL
8. Spring Boot DevTools DEVELOPER TOOLS

5. MySql
ver. Lastest(Version: 8.0 or Higher)

## 설치 방법
### 0. MySql 설치
[설치](https://goddaehee.tistory.com/277) 참고
[설명](https://futurists.tistory.com/11) 참고

### 1. 인텔리제이 설치
[설치](https://www.jetbrains.com/ko-kr/idea/download/#section=windows)

### 2. 자바 11 설치
[설치](https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html)

### 3. 스프링부트 설치
깃허브 Clone

### 4. VScode 설치
[설치](https://code.visualstudio.com/)

## 실행방법
0. MySql 설치 후 데이터베이스 생성 -> 계정 생성 -> 권한주기
- 프로젝트 project_HowAboutToday\Others\DB 내의 how_about_today_table-MySql.sql 파일 상단 참고해서 생성
- DB명 how_about_today_db, 계정명 phoenix, 비밀번호 a123

1. 인텔리제이 실행 후 프로젝트 오픈
2. Gradle 로딩 후 빌드(실행)
- MySql 미설치나 계정DB 미생성이나 이름 다를 시 오류
- 자바 11버전 설정 안되어있으면 XXXX 11 오류

3. localhost:8087 접속
4. 정상 접속시 설치 완료.


## 코딩 컨벤션

1. 자료형은 전부 클래스로(ex int(X) -> Integer(O))
2. api 요청은 요청에 맞게
- 읽기 get, 생성(쓰기) post, 수정 put or patch, 삭제 delete
