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


<br />

## 코틀린에서 Type 을 다루는 법

- 코틀린의 변수는 초기값을 보고 타입을 추론하며, 기본 타입들 간의 변환은 명시적으로 이루어진다.
- 코틀린에서는 is, !is, as, as? 를 이용해 타입을 확인하고 캐스팅한다.
- 코틀린의 Any 는 Java 의 Object 와 같은 최상위 타입이다.
- 코틀린의 Unit 은 Java 의 void 와 동일하다.
- 코틀린에 있는 Nothing 은 정상적으로 끝나지 않는 함수의 반환을 의미한다.

### 기본 타입

- Byte, Short, Int, Long, Float, Double, 부호 없는 정수들
- kotlin 에서는 선언된 기본 값을 보고 타입을 추론
- java 는 기본 타입 간의 변환이 암시적으로 이루어질 수 있다.
  `int number = 1`
  `long number2 = number1;`
- kotlin 은 java 와 다르게 기본 타입 간의 변환은 명시적으로 이루어져야 한다.
  `val number1: Int = 4`
  `val number2: Long = number1.toLong()`
- 변수가 nullable 이면 null 처리가 필요
  `val number1: Int? = 3`
  `val number2: Long = number1?.toLong : 0L`

### 타입 캐스팅

- java 에서는 instanceof (변수가 주어진 타입이면 true, 그렇지 않으면 false) 를 사용함

```kotlin
fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
    }
}
```

- kotlin 에서는 instanceof 대신 `is` 를 사용해서 조건을 대신함
- as 를 통해 기존 java 의 `(Person)`  을 대체함

```kotlin
fun printAgeIfPerson2(obj: Any) {
    if (obj is Person) {
        println(obj.age)
    }
}
```

- 또한 스마트 캐스팅이라고 해서 `is` 문법 안에 들어온 경우 캐스팅되었다고 판단함
- `!is` 표현을 통해 반대의 조건도 걸 수 있음

```kotlin
fun printAgeIfPerson4(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}
```

- `as?` 는 Type 이면 타입 캐스팅, `null` 이거나 타입이 아니면 `null`

### Kotlin 의 3가지 특이한 타입

- Any
  - java 의 Object 역할 (모든 객체의 최상위 타입)
  - 모든 Primitive Type 의 최상위 타입도 Any이다.
  - Any 자체로는 null 을 포함할 수 없어 null 을 포함하고 싶다면, Any? 로 표현
  - Any 에 equals / hashCode / toString 존재

- unit
  - java 의 void 와 동일한 역할
  - void 와 다르게 unit 은 그 자체로 타입 인자로 사용 가능하다.
  - 함수형 프로그래밍에서 Unit 은 단 하나의 인스턴스만 갖는 타입을 의미, 즉 코틀린의 Unit 은 실제 존재하는 타입이라는 것을 표현

- nothing
  - nothing 은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
  - 무조건 예외를 반환하는 함수 / 무한 루프 함수 등

- String interpolation / String indexing
  - `val log = “사람의 이름은 ${person.name} 이고 나이는 ${person.age} 세 입니다.”`
  - `${변수}` 를 사용하는 것이 가독성, 일괄 변환, 정규식 활용 측면에서 좋습니다.

### String Interpolation, String indexing

```kotlin
fun main() {
    val str = """
        ABCD
        EFG
    """.trimIndent()
    println(str)
}
```

- Kotlin 에서 문자열의 특정 문자 가져오기

  `val str = “ABCDE”`
  `val ch = str[1]`