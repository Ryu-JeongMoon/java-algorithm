# Selection Sort

~~~
in-place sorting 중 하나
입력 배열 외에 추가 메모리가 필요 없듬
메모리가 귀하던 시절에 필요했던 방법

오름차순 or 내림차순으로 위치를 결정해놓고 요소를 선택해서 알맞은 위치에 넣는 방법

장점
자료 이동 횟수가 미리 결정된다?
n개의 입력 중 마지막 요소는 자동 정렬될테니 n-1번의 이동이 있으면 된다

단점
안정성을 만족하지 않는다?
값이 같은 요소가 있다면 위치가 바뀔 수 있다

시간 복잡도
(n-1) + (n-2) + ... + 1 = n(n-1)/2 -> O(n^2)
~~~
