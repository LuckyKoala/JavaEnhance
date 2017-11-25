package tech.zuosi.kotlinenhance

/**
 * Created by iwar on 2017/7/20.
 */

data class Person(val name: String) {

}

class Yo(val name: String) {
    fun greet() {
        println("Hello, $name")
    }
}

//fun Yo.extra(value: Int):Boolean = value==1

//String Interpolation to cut down ceremony.
/*
fun main(args: Array<String>) {
    val yo = Yo("LuckyKoala")
    if(yo.extra(1)) print("2") else print("3")
}*/
