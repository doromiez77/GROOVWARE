# 웹기반 그룹웨어 프로젝트 GROOVWARE



## 🖥️ 프로젝트 소개
쌍용강북교육센터 FinalProject 로서 진행한
<br>
사내 그룹웨어 서비스를 참고하여 만든 그룹웨어 페이지입니다.
<br>

## 🕰️ 개발 기간
* 2023.06.16 - 2023.07.12

### 🧑‍🤝‍🧑 맴버구성

#### 신원재

- 로그인, 회원가입, 일정관리 , 공용자료실 , 개인자료실 

#### 우정인

- 전자결제 - 문서 기안하기 , 결제 완료문서 항목별 목록 조회 , 문서 상세 조회 , 문서 처리 , 전자문서 css

#### 정유진

- 인사관리 - 인사등록하기 , 인사관리, 개인인사정보 조회,  근태관리, 휴가관리, 조직도 

#### 최지현

- 사내게시판, 사내동아리, 설문조사 

#### 윤현상

- 프로젝트 - 권한별 사원권한 수정계층적 목표 작성 및 조회, 목표 달성률 갱신, 업무요청 및 업무수행

#### 이태겸

- 공지사항 - 사내별 부서별 공지사항 조회/작성/수정/삭제/검색
- 주소록  - 사내별 부서별 주소록 CRUD 구현
- 채팅방 - 1:1 채팅 

<br>

### ⚙️ 개발 환경
- `Java 8`
- `JDK 1.8.0`
- **IDE** : STS 3.8
- **Database** : Oracle DB(11xe)
- **ORM** : Mybatis
- **JAVA - MVC MODEL2 Pattern**
- **JSP / AJAX / google / FullCalendar API, Library 사용**

## 📌 주요 기능
#### 로그인 
- DB값 검증 
- 로그인 시 쿠키(Cookie) 및 세션(Session) 생성

<img src="https://github.com/doromiez77/GROOVWARE/assets/127407763/c458a6c0-02a5-4cbd-9ea4-86da36e98cd5" alt="로그인" width="300">

  
#### 메인 페이지 
- 출근/퇴근 기능
- 내 휴가통계 , 전자결제 , 업무요청수신함, 사내공지사항, 부서별공지사항 확인기능
- 전자결제, 인사정보 , 프로젝트 , 일정관리, 그루비룸, 공지사항, 자료실 , 채팅방 
  
![메인대쉬보드](https://github.com/doromiez77/GROOVWARE/assets/127407763/36f0dcab-a4d5-4388-a674-c794c3aadf67)

#### 전자 결제

- 문서작성 - 기안서 작성
- 문서함 - 내문서, 부서문서, 임시보관 , 중요문서함
- 결제함 - 대기문서, 진행문서, 반려문서, 완료문서 확인

![결제_기안_내문서](https://github.com/doromiez77/GROOVWARE/assets/127407763/572c47be-dbbd-48d5-88dd-36320d33fd11)

![결제_문서](https://github.com/doromiez77/GROOVWARE/assets/127407763/f34b5e91-96fd-42c7-b289-3ba36c5d4660)

#### 인사정보 
- 인사등록, 인사관리
- 근태관리, 휴가관리, 조직도

  
#### 프로젝트
- 나의 프로젝트 새 프로젝트 생성, 계층적 계층적 목표 작성 및 조회, 삭제 (CRUD)
- 메뉴

  ![프로젝트-메인](https://github.com/doromiez77/GROOVWARE/assets/127407763/eef264a6-0e8c-4f25-af68-24915685b221)
  
  ![프로젝트_목표_상세](https://github.com/doromiez77/GROOVWARE/assets/127407763/251e7f4f-1ec5-4bda-b8bf-4755e4d984b3)

#### 일정관리
- 캘린더 FullCalendar API
- 자원예약

![프로젝트_캘린더](https://github.com/doromiez77/GROOVWARE/assets/127407763/726269a4-fdec-4eda-a012-c90f4add2b85)

![그루비룸_회의실예약](https://github.com/doromiez77/GROOVWARE/assets/127407763/3d903751-3c42-4200-9940-492dd2ac272b)

#### 그루비룸
- 커뮤니티 등록, 삭제 (CRUD)
- 설문조사
  
![커뮤니티_목록](https://github.com/doromiez77/GROOVWARE/assets/127407763/f78751b0-78a9-465c-b0cc-436de05f410e)

![커뮤니티_상세](https://github.com/doromiez77/GROOVWARE/assets/127407763/1d821b54-3379-4330-a511-bcd84dd71b83)

#### 공지사항
- 전체 공지사항 권한별 등록, 수정, 조회, 삭제 CRUD 
- 부서별 공지사항 권한별 등록, 수정, 조회 , 삭제CRUD
  
![공지사항](https://github.com/doromiez77/GROOVWARE/assets/127407763/0544cb23-e8bf-4ab7-870c-4aaa6371193d)

![공지사항_부서별](https://github.com/doromiez77/GROOVWARE/assets/127407763/f9092be6-b944-4963-99ab-e0b78062580c)

#### 자료실 
- 전사 자료실
- 개인 자료실
  
![자료실](https://github.com/doromiez77/GROOVWARE/assets/127407763/cca9a21e-0253-48dc-b44e-a78d09fa3792)

#### 메신저
- 주소록 - 전체 사원 주소록 목록 , 개인주소록으로 이동 , 삭제 기능
- 메신저 - 1:1 채팅, 전체 사원채팅
  
![공용주소록](https://github.com/doromiez77/GROOVWARE/assets/127407763/b14cc764-b590-4f17-8bb6-1adfd304b2f4)
![개인주소록](https://github.com/doromiez77/GROOVWARE/assets/127407763/1462af3d-b2b8-4716-ba3c-dc74dd3b5355)
![메신저](https://github.com/doromiez77/GROOVWARE/assets/127407763/53a59548-eb7e-46de-9014-403811a4d95e)



