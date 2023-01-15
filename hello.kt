import java.time.LocalDateTime
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.thread
import kotlin.concurrent.withLock
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>) {
//	println("Hello, world ! ")
//	println(args.contentToString() ) // 大文字変換

//	kata() // 
//	print() // 
//	kata04() // 型を指定しない関数呼び出し
//	testFunc(1, 'c', "S")
//	calcu()
//	testArray()
//	testList()
//	testSet()
//	testMap()
//	testRange()
//	testAdd01()
//	testEnum()
//	testDataClass()
//	testDataClassList()
//	testNull()
//	testTimer01()
//	testTimer02()
	testTimer03()
}

fun testTimer03() {
	var now: LocalDateTime

	Timer().scheduleAtFixedRate(0, 1000) {
//		println(LocalDateTime.now().getHour().toString() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond())
		println(LocalDateTime.now().getMinute())
	}

}

// https://flytech.work/blog/11832/
// https://taro.hatenablog.jp/entry/2013/08/01/223323
fun testTimer02() {
	var totalMin = 5
//	var dispSecond = 0
	val lock = java.util.concurrent.locks.ReentrantLock()

	var now: LocalDateTime

	println("開始　" + LocalDateTime.now())

//	(1..totalMin).forEach {
	for (i in 1..totalMin) {
//		dispSecond = 1
		thread {
			lock.withLock {
				now = LocalDateTime.now()
//				println("$dispSecond 秒 " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond())
				println("$i 秒 " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond())
//				dispSecond++
				Thread.sleep(1000)
			}
		}
	}

	println("終了　" + LocalDateTime.now())
}

fun testTimer01() {
	println("開始　" + LocalDateTime.now())

	Timer().schedule(1000) {
		println("今何時？" + LocalDateTime.now())
	}

	println("終了　" + LocalDateTime.now())
}

fun testNull() {
	val s = fooTestNull()
	val l = s.length
	println(l)

	val sNull: String? = fooTestNull02() // メソッド宣言も受け側もnull許容でないとエラー
}

fun fooTestNull02(): String? {
	return null
}

fun fooTestNull(): String {
//	return null // 	この時点でコンパイルエラーnull許容ではないから
	return "ABC"
}

data class Person(var name: String? = null, var age: Int = 0)

fun testDataClassList() {
	var names: MutableList<Person> =
		mutableListOf(
			Person("AA", 10),
			Person("BB", 9),
			Person("CC", 8),
		)

	names.forEach { value ->
		println(value)
	}
}

fun testDataClass() {
	var person = Person("Tom", 22)
	println(person)

	person = Person("Cat", 10)
	println(person)
	println(person.name)
}

enum class Direction {
	NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: String) {
	RED("#f00"),
	GREEN("#0f0"),
	BLUE("#00f"),
}

fun testEnum() {
	println(Direction.NORTH)    // NORTH
	println(Color.RED)        // RED
	println(Color.RED.name)    // RED
	println(Color.RED.rgb)    // #f00
}


fun testAdd00(x: Int, y: Int): Int = x + y
fun testAdd01() {
	val method = ::testAdd00
	println(method(3, 5))
}

fun testRange() {
	for (i in 2..6) println(i)
}

fun testMap() {
	var map = mapOf("空" to "青", "葉っぱ" to "緑", "イチゴ" to "赤")
	println(map)

	println("\n")

	for ((key, value) in map) {
		println("$key == $value")
	}
}

fun testSet() {
	var s = mutableSetOf("Red", "Green", "Blue")
	s.add("red")
	println(s)

	s.forEach { value -> println(value) }

	s.forEachIndexed { index, value -> println("${index} == ${value}") }

}

fun testList() {
	var nums = listOf(1, 2, 3)
	var cols = listOf("Red", "Green", "Blue")

	//リストの内容は変更出来ない
	//	cols[1] = "Yellow" // エラー

}

fun testArray() {
	var nums = arrayOf(1, 2, 3)
	var cols = arrayOf("Red", "Green", "Blue")

	// 配列の内容は変更出来る
	cols[1] = "Yellow"

	for (n in nums) {
		println(n)
	}
	println("\n")
	for (c in cols) {
		println(c)
	}
}

fun calcu() {
	var a = 3
	var b = 9
//	println("$a + $b = ${add(a, b)}")
	println("$a + $b = ${a + b}")

	println(sum(4, 9))
//	println($sum(4, 9)) // エラー
//	println(${sum(4, 9)}) // エラー

}

fun sum(a: Int, b: Int) = a + b

fun testFunc(i: Int, c: Char, s: String): Int {
	println(i)
	println(c)
	println(s)

	return i + 5
}


fun kata04() {
	kata03("AAA")
	kata03(123)
	kata03('C')
	kata03(123.toString())
}

fun kata03(arg: Any?) {
	when (arg) {
		is Int -> println("Is Int $arg")
		is Char -> println("Is Char $arg")
		is String -> println("Is String $arg")
	}
}


fun print() {
	var yourName: String = "Kanaria"
	println("あなたのお名前は　${yourName}")

	var i: Int = 5
	println("値段 ${i} 円")

	i++
	println("一円足し　 ${i} 円")

	i--
	println("からの一円引き ${i} 円")
}

fun kata() {
	var i: Int = 0
	var langName: String = "Kotolin"
	var d: Double = 6.234
	println(langName.toUpperCase())
	println(i)
	println(d)

	var testName: String? = null

	println(100 * 1.08)

	println("値段は　${100 + 10}")
}

fun kata02() {
	val MAX_COUNT: Int = 30

//	MAX_COUNT = 5 // コンパイルエラー	
}
