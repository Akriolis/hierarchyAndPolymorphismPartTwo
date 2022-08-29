abstract class Appliance{
    var pluggedIn = true
    abstract val color: String

    abstract fun consumePower()

}

class CoffeeMaker(var brand: String, var powerInWatt: Int): Appliance(){
    override val color = ""
    var coffeeLeft = false
    override fun consumePower(){
        println("Consuming power")
    }

    fun fillWithWater(){
        println("Fill with water")
    }

    fun makeCoffee(){
        println("Make the coffee")
    }

    fun brandCheck(){
        println("The coffeemaker brand is $brand")
    }

    fun powerCheck(){
        println("The coffeemaker power is $powerInWatt W")
    }

}

fun main(){
    var x = CoffeeMaker("Bosch", 750)
    x.brandCheck()
    x.powerCheck()
}
