## Kotlin

### クラス
- 継承を制限する機能である、シールドクラス
  - **他ファイル**のクラスからの継承ができなくなる
- 継承させたいクラスには、open という演算子が必要

### コレクション
- List
- Map
- Set

### 変数
- val の定義は getter のみ生成！
- 遅延初期化プロパティ
  - 呼び出す段階で値が格納されてないと実行時エラー
  - 結構危険な気がする、せっかく null 安全にしたのに
  - nullable の変数定義になるってわけでもないのがやばい？
- 拡張プロパティ
  - getter, setter の処理を拡張
  - 下の例だとメソッドにしてしまいそうだけど、このほうが kotlin ぽいのかな？

``` kotlin
class User {
    lateinit var name: String
    val isValidName: Boolean
        get() = name != ""
}
```

### データクラス
- 以下のボイラープレートを削除
  - equals
  - hashCode
  - toString
- componentN
  - 順番を指定してプロパティの値を取得したい場合、Nの部分にはプロパティの順番が入る
- copy
  - 新しいインスタンスを生成
  - 任意のプロパティの値を変更可
- 拡張プロパティ追加可

### いろいろ
- 関数型
  - 関数リテラル
  - ラムダ式
- 高階関数
- タイプエイリアス

``` kotlin
val cals: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
val squared: (Int) -> Int = { it * it }
// 無名関数
val squared: (Int) -> Int = fun(num: Int): Int { return num * num }

fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1, num2)
    println(result)
}
printCalcResult(10, 20, { num1, num2 -> num1 + num2 })

typealias Calc = (Int, Int) -> Int
```

### 拡張関数
``` kotlin
fun Int.square(): Int = this * this

fun main() {
    println(2.square())
}
```

### スコープ関数
- with
  - 複数の処理をまとめて
- run
  - Nullable のオブジェクトを扱うのに便利だ
- let
  - this 以外の名前づけ可
- apply
  - run, let と違ってレシーバオブジェクトそのものを返却す
- also
  - 名前をつけて扱う

### 演算子オーバーロード
- plus, minus, times, div
- 比較演算子などのさまざまな演算子も可能
- どういう時に使いたくなる？

``` kotlin
data class Num(val value: Int) {
    operator fun plus(num: Num): Num {
        return Num(value + num.value)
    }
}

val num = Num(5) + Num(1)
```

### 委譲！
- なんとなく分かった...
  - Interface, 共通実装, それを extends した実装、みたいなケース？
- by 委譲先

``` kotlin
class AddCalculationExecutorDelegate(
    private val calculationExecutor: CalculationExecutor
) : CalculationExecutor by calculationExecutor {
    //
}
```

### コレクションライブラリの充実
- [api](https://kotlinlang.org/api/latest/jvm/stdlib/)
  - [collections](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/)
  - [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/)
- forEach
- map
- filter
- first, last
- firstOrNull, lastOrNull
- associateBy, associateWith
- chunked !
- reduce

