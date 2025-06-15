# kotlin-study

---

# 코틀린에서 변수와 타입, 연산자를 다루는 법

## 코틀린에서 변수를 다루는 방법

### 변수 선언 키워드 : var 과 val 의 차이점

- Java 에서 long 과 final long 의 차이 : 이 변수는 가변인가, 불변인가(read-only)
    - var : 수정가능, 가변
    - val : 수정불가, 불변
- 코틀린에서는 변수 선언부터 이 변수가 가변인지 불변인지 알 수 있다.
- 코틀린은 타입을 의무적으로 작성하지 않아도 된다.
- 초기값을 지정해주지 않으면 compile error 가 발생한다.
- val 컬렉션에는 element 를 추가할 수 있다.
    - 컬렉션 안의 데이터 자체는 바꾸지는 못하지만 요소는 추가할 수 있다.
- 모든 변수는 우선 val 로 만들고 꼭 필요한 경우 var 로 변경한다.

### Kotlin 에서의 Primitive Type

- primitive type (원시타입) 은 가장 기본적인 데이터 타입을 의미하며, 값 자체만 저장하는 타입이다.
    - Int, Long, Short, Byte, Float, Double, Char, Boolean
    - 소스 상에서는 객체로 보이지만, JVM 위에서 실행될 때에는 int, double 과 같은 java 의 primitive type 으로 변경된다.
- java 에서는 Long, Double 과 같은 referenceType 으로 boxing, unBoxing 이 불필요하게 일어나기 때문에 계산을 할 때에는 사용하지 않는 것이 좋다.
    - boxing : primitive → reference 타입으로 변환
    - unboxing : reference → primitive 타입으로 변환

```java
Long sum = 0L;
for (long i = 0; i < 1_000_000; i++) {
    sum += i;  // 매번 boxing/unboxing
}
```

- 그러나 코틀린에서는 primitive type 과 reference type 에 대한 구분이 필요 없다.
    - 코드 상에서는 객체로 표현되지만 실제 JVM 에서는 primitive type 으로 변경된다.

### Kotlin 에서의 nullable 변수

- kotlin 에서 null 이 변수에 들어갈 수 있다면 타입? 을 사용해야 한다.
    - `var number3: Long?`

### Kotlin 에서의 객체 인스턴스화

- 객체 인스턴스화를 할 때에는 new 를 붙이지 않아야 한다.