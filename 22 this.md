# 22. this

# 22. this

자바에서 this는 그냥 객체 자신이지만,

자바스크립트에서 this는 맥락에 따라서 달라진다.

## 먼저 정리 : 외우자

| 함수 호출 방식 | this 바인딩 대상 |
| --- | --- |
| 일반 함수 호출 | 전역 객체 |
| 메서드 호출 | 메서드를 호출한 객체 |
| 생성자 함수 호출 | 생성자 함수가 생성할 인스턴스 (자바에서와 같은 경우) |
| Function.prototype 에 apply, call, bind 
메서드에 의한 간접 호출 | Function.prototype 에 apply, call, bind 메서드에 첫 번째 인수로 전달한 객체 |

## 22.1 this 키워드

- 자신이 속한 객체나 자신이 생성할 인스턴스를 가리키는 자기 참조 변수(self-referencing variable)
- `this` 를 통해 자신이 속한 객체 또는 자신이 생성할 인스턴스의 `프로퍼티나 메서드를 참조할 수 있다.`
- `this` 는 자바스크립트 엔진에 의해 암묵적으로 생성된다.
- this 가 가리키는 값, 즉 this 바인딩 은 함수 호출 방식에 의해 동적으로 결정된다.
- 자바나 C++같은 클래스 기반 언어에서 this는 언제나 `클래스가 생성하는 인스턴스` 를 가리킨다.
- 하지만, `자바스크립트의 this` 는 함수가 호출되는 방식에 따라 
`this에 바인딩될 값, 즉 this 바인딩이 동적으로 결정된다.`

## 22.2 함수 호출 방식과 this 바인딩

> 함수를 호출하는 방식은 크게 다음과 같다.
> 
- `일반 함수 호출`
- `메서드 호출`
- `생성자 함수 호출`
- `Function.prototype.apply / call / bind 메서드에 의한 간접 호출`

### 22.2.1 일반 함수 호출

> 기본적으로 this 에는 전역 객체(global object) 가 바인딩됩니다.
> 
- 전역 함수는 물론, 중첩 함수를 `일반 함수로 호출된 모든 함수(중첩함수, 콜백함수 포함) 내부의 this에는 전역 객체가 바인딩`
- `중첩 함수` 나 `콜백 함수` 의 경우, 용도가 일반적으로 외부 함수를 돕는 `헬퍼 함수의 역할` 을 하므로, `this` 가 가리키는 객체가 `전역 객체` 일 경우는 헬퍼 함수의 역할을 하기 힘들다.
- 메서드 내부의 `중첩 함수나 콜백 함수의 this 바인딩` 을 `메서드의 this 바인딩과 일치시키기 위한 방법`은 다음과 같다.
- 메서드의 this 바인딩할 객체를 `변수에 할당하는 방법`
- `Function.prototype.apply` or `[Function.prototype.call](http://Function.prototype.call)` 에 의한 바인딩

```jsx
`// 전역 변수 value ( 전역 객체 프로퍼티 )
var value = 1;

const obj = {
  value: 100,
  foo() {
    // 콜백 함수에 바인딩할 obj 객체를 가리키는 this를 변수 that에 할당
    const that = this;

    setTimeout(function () {
      console.log(`callback 함수의 this : ${that}`); // callback 함수의 this : [object Object]
      console.log(`callback 함수의 this가 가리키는 객체의 value : ${that.value}`); // callback 함수의 this가 가리키는 객체의 value : 100
    }, 100);
  },
};

obj.foo();`

`// 전역 변수 value ( 전역 객체 프로퍼티 )
var value = 1;

const obj = {
  value: 100,
  foo() {
    // Function.prototype.bind 메서드로 obj 객체를 가리키는 this를 콜백함수에 명시적으로 바인딩
    setTimeout(
      function () {
        console.log(`callback 함수의 this : ${this}`); // callback 함수의 this : [object Object]
        console.log(`callback 함수의 this가 가리키는 객체의 value : ${this.value}`); // callback 함수의 this가 가리키는 객체의 value : 100
      }.bind(this),
      100,
    );
  },
};

obj.foo();`
```

### 22.2.2 메서드 호출

기본적으로 메서드 내부의 this 에는 메서드를 호출한 객체 가 바인딩됩니다.

- 즉, `메서드를 호출할 때` 메서드 앞에 마침표(.) 연산자 앞에 기술한 객체가 바인딩
    - 주의할 점은 메서드 내부의 this는 `메서드를 소유한 객체가 아닌, 메서드를 **호출**한 객체에 바인딩 된다는 점`
    
    ```jsx
    const person = {
      name: "WI",
      getName() {
        // 메서드 내부의 this는 메서드를 호출한 객체에 바인딩
        // getName 메서드는 person 객체에 포함된 것이 아닌, 독립적으로 존재하는 별도의 객체 개념
        return this.name;
      },
    };
    
    console.log(person.getName());  // WI
    ```
    
- 메서드는 특정 객체에 포함된 것이 아닌, `독립적으로 존재하는 별도의 객체`
    - 즉, `다른 객체의 프로퍼티에 할당이 가능`(되는 경우가 있음)
    - `일반 변수에 할당하여 일반 함수로 호출도 가능`
    
    ```jsx
    const person = {
      name: "WI",
      getName() {
        // 메서드 내부의 this는 메서드를 호출한 객체에 바인딩
        // getName 메서드는 person 객체에 포함된 것이 아닌, 독립적으로 존재하는 별도의 객체 개념
        return this.name;
      },
    };
    
    const anotherPerson = {
      name: "KIM",
    };
    
    // getName 메서드를 anotherPerson 객체의 메서드로 할당 (getName 메서드는 독립적인 객체이기 때문)
    anotherPerson.getName = person.getName;
    
    // getName을 호출한 객체는 이 시점에선 person이 아닌 anotherPerson이다.
    console.log(anotherPerson.getName());  // KIM
    
    // getName을 getName 변수에 할당 (getName 메서드는 독립적인 객체이기 때문)
    const getName = person.getName;
    
    // getName을 호출한 객체는 이 시점에서는 전역 객체다.
    // 전역 객체에 프로퍼티에는 name 이라는 프로퍼티가 존재하지 않다.
    // 참조 시, 자바스크립트 엔진이 암묵적으로 undefined 로 초기화한다.
    console.log(getName());  // undefined
    ```
    
- 프로토타입 메서드 내부에서 사용된 this도 일반 메서드와 마찬가지로 해당 메서드를 호출한 객체에 바인딩 (상관 없이 똑같이 작동)

```jsx
// 생성자 함수
function Person(name) {
  this.name = name;
}

// 프로토타입에 getName 메서드 할당
Person.prototype.getName = function () {
  return this.name;
};

// me 인스턴스 생성
const me = new Person("WI");

// 이 시점에서 getName 메서드를 호출한 주체는 me 객체
console.log(me.getName()); // WI

Person.prototype.name = "KIM";

// 이 시점에서 getName 메서드를 호출한 주체는 Person.prototype 객체
console.log(Person.prototype.getName()); // KIM
```

### 22.2.3 생성자 함수 호출

생성자 함수 내부의 this에는 함수가 생성할 인스턴스가 바인딩 됩니다. 
(클래스 기반 언어에서 사용하는 this의 사용법)

- 생성자 함수의 역할은 `객체(인스턴스)를 생성하는 함수`

```jsx
// 생성자 함수
function Person(name) {
  this.name = name;
  this.getName = function () {
    return `안녕하세요. 저는 ${this.name}입니다.`;
  };
}

const person1 = new Person("WI");
const person2 = new Person("KIM");

console.log(person1.getName()); // 안녕하세요. 저는 WI입니다.
console.log(person2.getName()); // 안녕하세요. 저는 KIM입니다.
```

### 22.2.4 **Function.prototype.apply / call / bind 메서드에 의한 간접 호출**

apply, call, bind 는 Function.prototype 의 메서드입니다.

- 즉, 모든 함수가 이 메서드들을 `상속` 받아 사용 가능
    - `Function.prototype.apply(this로 사용할 객체, arguments 리스트(배열 or 유사배열객체))`
    - `Function.prototype.call(this로 사용할 객체, arguments 인수 리스트(,로 구분하여 전달))`
    - `Function.prototype.bind(this로 사용할 객체)`
- `apply, call`
    - 본질적은 기능은 `함수를 호출하는 것`
    - 함수를 호출하면서 `첫 번째 인수로 전달한 특정 객체를 호출한 함수의 this에 바인딩`
    - 두 번째 인수를 함수에 전달하는 방식만 다를 뿐 동일하게 작동
    - 대표적으로, `arguments 객체와 같은 유사 배열 객체에 배열 메서드를 사용하는 경우`에 효과적
    
    ```jsx
    function convertArgsToArray() {
      console.log(arguments); // [Arguments] { '0': 1, '1': 2, '2': 3 }
    
      // 유사 배열 객체인 arguments 객체는 배열이 아니다.
      // 그런 arguments 객체에 대해, 배열 메서드인 Array.prototype.slice 메서드를 Function.prototype.call 메서드로 arguments 객체에 바인딩한다.
      // 유사 배열 객체 arguments 객체임에도 배열 메서드인 slice 메서드를 적용하여 반환된 새로운 배열 객체를 반환할 수 있게 된다. 
      const arr = Array.prototype.slice.call(arguments);
    
      console.log(arr); // [ 1, 2, 3 ]
    
      return arr;
    }
    
    convertArgsToArray(1, 2, 3);
    ```
    
- `bind`
    - 본질적인 기능은 `함수를 호출하진 않고 this로 사용할 객체만 전달`
    - 대표적으로, `메서드의 this와 메서드 내부의 중첩 함수 or 콜백 함수의 this가 불일치하는 문제 해결`에 효과적
    
    ```jsx
    const person = {
      name: "WI",
      foo(callback) {
        // bind 를 적용하지 않는다면, foo 메서드 내부에 콜백 함수에 정의된 this는 전역 객체(window 또는 global)를 가리킨다.
        // 전역 객체에는 name 프로퍼티가 없기 때문에, 원래는 undefined 를 출력하는 것이 맞다.
        // 하지만, Function.prototype.bind 메서드로 콜백 함수의 주체를 person 객체로 동적 바인딩 해주었다.
        // 때문에 person 객체의 name 프로퍼티에 접근할 수 있게 되었다.
        **setTimeout(callback.bind(this), 100);**
      },
    };
    
    person.foo(function () {
      console.log(`안녕하세요. ${this.name}입니다.`); // 안녕하세요. WI입니다.
    });
    ```