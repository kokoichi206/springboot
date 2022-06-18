### Spring Initializer
- Spring Web
    - Spring MVC
    - Jackson
    - etc...
    - ルーティングなど、Web アプリケーションのサーバーサイドプログラムで必要な機能を提供する starter
- Thymeleaf
    - HTML など Web ページの作成で使用
    - テンプレートエンジンを使用するための starter

### Annotations
- RestController
  - Response object を JSON にシリアライズ

### Spring
- プライマリコンストラクタで定義された型には勝手に DI
  - Spring Framework で DI したオブジェクトはシングルトンになる
- Interface に対する実装クラスに「InterfaceName + Impl」
  - 実装クラスには `@Component` アノテーションが付く
    - DI の対象であることを表す
- DI の方法には色々あるが、基本的にはコンストラクタインジェクションを使う

### Commands
``` sh
$ curl http://localhost:8080/greeter/hello?name=Ore
```
