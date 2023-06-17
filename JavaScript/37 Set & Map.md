# 37. Set과 Map

## 37.1 Set 객체

> Set 객체는 중복되지 않는 유일한 값들의 집합(set)
> 
- 배열과 유사하지만 다음과 같은 차이점이 존재
    
    
    | 구분 | 배열 | Set 객체 |
    | --- | --- | --- |
    | 동일한 값의 중복을 허용 | O | X |
    | 요소 순서에 의미 | O | X |
    | 인덱스로 요소에 접근 | O | X |
- Set 객체는 `수학적 집합의 특정과 일치`
    - `교집합, 합집합, 차집합, 부분집합 등을 구현 가능`

### 37.1.1 Set 객체 생성

> Set 객체는 Set 생성자 함수로 생성
> 
- Set 생성자 함수는 `이터러블`을 인수로 전달 받아 Set 객체를 생성
    - 중복된 값은 Set 객체에 요소로 저장되지 않는다.
    - `중복을 허용하지 않는 Set 객체의 특정을 활용하여 배열에서 중복된 요소를 제거 가능`
    
    ```jsx
    // Set 기본
    const set1 = new Set([1, 2, 2, 3]);
    console.log(set1); // Set(3) { 1, 2, 3 }
    
    const set2 = new Set("Javascript");
    console.log(set2); // Set(9) { 'J', 'a', 'v', 's', 'c', 'r', 'i', 'p', 't' }
    
    // 중복된 요소 제거 -> 배열
    const uniq = (arr) => arr.filter((v, i, self) => self.indexOf(v) === i);
    console.log(uniq([2, 1, 2, 3, 4, 3, 4])); // [ 2, 1, 3, 4 ]
    
    // 중복된 요소 제거 -> Set 객체
    const uniq = (arr) => [...new Set(arr)];
    console.log(uniq([2, 1, 2, 3, 4, 3, 4])); // [ 2, 1, 3, 4 ]
    ```
    

### 37.1.2 Set.prototype.size 프로퍼티

> Set 객체의 요소 개수를 확인할 때 사용
> 
- setter 함수 없이 `getter 함수만 존재하는 접근자 프로퍼티`

```jsx
// Set 기본
const set1 = new Set([1, 2, 2, 3]);
console.log(set1); // Set(3) { 1, 2, 3 }

const set2 = new Set("Javascript");
console.log(set2); // Set(9) { 'J', 'a', 'v', 's', 'c', 'r', 'i', 'p', 't' }

// 중복된 요소 제거 -> 배열
const uniq = (arr) => arr.filter((v, i, self) => self.indexOf(v) === i);
console.log(uniq([2, 1, 2, 3, 4, 3, 4])); // [ 2, 1, 3, 4 ]

// 중복된 요소 제거 -> Set 객체
const uniq = (arr) => [...new Set(arr)];
console.log(uniq([2, 1, 2, 3, 4, 3, 4])); // [ 2, 1, 3, 4 ]
```

### 37.1.3 Set.prototype.add 메서드

> Set 객체에 요소를 추가할 때 사용
> 
- 메서드 실행 결과는 `새로운 요소가 추가된 Set 객체를 반환`
    - 따라서, add 메서드 체이닝 가능
- 중복되는 요소의 추가는 허용되지 않고, 이때 에러는 발생하지 않고 무시

```jsx
const set1 = new Set([1, 2, 2, 3]);
console.log(set1); // Set(3) { 1, 2, 3 }

set1.add(4);
console.log(set1); // Set(4) { 1, 2, 3, 4 }
```

```jsx
set1.add(4).add(5).add(7).add(2).add(4).add(4).add(4);
```

- Set 객체는 객체나 배열 같이 `자바스크립트의 모든 값을 요소로 저장 가능`

```jsx
const set = new Set();

// add 메서드 체이닝
set
  .add(1)
  .add("a")
  .add(true)
  .add(undefined)
  .add(null)
  .add({})
  .add([])
  .add(() => {});

console.log(set);
// Set(8) {
//   1,
//   'a',
//   true,
//   undefined,
//   null,
//   {},
//   [],
//   [Function (anonymous)]
// }
```

### 37.1.4 Set.prototype.*has* 메서드

> Set 객체에 특정 요소가 존재하는지 확인할 때 사용
> 
- 특정 요소의 존재 여부를 boolean 으로 반환

```jsx
const set = new Set([1, 2, 3]);

console.log(set.has(3)); // true
console.log(set.has(4)); // false
```

### 37.1.5 Set.prototype.delete 메서드

> Set 객체의 특정 요소를 삭제할 때 사용
> 
- 삭제 후, 성공 여부를 boolean 으로 반환
- 인수로 인덱스가 아닌 `삭제하려는 요소를 전달`
    - 인수로 전달한 요소가 Set 자료형 내에 존재하지 않을 경우 에러 없이 무시

```jsx
const set = new Set([1, 2, 3]);

let result = set.delete(3);
console.log(set, result); // Set(2) { 1, 2 } true

result = set.delete(4);
console.log(set, result); // Set(2) { 1, 2 } false
```

### 37.1.6 Set.prototype.clear 메서드

> Set 객체의 모든 요소를 일괄 삭제할 때 사용
> 
- 반환 값은 undefined

```jsx
const set = new Set([1, 2, 3]);

let result = set.delete(3);
console.log(set, result); // Set(2) { 1, 2 } true

result = set.delete(4);
console.log(set, result); // Set(2) { 1, 2 } false
```

### 37.1.7 Set.prototype.forEach 메서드

> Set 객체의 요소들을 순회할 때 사용
> 
- Array.prototype.forEach 메서드와 유사하지만, 전달받는 인수가 다르다.
    - 첫 번째 인수 → 현재 순회 중인 요소값
    - 두 번째 인수 → 현재 순회 중인 요소값
    - 세 번째 인수 → 현재 순회 중인 Set 객체 자신
    - `첫 번째, 두 번째 인수가 같은 것`은 단순히 Array.prototoype.forEach 메서드와 `인터페이스를 통일하기 위함` (Array.prototype.forEach의 두 번째 인수는 인덱스임)
    
    ```jsx
    const set = new Set([1, 2, 3]);
    
    set.forEach((v1, v2, self) => console.log(v1, v2, self));
    // 1 1 Set(3) { 1, 2, 3 }
    // 2 2 Set(3) { 1, 2, 3 }
    // 3 3 Set(3) { 1, 2, 3 }
    ```
    
- `Set 객체는 이터러블이다.`
    - `for - of문, 스프레드 문법, 배열 디스트럭처링 할당의 대상이 된다.`
    
    ```jsx
    const set = new Set([1, 2, 3]);
    
    // Set 객체가 이터러블 -> Symbol.iterator 프로퍼티가 존재하는지 확인
    console.log(Symbol.iterator in set); // true
    
    // Set 객체가 이터러블 -> for - of문 가능
    for (const value of set) {
      console.log(value); // 1 2 3
    }
    
    // Set 객체가 이터러블 -> 스프레드 문법 가능
    console.log([...set]); // [ 1, 2, 3 ]
    
    // Set 객체가 이터러블 -> 배열 디스트럭처링 가능
    const [a, ...rest] = set;
    console.log(a, rest); // 1 [ 2, 3 ]
    ```
    
- Set 객체는 요소의 순서가 무의미하지만, `Set 객체를 순회하는 순서는 요소가 추가된 순서를 따른다.`
    - ECMAScript 표준 사양에 규정되어 있지는 않지만, `다른 이터러블의 순회와 호환성을 유지하기 위함`

### 37.1.8 Set 집합 구현

- `교집합`
    
    ```jsx
    // Set 객체 프로토타입에 "교집합" 정의
    Set.prototype.intersection = function (set) {
      const result = new Set();
    
      for (const val of set) {
        if (this.has(val)) result.add(val);
      }
    
      return result;
    };
    
    const setA = new Set([1, 2, 3, 4]);
    const setB = new Set([2, 4]);
    
    // setA 와 setB의 교집합
    console.log(setA.intersection(setB)); // Set(2) { 2, 4 }
    // setB 와 setA의 교집합
    console.log(setB.intersection(setA)); // Set(2) { 2, 4 }
    ```
    
- `합집합`
    
    ```jsx
    // Set 객체 프로토타입에 "합집합" 정의
    Set.prototype.union = function (set) {
      const result = new Set(this);
    
      for (const val of set) {
        result.add(val);
      }
    
      return result;
    };
    
    const setA = new Set([1, 2, 3, 4]);
    const setB = new Set([2, 4]);
    
    // setA 와 setB의 합집합
    console.log(setA.union(setB)); // Set(4) { 1, 2, 3, 4 }
    // setB 와 setA의 합집합
    console.log(setB.union(setA)); // Set(4) { 2, 4, 1, 3 }
    
    /**
     * 💡 합집합의 요소 구성은 같으나, 요소 구성 순서는 보장하지 X
     */
    ```
    
- `차집합`
    
    ```jsx
    // Set 객체 프로토타입에 "차집합" 정의
    Set.prototype.difference = function (set) {
      const result = new Set(this);
    
      for (const val of set) {
        result.delete(val);
      }
    
      return result;
    };
    
    const setA = new Set([1, 2, 3, 4]);
    const setB = new Set([2, 4]);
    
    // setA - setB
    console.log(setA.difference(setB)); // Set(2) { 1, 3 }
    // setB - setA
    console.log(setB.difference(setA)); // Set(0) {}
    ```
    
- `부분집합 & 상위집합`
    
    ```jsx
    // Set 객체 프로토타입에 "서브셋에 대한 상위 집합" 정의
    Set.prototype.isSuperset = function (subset) {
      for (const val of subset) {
        if (!this.has(val)) return false;
      }
    
      return true;
    };
    
    const setA = new Set([1, 2, 3, 4]);
    const setB = new Set([2, 4]);
    
    // setB가 setA의 부분집합인지 판별 (= setA가 setB의 상위 집합인지 판별)
    console.log(setA.isSuperset(setB)); // true
    // setA가 setB의 부분집합인지 판별 (= setB가 setA의 상위 집합인지 판별)
    console.log(setB.isSuperset(setA)); // false
    ```
    

## 37.2 Map 객체

> Map 객체는 키와 값의 쌍으로 이뤄진 컬렉션
> 
- 객체와 유사하지만 다음과 같은 차이점이 존재
    
    
    | 구분 | 객체 | Map 객체 |
    | --- | --- | --- |
    | 키로 사용할 수 있는 값 | 문자열 or 심벌 값 | 객체를 포함한 모든 값 |
    | 이터러블 | X | O |
    | 요소 개수 확인 | Object.keys(obj).length | Map.prototype.size |

### 37.2.1 Map 객체 생성

> Map 객체는 Map 생성자 함수로 생성
> 
- Map 생성자 함수는 인수로 `이터러블을 전달받아 Map 객체를 생성`
    - 전달되는 `이터러블은 키와 값의 쌍으로 이루어진 요소로 구성되어야 한다.`
    
    ```jsx
    const map1 = new Map([
      ["key1", "value1"],
      ["key2", "value2"],
    ]);
    console.log(map1); // Map(2) { 'key1' => 'value1', 'key2' => 'value2' }
    
    const map2 = new Map([1, 2]); // TypeError: Iterator value 1 is not an entry object
    ```
    
    - 인수로 전달한 `이터러블의 중복된 키를 갖는 요소가 존재하면 값이 덮어쓰여진다.`
        - 따라서, `중복된 키를 갖는 요소가 존재할 수 없다.`
    
    ```jsx
    const map1 = new Map([
      ["key1", "기존 값"],
      ["key1", "덮어쓰인 값"],
    ]);
    console.log(map1); // Map(1) { 'key1' => '덮어쓰인 값' }
    ```
    

### 37.2.2 Map.prototype.size 프로퍼티

> Map 객체의 요소 개수를 확인할 때 사용
> 
- setter 없이 `getter 함수만 존재하는 접근자 프로퍼티`

```jsx
const { size } = new Map([
  ["key1", "value1"],
  ["key1", "value2"],
]);

console.log(size); // 1
```

### 37.2.3 Map.prototype.set 메서드

> Map 객체에 요소를 추가할 때 사용
> 
- `반환 값은 요소가 추가된 새로운 Map 객체를 반환`
    
    ```jsx
    const map = new Map();
    console.log(map); // Map(0) {}
    
    map.set("key1", "value1");
    console.log(map); // Map(1) { 'key1' => 'value1' }
    ```
    
    - 따라서, `set 메서드 체이닝 가능`
    
    ```jsx
    const map = new Map();
    console.log(map); // Map(0) {}
    
    map.set("key1", "value1").set("key2", "value2");
    console.log(map); // Map(2) { 'key1' => 'value1', 'key2' => 'value2' }
    ```
    
- 중복된 키를 갖는 요소가 존재할 수 없기 때문에 중복된 키를 갖는 요소를 추가하면 갚이 덮어쓰여진다. ( 에러 발생 X )
    
    ```jsx
    const map = new Map();
    console.log(map); // Map(0) {}
    
    map.set("key1", "기존 값");
    map.set("key1", "덮어쓰인 값");
    console.log(map); // Map(1) { 'key1' => '덮어쓰인 값' }
    ```
    
- `객체는 문자열과 심벌 값만 키로 허용하지만, Map 객체는 자바스크립트의 모든 값을 키로 허용`
    
    ```jsx
    const map = new Map();
    
    const objKey1 = { lastName: "W" };
    const objKey2 = { firstName: "YM" };
    
    // 객체를 Map 객체의 키로 사용 가능
    map.set(objKey1, "value 1");
    map.set(objKey2, "value 2");
    
    console.log(map);
    // Map(2) {
    //   { lastName: 'W' } => 'value 1',
    //   { firstName: 'YM' } => 'value 2'
    // }
    ```
    

### 37.2.4 Map.prototype.get 메서드

> Map 객체의 특정 요소를 취득할 때 사용
> 
- `인수로 키를 전달한다.`
    - 전달한 키를 갖는 `값을 반환`
    - 키가 존재하지 않는 경우 `undefined 반환`
    
    ```jsx
    const map = new Map();
    
    const obj1 = { name: "W" };
    const obj2 = { name: "YM" };
    
    map.set(obj1, "developer").set(obj2, "Front Dev");
    
    console.log(map.get(obj1)); // developer
    console.log(map.get(obj2)); // Front Dev
    console.log(map.get("key")); // undefined
    ```
    

### 37.2.5 Map.prototype.has 메서드

> Map 객체에 특정 요소가 존재하는지 확인할 때 사용
> 
- 존재 여부를 boolean 으로 반환

```jsx
const obj1 = { name: "W" };
const obj2 = { name: "YM" };

const map = new Map([
  [obj1, "developer"],
  [obj2, "Front Dev"],
]);

console.log(map.has(obj1)); // true
console.log(map.has("key")); // false
```

### 37.2.6 Map.prototype.delete 메서드

> Map 객체에 특정 요소를 삭제할 때 사용
> 
- `인수로 키를 전달한다.`
    - 전달한 `키에 매칭되는 값이 존재하면 요소를 삭제`
    - `키에 해당하는 요소가 존재하지 않으면 에러 없이 무시`
- 삭제 여부를 boolean 으로 반환

```jsx
const obj1 = { name: "W" };
const obj2 = { name: "YM" };

const map = new Map([
  [obj1, "developer"],
  [obj2, "Front Dev"],
]);

let result = map.delete(obj1);
console.log(map, result); // Map(1) { { name: 'YM' } => 'Front Dev' } true

result = map.delete("key");
console.log(map, result); // Map(1) { { name: 'YM' } => 'Front Dev' } false
```

### 37.2.7 Map.prototype.clear 메서드

> Map 객체의 요소를 일괄 삭제할 때 사용
> 
- `반환 값은 undefined`

```jsx
const obj1 = { name: "W" };
const obj2 = { name: "YM" };

const map = new Map([
  [obj1, "developer"],
  [obj2, "Front Dev"],
]);

let result = map.clear();
console.log(map, result); // Map(0) {} undefined
```

### 37.2.8 Map.prototype.forEach 메서드

> Map 객체를 순회할 때 사용
> 
- Array.prototype.forEach 메서드와 유사하지만, 전달받는 인수가 다르다.
    - 첫 번째 인수 → 현재 순회 중인 요소 값
    - 두 번째 인수 → 현재 순회 중인 요소 키
    - 세 번째 인수 → 현재 순회 중인 Map객체 자신
    
    ```jsx
    const obj1 = { name: "W" };
    const obj2 = { name: "YM" };
    
    const map = new Map([
      [obj1, "developer"],
      [obj2, "Front Dev"],
    ]);
    
    map.forEach((v, k, self) => console.log(v, k, self));
    // developer { name: 'W' } Map(2) { { name: 'W' } => 'developer', { name: 'YM' } => 'Front Dev' }
    // Front Dev { name: 'YM' } Map(2) { { name: 'W' } => 'developer', { name: 'YM' } => 'Front Dev' }
    ```
    
- `Map 객체는 이터러블`이다.
    - `for - of문, 스프레드 문법, 배열 디스트럭처링 할당의 대상이 된다.`
    
    ```jsx
    const obj1 = { name: "W" };
    const obj2 = { name: "YM" };
    
    const map = new Map([
      [obj1, "developer"],
      [obj2, "Front Dev"],
    ]);
    
    // Map 객체 -> 이터러블 -> Symbol.iterator 프로퍼티 존재 판별
    console.log(Symbol.iterator in map); // true
    
    // Map 객체 -> 이터러블 -> for - of문 가능
    for (const entry of map) {
      console.log(entry);
    }
    // [{ name: "W" }, "developer"]
    // [({ name: "YM" }, "Front Dev")]
    
    // Map 객체 -> 이터러블 -> 스프레드 문법 가능
    console.log([...map]); // [ [ { name: 'W' }, 'developer' ], [ { name: 'YM' }, 'Front Dev' ] ]
    
    // Map 객체 -> 이터러블 -> 배열 디스트럭처링 할당 가능
    const [a, b] = map;
    console.log(a, b); // [ { name: 'W' }, 'developer' ] [ { name: 'YM' }, 'Front Dev' ]
    ```
    
    - `이터레이터인 객체를 반환하는 메서드이기도 하다.`?
        
        
        | Map 메서드 | 설명 |
        | --- | --- |
        | Map.prototype.keys | Map 객체에서 요소키를 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환 |
        | Map.prototype.values | Map 객체에서 요소값을 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환 |
        | Map.prototype.entries | Map 객체에서 요소키와 요소값을 값으로 갖는 이터러블이면서 동시에 이터레이터인 객체를 반환 |
    
    ```jsx
    const obj1 = { name: "W" };
    const obj2 = { name: "YM" };
    
    const map = new Map([
      [obj1, "developer"],
      [obj2, "Front Dev"],
    ]);
    
    for (const key of map.keys()) {
      console.log(key);
    }
    // { name: 'W' }
    // { name: 'YM' }
    
    for (const value of map.values()) {
      console.log(value);
    }
    // developer
    // Front Dev
    
    for (const entry of map.entries()) {
      console.log(entry);
    }
    // [ { name: 'W' }, 'developer' ]
    // [ { name: 'YM' }, 'Front Dev' ]
    ```