# Stack

## 스택이란 무엇인가

스택은 접시다<br>
설거지하고 차곡차곡 쌓고 맨 위부터 사용한다<br>
따라서 데이터가 도착하는 순서가 중요하다<br>
<hr>

## 스택은 왜, 어떻게 사용하는가

멀티태스킹하는 경우 프로그램 잠깐 창 내리고 다른 프로그램 구동하는 경우를 생각해보자<br>
이전 프로그램을 날려버리는 것이 아니라 잠깐 다른 위치에 저장하고 다른 프로그램을 실행시킨 후 다시 꺼낸다<br>
이처럼 별도의 메모리 공간을 사용해 잠시 저장 후 다시 활용하기 위해 사용한다<br>
빈 스택에서 꺼낼 때는 underflow, 꽉 찬 스택에 넣을 때 overflow<br>
<hr>

## 스택의 구현

- 간단한 배열 기반
- 동적 배열 기반
- 연결 리스트 기반

<hr>

