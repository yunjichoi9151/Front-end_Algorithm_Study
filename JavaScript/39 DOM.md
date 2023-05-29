# 39. DOM

브라우저의 렌더링 엔진은 HTML 문서를 파싱하여 브라우저가 이해할 수 있는 자료구조인 **DOM**을 생성한다. 

DOM은 HTML 문서의 계층적 구조와 정보를 표현하며 이를 제어할 수 있는 API, 즉 **프로퍼티와 메서드를 제공하는 트리 자료구조**이다.

## 39.1 노드

### 39.1.1 HTML 요소와 노드 객체

HTML 요소란 HTML 문서를 구성하는 개별적인 요소를 의미한다

```jsx
<div class="greeting">Hello</div>
```

- <div>, </div> : 시작태그, 종료태그
- class : 어트리뷰트 이름
- “greeting” : 어트리뷰트 값
- Hello : 콘텐츠

HTML 요소는 렌더링 엔진에 의해 파싱되어 DOM을 구성하는 요소 노드 객체로 변환되는데, 이때 HTML 요소의 어트리뷰트(여기서는 class)는 어트리뷰트 노드, 텍스트 콘텐츠(여기서는 Hello)는 텍스트 노드로 변환된다

HTML 요소는 서로 중첩될 수 있는데, 이 중첩 관계에 의해 계층적인 부자관계(parent-child)가 형성되고, 이를 반영해서 HTML 요소 노드 객체를 트리 자료구조로 구성하는 것이 가능해진다.

### 39.1.2 노드 객체의 타입

********************************트리 자료구조********************************

트리 자료구조는 노드들의 계층 구조로 이뤄진다. 이 말은 즉 부모 노드와 자식 노드의 계층적 구조를 가진다는 뜻이기도 하다. 부모 노드가 없는 최상위 노드를 **루트 노드(root node)**라고 하며, 자식 노드가 없는 최하위 노드를 **리프 노드(leaf node)**라고 한다.

이러한 노드 객체로 구성된 트리 자료구조를 DOM이라고 한다. 

![dom-tree.png](39%20DOM%20cbb0636402c44e75a714b8584e374522/dom-tree.png)

DOM트리를 구성하는 트리 노드 객체는 총 12개의 종류가 있는데, 그 중 주요한 4개의 타입은 다음과 같다.

**문서 노드(Document Node)**

트리의 최상위에 존재하며 각각 요소, 어트리뷰트, 텍스트 노드에 접근하려면 문서 노드를 통해야 한다. 즉, DOM tree에 접근하기 위한 시작점(entry point)이다.

**요소 노드(Element Node)**

요소 노드는 HTML 요소를 표현한다. HTML 요소는 중첩에 의해 부자 관계를 가지며 이 부자 관계를 통해 정보를 구조화한다. 따라서 요소 노드는 문서의 구조를 서술한다고 말 할 수 있다. 어트리뷰트, 텍스트 노드에 접근하려면 먼저 요소 노드를 찾아 접근해야 한다. 모든 요소 노드는 요소별 특성을 표현하기 위해 HTMLElement 객체를 상속한 객체로 구성된다. (그림: DOM tree의 객체 구성 참고)

**어트리뷰트 노드(Attribute Node)**

어트리뷰트 노드는 HTML 요소의 어트리뷰트를 표현한다. 어트리뷰트 노드는 해당 어트리뷰트가 지정된 요소의 자식이 아니라 해당 요소의 일부로 표현된다. 따라서 해당 요소 노드를 찾아 접근하면 어트리뷰트를 참조, 수정할 수 있다.

**텍스트 노드(Text Node)**

텍스트 노드는 HTML 요소의 텍스트를 표현한다. 텍스트 노드는 요소 노드의 자식이며 자신의 자식 노드를 가질 수 없다. 즉, 텍스트 노드는 DOM tree의 최종단이다.

### 39.1.3 노드 객체의 상속 구조

DOM을 구성하는 노드 객체는 자신의 구조와 정보를 제어할 수 있는 DOM API를 사용할 수 있다. 노드 객체는 ECMAScript 사양에 정의된 표준 빌트인 객체(즉 자바스크립트 내장 객체)가 아니라 브라우저 환경에서 추가적으로 제공하는 호스트 객체이다. 하지만 노드 객체도 자바스크립트 객체이기 때문에 프로토타입에 의한 상속 구조를 갖는다. 

![HTMLElement.png](39%20DOM%20cbb0636402c44e75a714b8584e374522/HTMLElement.png)

| input 요소 노드 객체의 특성 | 프로토타입을 제공하는 객체 |
| --- | --- |
| 객체 | Object |
| 이벤트를 발생시키는 객체 | EventTarget |
| 트리 자료구조의 노드 객체 | Node |
| 브라우저가 렌더링할 수 있는 웹 문서의 요소(HTML, XML, SVG)를 표현하는 객체 | Element |
| HTML 요소를 표현하는 객체 | HTMLElement |
| Input 요소를 표현하는 객체 | HTMLInputElement |

## 39.2 요소 노드 취득

HTML 구조나 내용, 스타일 등을 동적으로 조작하려면 먼저 요소 노드를 취득해야 한다.

### 39.2.1 id를 이용한 요소 노드 취득

`Document.prototype.getElementById` 메서드는 인수로 전달한 id 어트리뷰트 값을 갖는 하나의 요소 노드를 탐색하여 반환한다. getElementById 메서드는 Document.prototype의 프로퍼티이기 때문에 반드시 문서 노드인 document를 통해 호출해야 한다.

id값은 기본적으로 중복되지 않는 유일한 값이지만, 실제로는 HTML 문서 내에 id값이 중복되도 에러가 발생하지 않는다. getElementById 메서드는 이러한 경우 인수로 전달된 id 값을 갖는 첫번째 요소 노드만을 반환한다.

```jsx
//id값이 grape인 요소 노드를 탐색하여 반환한다.
const $elem = document.getElementById('grape');
```

### 39.2.2 태그 이름을 이용한 요소 노드 취득

`Document.prototype/Element.prototype.getElementsByTagName` 메서드는 인수로 전달한 태그 이름을 갖는 모든 요소 노드들을 탐색하여 반환한다. 여러 개를 반환하기 때문에 DOM 컬렉션 객체인 HTMLCollection 객체를 반환한다.

```jsx
//<li> 태그를 가진 요소 노드를 반환한다.
const $elems = document.getElementsByTagName('li');

[...$elems].forEach(elem => { elem.style.color = 'red'; });
```

### 39.2.3 class를 이용한 요소 노드 취득

`Document.prototype/Element.prototype.getElementsByClassName` 메서드는 인수로 전달한 class 어트리뷰트 값을 갖는 모든 요소 노드들을 탐색하여 반환한다. 태그 이름으로 탐색할 때와 마찬가지로 HTMLCollections 객체를 반환한다.

```jsx
//class="fruit"인 요소 노드들을 반환한다.
const $elems = document.getElementsByClassName('fruit');
```

Document.prototype에 정의된 메서드가 있고 Element.prototype에 정의된 메서드 두가지가 있는데,

document를 통해 호출할 경우엔 문서 전체, 특정 요소 노드(element)를 통해 호출할 경우엔 해당 요소 노드의 자손 노드 중에서 탐색하여 반환한다.

### 39.2.4 CSS 선택자를 이용한 요소 노드 취득

CSS 선택자는 스타일을 적용하고자 하는 HTML요소를 특정할 때 사용하는 문법이다.

```jsx
/* 전체 선택자 : 모든 요소를 선택 */
* { ... }

/* 태그 선택자 : 모든 특정 태그 요소를 모두 선택 */
p { ... }

/* id 선택자 : 특정 id 값을 가진 요소를 모두 선택 */
#id { ... }

/* class 선택자 : 특정 class 어트리뷰트를 가진 요소를 모두 선택 */
.class { ... }

/* 어트리뷰트 선택자 : 특정 요소 중 특정 type 어트리뷰트 값을 갖는 요소를 모두 선택 */
input[type="text"] { ... }

/* 후손 선택자 : 특정 요소의 후손 요소를 선택 */
div p { ... }

/* 자식 선택자 : 특정 요소의 자식 요소를 선택 */
div > p { ... }

/* 인접 형제 선택자 : 특정 요소의 형제 요소 중 해당 요소의 바로 뒤에 위치하는 요소를 선택 */
p + ul { ... }

/* 일반 형제 선택자 : 특정 요소의 형제 요소 중 해당 요소 뒤에 위치하는 요소를 모두 선택 */
p ~ ul { ... }

/* 가상 클래스 선택자 : 여기서는 hover 상태인 a 요소를 모두 선택 */
a:hover { ... }

/* 가상 요소 선택자 : p 요소의 컨텐츠 앞에 위치하는 공간을 선택 */
p::before { ... }
```

`Document.prototype/Element.prototype.querySelector` 메서드는 인수로 전달한 CSS 선택자를 만족시키는 하나의 요소 노드를 탐색하여 반환하는 메서드이다.

```jsx
//class=banana인 첫번째 요소 노드를 탐색하여 반환
const $elem = document.querySelector('.banana');
```

`Document.prototype/Element.prototype.querySelectorAll` 메서드는 인수로 전달한 CSS 선택자를 만족시키는 모든 요소 노드를 탐색하여 반환하는 메서드이다.

## 39.3 노드 탐색

요소 노드를 취득한 다음, 취득한 요소 노드를 기점으로 DOM 트리의 노드를 옮겨다니며 노드를 탐색해야할 경우가 있다.

![다운로드.png](39%20DOM%20cbb0636402c44e75a714b8584e374522/%25EB%258B%25A4%25EC%259A%25B4%25EB%25A1%259C%25EB%2593%259C.png)

Node, Element 인터페이스가 제공하는 프로퍼티로, 모두 읽기만 가능한 읽기 전용 접근자 프로퍼티이다.

### 39.3.1 공백 텍스트 노드

스페이스, 탭, 줄바꿈 등의 공백 문자는 공백 텍스트 노드를 생성한다. 물론 인위적으로 제거하는 것도 가능하지만 코드 가독성이 떨어지기 때문에 권장하지 않는다.

### 39.3.2 자식 노드 탐색

| 프로퍼티 | 설명 |
| --- | --- |
| Node.prototype.childNodes | 자식 노드를 모두 탐색하여 NodeList 객체에 담아 반환한다. 요소 노드 뿐만 아니라 텍스트 노드도 포함되어 있을 수 있다. |
| Element.prototype.children | 자식 노드 중 요소 노드만을 모두 탐색하여 HTMLCollection 객체에 담아 반환한다. |
| Node.prototype.firstChild | 첫번째 자식 노드를 반환한다. 텍스트 노드 / 요소 노드가 모두 반환될 수 있다. |
| Node.prototype.lastChild | 마지막 자식 노드를 반환한다. 텍스트 노드 / 요소 노드가 모두 반환될 수 있다. |
| Element.prototype.firstElementChild | 첫번째 자식 요소 노드를 반환한다. |
| Element.prototype.lastElementChild | 마지막 자식 요소 노드를 반환한다. |

### 39.3.3 자식 노드 존재 확인

`Node.prototype.hasChildNodes` 메서드를 통해 자식 노드가 존재하는지 확인할 수 있다. 텍스트 노드를 포함해서 자식 노드의 존재를 확인한다. 요소 노드만 확인하려면 `children.length` 또는 Element 인터페이스의 `childElementCount` 프로퍼티를 사용한다.

```jsx
const $fruits = document.getElementById('fruits');

console.log($fruits.hasChildNodes());
console.log($fruits.children.length);
console.log($fruits.childElementCount);
```

### 39.3.4 요소 노드의 텍스트 노드 탐색

`firstChild` 프로퍼티로 접근할 수 있다.

### 39.3.5 부모 노드 탐색

`Node.prototype.parentNode` 프로퍼티를 사용한다. 텍스트 노드는 DOM 트리의 최하위 노드인 리프 노드이므로 부모 노드가 텍스트 노드인 경우는 없다.

### 39.3.6 형제 노드 탐색

| 프로퍼티 | 설명 |
| --- | --- |
| Node.prototype.previousSibling | 형제 노드 중 자신의 이전 형제 노드를 반환한다. |
| Node.prototype.nextSibling | 형제 노드 중 자신의 다음 형제 노드를 반환한다. |
| Element.prototype.previousElementSibling | 형제 노드 중 자신의 이전 형제 노드를 반환한다. 요소 노드만 반환한다. |
| Element.prototype.nextElementSibling | 형제 노드 중 자신의 다음 형제 노드를 반환한다. 요소 노드만 반환한다. |

## 39.4 노드 정보 취득

노드 객체에 대한 정보를 취득하려면 다음과 같은 노드 정보 프로퍼티를 사용한다.

| 프로퍼티 | 설명 |
| --- | --- |
| Node.prototype.nodeType | 노드 타입을 나타내는 상수를 반환한다. |
| Node.prototype.nodeName | 노드 이름을 문자열로 반환한다. |

---

# 2일차

## 39.5 요소 노드의 텍스트 조작

### 39.5.1 nodeValue

이전까지 알아본 노드 탐색, 노드 정보 프로퍼티는 모두 읽기 전용이었다. 그에 비해 `Node.prototype.nodeValue` 프로퍼티는 setter와 getter 모두 존재하는 접근자 프로퍼티다.

노드 객체의 nodeValue 프로퍼티를 참조하면 텍스트 노드의 텍스트만을 반환한다. 다른 노드 객체의 경우 null을 반환한다. 따라서 텍스트 노드의 nodeValue 프로퍼티에 값을 할당하는 것으로 텍스트를 변경할 수 있다.

### 39.5.2 textContext

`Node.prototype.textContext` 프로퍼티는 요소 노드의 텍스트와 모든 자손 노드의 텍스트를 모두 취득하거나 변경할 수 있는 프로퍼티다. 요소 노드의 시작 태그와 종료 태그 사이의 모든 텍스트를 반환한다. 

textContext 프로퍼티와 유사한 동작을 하는 innerText 프로퍼티가 있지만, 다음과 같은 이유로 사용하지 않는 것이 좋다.

- innerText 프로퍼티는 CSS에 순종적이다. `visibility: hidden;` 과 같은 CSS에 의해 비표시된 요소 노드의 텍스트를 반환하지 않는다.
- CSS를 고려해야 하기 때문에 textContext 프로퍼티보다 느리다.

## 39.6 DOM 조작

새로운 노드를 생성하여 DOM에 추가하거나 기존 노드를 삭제 또는 교체하는 일련의 과정을 DOM 조작이라 한다. DOM 조작에 의해 새로운 노드가 추가되거나 삭제되면 리플로우와 리페인트가 발생하여 성능에 영향을 주게 된다. 

### 39.6.1 innerHTML

`Element.prototype.innerHTML` 프로퍼티는 요소 노드의 HTML 마크업을 취득하거나 변경한다. 요소 노드의 innerHTML 프로퍼티를 참조하면 요소 노드의 시작 태그와 종료 태그 사이에 포함된 모든 HTML 마크업을 문자열로 반환한다.

요소 노드의 innerHTML 프로퍼티에 할당한 HTML 마크업 문자열은 렌더링 엔진에 의해 파싱되어 요소 노드의 자식으로 DOM에 반영된다. 이 때 사용자로부터 입력받은 데이터를 그대로 innerHTML 프로퍼티에 할당하는 것은 **크로스 사이트 스크립팅 공격**에 취약하므로 위험하다. HTML 마크업 내에 자바스크립트 악성 코드가 포함되어 있다면 파싱 과정에서 그대로 실행될 우려가 있기 때문이다.

### 39.6.2 insertAdjacentHTML

`Element.prototype.insertAdjacentHTML(position, DOMString)` 메서드는 기존 요소를 제거하지 않으면서 새로운 위치를 지정해 새 요소를 삽입한다.

두 번째 인수(DOMString)로 전달받은 HTML 마크업 문자열을 파싱하고, 그 결과로 생성된 노드를 첫 번째 인수로 전달받은 위치(position)에 삽입하여 DOM에 반영한다. 기존 요소에는 영향을 주지 않고 새롭게 삽입될 요소만을 파싱하여 자식 요소로 추가하기 때문에 더 효율적이고 빠르다.

### 39.6.3 노드 생성과 추가

노드 생성 및 추가를 위한 다음과 같은 메서드가 존재한다.

| Document.prototype.createElement(tagName) | 요소 노드 생성 |
| --- | --- |
| Document.prototype.createTextNode(text) | 텍스트 노드 생성 |
| Node.prototype.appendChild(childNode) | 텍스트 노드를 요소 노드의 자식 노드로 추가 |

### 39.6.7 노드 복사

`Node.prototype.cloneNode([deep: true | false])` 메서드는 노드의 사본을 생성하여 반환한다. deep 매개변수는 깊은 복사를 할지 얕은 복사를 할지 결정하는 역할을 한다.

### 39.6.8 노드 교체

`Node.prototype.replaceChild(newChild, oldChild)` 메서드는 자신을 호출한 노드의 자식 노드를 다른 노드로 교체한다. oldChild 노드는 DOM에서 제거된다.

### 39.6.9 노드 삭제

`Node.prototype.removeChild(child)` 메서드는 child 매개변수에 인수로 전달한 노드를 DOM에서 삭제한다. 인수로 전달한 노드는 removeChild 메서드를 호출한 노드의 자식 노드여야 한다.

## 39.7 어트리뷰트

### 39.7.1 어트리뷰트 노드와 attributes 프로퍼티

HTML 요소는 여러개의 어트리뷰트(속성)를 가질 수 있다. HTML 요소의 동작을 제어하기 위한 HTML 어트리뷰트는 시작 태그에 `어트리뷰트 이름 = "어트리뷰트 값"` 형식으로 정의한다.

글로벌 어트리뷰트(id, class, style, title, lang 등)와 이벤트 핸들러 어트리뷰트(onclick, onchange, onfocus, onblur, oninput 등)는 모든 HTML 요소에서 공통적으로 사용할 수 있지만 type, value, checked와 같이 특정 요소에서만 사용가능한 어트리뷰트도 있다.

모든 어트리뷰트 노드의 참조는 유사 배열 객체이자 이터러블인 NamedNodeMap 객체에 담겨서 요소 노드의 attributes 프로퍼티에 저장된다.

따라서 요소 노드의 모든 어트리뷰트 노드는 요소 노드의 `Element.prototype.attributes` 프로퍼티로 취득이 가능하다. 

### 39.7.2 HTML 어트리뷰트 조작

attributes 프로퍼티는 읽기 전용이기 때문에 어트리뷰트 값의 변경이 불가하다. `Element.prototype.getAttribute/setAttribute` 메서드를 사용하면 프로퍼티를 통하지 않고 요소 노드에서 메서드를 통해 직접 HTML 어트리뷰트를 조작할 수 있다.

특정 어트리뷰트가 존재하는지 확인하기 위한 hasAttribute, 삭제하기 위한 removeAttribute도 참고하자.

### 39.7.3 HTML 어트리뷰트 vs DOM 프로퍼티

요소 노드 객체에는 HTML 어트리뷰트에 대응하는 DOM 프로퍼티가 존재한다. 이 DOM 프로퍼티들은 HTML 어트리뷰트를 초기값으로 갖는다. 그렇다면 그 차이점은 무엇일까?

HTML 어트리뷰트는 HTML 요소의 초기 상태를 지정하는 역할을 한다. 이는 변하지 않는다는 것을 의미힌다.

하지만 첫 렌더링 이후 사용자가 무언가 입력을 한다면 **상태(state)**가 변경된다. 요소 노드는 이 상태를 항상 최신으로 관리하면서, 동시에 HTML 어트리뷰트로 지정한 초기 상태 또한 관리해야 한다. 정리하자면, 요소 노드의 초기 상태는 어트리뷰트 노드가 관리하며, 최신 상태는 DOM 프로퍼티가 관리한다.

## 39.8 스타일

### 39.8.1 인라인 스타일 조작

`HTMLElement.prototype.style` 프로퍼티는 요소 노드의 인라인 스타일을 취득하거나 조작한다. style 프로퍼티를 참조하면 CSSStyleDeclaration 타입의 객체를 반환하는데, 이는 다양한 CSS 프로퍼티에 대응하는 프로퍼티를 가지고 있다.

### 39.8.2 클래스 조작

.으로 시작하는 클래스 선택자를 사용하여 CSS class를 미리 정의한 다음, HTML 요소의 class 어트리뷰트 값을 변경하여 HTML 요소의 스타일을 변경할 수도 있다. 이때 HTML 요소의 class 어트리뷰트를 조작하려면 이에 대응하는 요소 노드의 DOM 프로퍼티를 사용한다.

`Element.prototype.className` 프로퍼티는 HTML 요소의 class 어트리뷰트 값을 취득하거나 변경한다.

`Element.prototype.classList` 프로퍼티는 class 어트리뷰트의 정보를 담은 DOMTokenList 객체를 반환한다. DOMTokenList는 다음과 같은 메서드를 제공한다.

- add(…className) : 전달한 문자열을 class 어트리뷰트 값으로 추가한다.
- remove(…className) : 전달한 문자열과 일치하는 클래스를 class 어트리뷰트에서 삭제한다.
- item(index) : 인수로 전달한 index에 해당하는 클래스를 반환한다.
- contains(className) : 전달한 문자열과 일치하는 클래스가 포함되어 있는지 확인한다.
- replace(oldClassName, newClassName) : oldClassName 문자열을 newClassName 문자열로 변경한다.
- toggle(className[, force]) : 전달한 문자열과 일치하는 클래스가 존재하면 제거하고, 아니면 추가한다. 두번째 인수로 boolean값으로 평가되는 조건식을 전달할 수 있는데, true면 강제로 추가, false면 강제로 제거가 된다.

### 39.8.3 요소에 적용되어 있는 CSS 스타일 참조

style 프로퍼티는 인라인 스타일만 반환한다. HTML 요소에 적용되어 있는 모든 CSS 스타일을 참조하려면 getComputedStyle 메서드를 사용한다.