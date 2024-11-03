# java-lotto-precourse

## 로또 - 개요
- 구매 금액을 입력받아 로또 번호를 발행하는 프로그램 입니다.
- 로또 숫자의 범위는 1 ~ 45 까지 입니다.
- 로또 1장의 금액은 1000원입니다.
- 1회 최대 구매 금액은 10만원 입니다.
- 당첨번호는 직접 입력해야합니다.
- 수익률은 소수점 둘째 자리에서 반올림하여 소수점 이하 한자리까지만 표시됩니다.
- 당첨기준 금액
    ```
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
    ```

### 실행 결과 예시
    ```
    구입금액을 입력해 주세요.
    8000
    
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    
    보너스 번호를 입력해 주세요.
    7
    
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```

### 에러 코드
`[Fnnnn]` : 입력값의 형식 오류   
`[Rnnnn]` : 입력값의 제한 범위 초과 오류

### 실행 환경
- `JDK 21`
- `Application`의 `main()`에서 시작

### 라이브러리
- `camp.nextstep.edu.missionutils`

---

## 기능 목록
1. 로또 구입에 관한 기능
   - [x] 구입금액 입력 요청 문구 출력하기
   - [x] 구입금액 입력받기
   - [x] 입력받은 구입 금액 정수형으로 변환하기
   - [x] 구입금액에 따른 구입 개수 계산하기
   - [x] 로또 한 장 발행하기
     - [x] 오름차순 정렬하기
   - [x] 구입 개수만큼 반복하기
   - [x] 구입 결과 출력하기
2. 당첨번호에 관한 기능
   - [x] 당첨번호 입력 요청 문구 출력하기
   - [x] 당첨번호 입력 받기
   - [x] 콤마를 기준으로 당첨번호 구분하기
   - [x] 보너스 번호 입력 요청 문구 출력하기
   - [x] 보너스 번호 입력 받기
3. 당첨 통계에 관한 기능
   - [x] 당첨통계 문구 출력하기
   - [x] 로또별 당첨번호와 일치하는 개수 확인하기
   - [x] 보너스 번호와 일치하는지 확인하기
   - [x] 일치하는 개수에 따라 최종 등수 확인하기
   - [x] 등수별 당첨 로또 개수 확인하기
   - [x] 당첨 내역 출력하기
   - [x] 구입금액 대비 수익률 계산하기
   - [x] 수익률 출력하기

---

## 예외 처리
1. 구입 금액 예외 처리
   - [x] 구입금액에 숫자가 아닌 것이 입력되면 예외 발생
   - [] 음수가 입력되면 예외 발생
   - [] 1000의 배수가 아니면 예외 발생
   - [] 최소 구매금액은 천원, 최대 구매금액은 10만원
2. 로또 번호 예외 처리
   - [x] 로또 번호에 중복된 숫자가 있으면 예외 발생
   - [] 로또 번호에 1보다 작거나 45보다 큰 숫자가 있으면 예외 발생
   - [] 콤마와 숫자 이외에 다른 것이 있으면 예외 발생
3. 보너스 번호 예외 처리
   - [] 당첨번호와 중복되면 예외 발생
   - [] 숫자가 아니면 예외 발생
   - [] 1에서 45 사이가 아니면 예외 발생
