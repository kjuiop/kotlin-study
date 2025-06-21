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



<br />

## 코틀린에서 연산자를 다루는 법

- 단항 연산자, 산술 연산자, 산술 대입 연산자 모두 java 와 동일하다
- 비교 연산자 사용법도 java 와 동이랗다
  - 단, 객체끼리도 자동 호출되는 compareTo 를 이용해 비교 연산자를 사용할 수 있다.
- `in` , `!in` / `a..b` / `a[i]` / `a[i] = b` 와 같이 코틀린에서 새로 생긴 연산자도 있다.
- 객체끼리의 연산자를 직접 정의할 수 있다.

### 단항 연산자 / 산술 연산자

- 단항 연산자 : `++` , `--`
- 산술 연산자 : `+` , `-` , `*` , `-` , `%`
- 산술대입 연산자 : `+=` , `-=` , `*=` , `/=` , `%=`
- 비교 연산자 : `>` , `<` , `>=` , `<=`

### 비교 연산자와 동등성, 동일성

- 비교 연산자 : `>` , `<` , `>=` , `<=`
- Java 와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 `compateTo` 를 호출해줍니다.
- 동등성 (Equality) : 두 객체의 값이 같은가?
  - java 에서 두 인스턴스 값이 동일하다는 `equals` 를 사용
  - kotlin 에서는 `==` 를 사용하면 간접적으로 `equals` 를 호출
- 동일성 (Identity) : 완전히 동일한 객체인가? , 즉 주소가 같은가?
  - java 에서는 `==` 로 객체의 주소 값이 동일하다라는 것
  - kotlin 에서는 `===` 를 사용해야 동일성

### 논리 연산자 / 코틀린에 있는 특이한 연산자

- 논리 연산자 : `&&` , `||` , `!`
  - java 와 완전히 동일, java 처럼 Lazy 연산을 수행
  - Lazy 연산이란 조건을 비교할 때 둘 중 하나만으로 결과가 판별나면 뒤의 연산을 하지 않고 그대로 진행하는 것
- `in` , `!in`
  - 컬렉션이나 범위에 포함되어 있다. 포함되어 있지 않다.
- `a..b`
  - a부터 b까지의 범위 객체를 생성한다.
- `a[i]`
  - a 에서 특정 Index i 로 값을 가져온다.
- `a[i] = b`
  - a 의 특정 index i 에 b 를 넣는다.

### 연산자 오버로딩

- kotlin 에서는 객체마다 연산자를 직접 정의할 수 있다.

```kotlin
fun main() {
    val money1 = JavaMoney(1_000L)
    val money2 = JavaMoney(2_000L)
    println(money1 + money2)
}
```

---

## 코틀린에서 조건문을 다루는 방법

- if / if - else / if - else if - else 모두 java 문법과 동일하다
- 단 Kotlin 에서는 Expression 으로 취급된다.
  - 이에 Kotlin 에서는 삼항 연산자가 없다.
- java 의 switch 는 kotlin 에서 when 으로 대체되었고, when 은 더 강력한 기능을 갖는다.

### if 문

```kotlin
// void 생략됨
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("$score 는 0보다 작을 수 없습니다.")
    }
}
```

### Expression 과 Statement

- Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
- Expression : 하나의 값으로 도출되는 문장
  - kotlin 에서는 3항 연산자가 없다. 이유는 값으로 반환 가능하기 때문

```kotlin
fun getPassOrFail(score: Int): String {
    // kotlin 에서 if 문은 문장이 아닌 값이기 때문에 반환 값으로도 사용할 수 있다.
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}
```

- if-else 문도 아래와 같이 사용 가능

```kotlin
fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

```

- if 문에서 in 절 사용

```kotlin
fun validateScoreIsNotNegative(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("$score 의 범위는 0부터 100입니다.")
    }
}
```

### switch 와 when

```kotlin
fun getGradeWithWhen(score: Int): String {
    return when (score / 100) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

```

- switch 문 → when 절로 변경, 각각의 case 문 명시 생략 가능

```kotlin
fun getGradeWithWhenIn(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}
```

- in 절을 사용해서 범위를 나타낼 수 있다.

```kotlin
fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

```

- when 절에서 is 문을 사용

```kotlin
fun judgeNumber1(number: Int) {
    when (number) {
        1, 0, -1 -> println("1, 0, -1 중 하나의 숫자입니다.")
        else -> println("1, 0, -1 이 모두 아닙니다.")
    }
}
```

- when 절에서 복합 조건문 사용

```kotlin
fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}
```

- when 절에서는 값의 존재여부만 체크하고 조건문 로직 검사


<br />


## 코틀린에서 반복문을 다루는 방법

- for each 문에서 java 는 `:` , kotlin 에서는 `in` 을 사용한다.
- 전통적인 for 문에서 kotlin 은 등차수열과 `in` 을 사용한다.
- 그 외 for 문, while, do while 문법은 모두 동일하다.

### for-each 문

```kotlin
fun printForEach() {
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }
}
```

- `:` 대신 `in` 절을 사용

### 전통적인 for 문

```kotlin
fun printTraditionalFor() {
    for ( i in 1..3) {
        println(i)
    }
}
```

- `..` 으로 범위를 나타낼 수 있음

```kotlin
fun printTraditionalForDownTo() {
    for ( i in 3 downTo 1) {
        println(i)
    }
}
```

- `downTo` 절을 통해 감소하는 for 문

```kotlin
fun printTraditionalForStep() {
    for ( i in 1..5 step 2) {
        println(i)
    }
}
```

- `step` 절을 통해 증가하는 단위 설정

### Progression 과 Range

```kotlin
public open class IntProgression
    internal constructor
    (
            start: Int,
            endInclusive: Int,
            step: Int
    ) : Iterable<Int> {
    init {
        if (step == 0) throw kotlin.IllegalArgumentException("Step must be non-zero.")
        if (step == Int.MIN_VALUE) throw kotlin.IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.")
    }
```

- `..` 절을 따라가다보면 등차수열 클래스를 상속받는 것을 알 수 있다.
- IntProgression 에서는 시작점, 끝점, 단위 의 세가지 인수를 받게 되어있다.
- downTo, step 도 함수 (중위 호출 함수)
- 변수.함수이름(argument) 대신 변수 함수이름 argument 로 사용된다.

### while 문

- while 문은 java 와 완전히 동일하다. (do-while 도 마찬가지)

<br />

