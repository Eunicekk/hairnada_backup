# 헤어나다 (HairNada)
Spring Boot 기반 헤어 종합 서비스를 제공하는 팀 프로젝트
<br></br>

## 🖥️ 프로젝트 소개
- 헤어 스타일 및 케어를 위한 헤어 종합 서비스입니다.
<br></br>

## 🕰️ 개발 기간
- 2023년 06월 12일 - 2023년 07월 14일
<br></br>

## 🧑‍🤝‍🧑 맴버 구성
- 김윤 (팀장) : 메인, 헤어샵(CRUD), 케어샵(CRUD), 장바구니, 구매 완료, 결제, 통합 및 형상관리, 포트폴리오 및 발표자료 제작, 발표
- 이가은 (부팀장) : DB 설계, 관리자 페이지
- 송지호 (팀원) : 로그인, 회원가입, 계정찾기, 헤어 추천 테스트, 마이페이지
- 윤희석 (팀원) : 헤어스타일(CRUD), 제품(CRUD), 커뮤니티(CRUD)
<br></br>

## ⚒️ 사용 기술
- HTML
- CSS
- JavaScript
- JQuery
- Oracle
- JAVA
- Spring Boot
- ThymeLeaf
- MyBatis
- REST
- Kakao API
- Iamport
<br></br>

## 🖼️ 구현 화면
<details>
  <summary>
      <b>메인</b> : 클릭 시 화면 이미지를 볼 수 있습니다.
  </summary>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/f36e3629-f77b-4833-ba71-eea9ff0ca325"></img>
</details>
<details>
  <summary>
      <b>헤어샵</b> : 클릭 시 화면 이미지를 볼 수 있습니다.
  </summary>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/2eba12c6-60a8-49af-a395-1059183fa0ca"></img>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/e52f0cd6-89b3-488f-9362-8dac344f9fe5"></img>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/057f3f95-37ba-45df-af1e-c589f911012a"></img>
</details>
<details>
  <summary>
      <b>케어샵</b> : 클릭 시 화면 이미지를 볼 수 있습니다.
  </summary>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/cd85992c-5ff7-4a3a-a28d-a623fe5110ab"></img>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/e7dae611-2dab-4760-ac78-8f05991e3a71"></img>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/592f2964-fa8c-4186-bdcf-d89f7ec4c6a0"></img>
</details>
<details>
  <summary>
      <b>장바구니 및 구매완료</b> : 클릭 시 화면 이미지를 볼 수 있습니다.
  </summary>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/11061778-e939-494c-83b9-46469504a172"></img>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/3c01ce7b-f702-4bec-819f-59eab807ba31"></img>
</details>
<details>
  <summary>
      <b>결제</b> : 클릭 시 화면 이미지를 볼 수 있습니다.
  </summary>
  <img src="https://github.com/Eunicekk/hairnada_backup/assets/108565785/2c41eede-1a00-4d1f-9730-76d87f4430f4"></img>
</details>
<br>

## 📌 주요 기능
### 메인
- 자동 슬라이드 배너 및 게시물
- 카테고리별 게시물 랜덤 노출

### 헤어샵
- 게시물 등록, 읽기, 수정, 삭제 (CRUD)
- 이용자 등급이 '스타일 전문가' 일때 게시물 등록 가능
- 게시물 제목 및 주소로 검색 가능
- 게시물 좋아요 추가 및 삭제
- 게시물 페이징 처리
- Kakao Map API 활용

### 케어샵
- 게시물 등록, 읽기, 수정, 삭제 (CRUD)
- 이용자 등급이 '케어 전문가' 일때 게시물 등록 가능
- 게시물 제목 및 주소로 검색 가능
- 게시물 좋아요 추가 및 삭제
- 게시물 페이징 처리
- Kakao Map API 활용

### 장바구니 및 구매완료
- 장바구니 제품 선택 삭제 및 전체 삭제
- 장바구니 제품 수량 변경
- 장바구니에 담긴 지 30일이 지나면 해당 제품 자동 삭제
- 결제가 완료된 제품에 대한 정보 노출
- 결제 상태에 따른 필터

### 결제
- 결제하고 싶은 제품의 정보 및 가격 노출
- 주소 API 활용
- 결제 API (아임포트) 활용
