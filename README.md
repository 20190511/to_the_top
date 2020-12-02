# to_the_top
과탑을 향해서 오소기 프로젝트



## 현재까지 완성한 작업
### 스마트캠퍼스/유세인트 서버 크롤링(JSoup) (배준형,이정재)
#### [https://github.com/dlwjdwo00701/to_the_top/tree/master]
------------------------------------------
   * 7주차   : 스마트캠퍼스 강의 인덱스 번호와 강의 링크 크롤링.(시작)
   * 7주차2  : 0번 인덱스 제작, SmartCampus 객체화
   * 8~9주차 : 크롤링한 강의 목록을 다듬기 (시간,날짜,텍스트로 내용을 분할함)
   * 10주차  : 위의 정보들을 객체화하고 가독성을 위한 클래스 분할 (4개의 클래스로 분할함)
   * 11주차  : 현재 주차까지 듣지 못한 강의와 과제 가공 작업 -> SmartCampusTokenizer 클래스에 수록 + 현재시간을 알려주는 객체 생성
   * 12주차  : 유세인트 학사일정 크롤링 (시도->성공(2020.11.29))
   * 12주차2 : 남은 동영상들의 총 길이에 대한 클래스 제작
   * 12주차3 : 미제출/미수강 강의를 하루 전에 알려주는 클래스 (SmartCampusOption) 제작 (실질적 크롤링 작업 마무리)
   * 이후 주차부터는 디버그 위주로 작성합니다.
   * 13주차  : 11월에서 12월로 넘어가는 시간 계산 실수 디버깅을 수정 
   * 13주차2 : 11월에서 12월로 넘어가는 시간 계산 실수 (과제 부분) 디버깅을 수정
   * 14주차  : 0번 인덱스 제작으로 인한 15주차 인덱스 실수 수정 ( <15 으로 되어있는것을 -> <=15 or <16 으로 수정)
   * 14주차  : 15주차 크롤링 방식 수정 ("\tr") -> ("\tbody") 
   * 15주차  : KMOOC와 같은 비교과 과목 비인덱스화 (2번 커밋함)
   * 15주차2 : 과제 기한 없는것 ("-")로 표시되는 부분 
 ------------------------------------------
 
### 캘린더 UI,CSS개발작업(JavaFx+JSoup) (이정재, 장승헌, 이건욱)
#### [https://github.com/dlwjdwo00701/to_the_top/tree/ui_]
---------------------------------------------
   * 7~10주차 : 이번 프로젝트에 맞는 캘린더 UI제작.
   * 11주차   : 캘린더 버튼 꼬임에 대한 디버깅 완료
   * 12주차   : (긴급)자동 로그인에 대한 방안설정 -> 보안상 취약할 수 있으므로, 이용자에게 확인 후 비밀번호를 해시화하여 로그인 기능 구현
   * 12주차2  : 캘린더에 표시할 방법 논의        -> 강의인덱스(1~마지막 번호)를 보여준 후 강의 마감일(결석,지각)에 인덱스를 표기하는 방식
   * 13주차   : 캘린더에 현재주차까지 듣지않은 강의/과제 버튼 구현
   * 13주차2  : javafx,jsoup을 담은 .exe파일 추출
 ------------------------------------------
   
   
   
 
  ## 작업 브랜치 목록
     1. Main   : 프로젝트 입구 간판 (이름과 현재까지 완성된 세부내용만 기록)
     2. Master : 정보 크롤링 담당 브랜치(배준형,이정재)
     3. ui_    : 캘린더 UI,css및 크롤링 데이터를 실질적으로 다루는 브랜치 (이정재,김승헌,이건욱)
     4. read   : 조원 역할들이 수록되어있음.
