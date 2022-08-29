import kotlin.random.Random

//It's impossible to create any object of Animal class because class is abstract
//A class that's not abstract is called concrete
//An abstract class can have abstract properties and functions
//Abstract properties and functions don't need to be marked as open
//An interface lets you define common behavior outside a superclass hierarchy
//A class can implement multiple interfaces, but can only inherit from a single direct superclass
//Interfaces can't have constructors
//Interface properties don't have backing fields
//Interfaces: A, B. class X: A,B {}
//Class C. class Y: C(), A, B {}
//Interfaces specify behavior so they are naming with -ible and -able
//Interface can implement other interfaces

interface Roamable{
    fun roam(){
        println("The roamable is roaming")
    }
}

/*interface Walkable: Roamable{
     override fun roam() {
         println("The walkable is walking")
     }
 }*/

abstract class Animal: Roamable{
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()

    //You can't add function body in abstract fun

    abstract fun eat()

    //You have to mark class as abstract if you have marked any of its
    //function or property abstract

    abstract fun weight()

    abstract fun name()

    override fun roam(){
        println("The animal is roaming")
    }

    fun sleep(){
        println("The animal is sleeping")
    }
}

class Hippo: Animal(){
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat (){
        println("The Hippo is eating $food")
    }

    override fun weight() {
        println("Weight of the hippo is huge")
    }

    override fun name() {
        println("Hippo has no name")
    }
}

abstract class Canine (var breed: String): Animal(){
    override fun roam() {
        println("The canine is roaming")
    }
}

class Wolf(var breed_param: String, var name: String, var weight: Int): Canine(breed_param){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Auuuf!")
    }

    override fun eat(){
        println("The wolf is eating $food")
    }

    override fun name(){
        println("Name of the wolf is $name")
    }

    override fun weight() {
        println("Weight of the wolf is $weight")
    }

}

abstract class Feline (var breed: String): Animal(){
    override fun roam(){
        println("The feline is roaming")
    }
}

class Cheetah (var breed_param: String, var name: String, var weight: Int): Feline (breed_param){
    override val image = "cheetah.jpg"
    override val food = "meat"
    override val habitat = "savanna"

    override fun makeNoise() {
        println("MEOW!")
    }

    override fun eat(){
        println("The cheetah is eating $food")
    }

    override fun name(){
        println("Name of the cheetah is $name")
    }

    override fun weight (){
        println("Weight of the cheetah is $weight")
    }
}

class Vehicle: Roamable{
    override fun roam(){
        println("The Vehicle is roaming")
    }
}

class Vet {
    fun giveShot (x: Animal){
        x.makeNoise()
    }
}

fun main(){
    val animals = arrayOf(Hippo(), Wolf("Gray wolf", "Zizi", 30),
        Cheetah("Northwest African", "Biba", 25))
    for (x in animals){
        x.roam()
        x.eat()
        x.makeNoise()
        x.name()
        x.weight()
    }
    var x = animals[1]
    x.roam()

    val testRoambles: Array<Roamable> = arrayOf(Hippo(), animals[2], Vehicle())
    for (x in testRoambles){
        x.roam()
        if (x is Cheetah){
            x.eat()
            val stringCheck = if (x is Wolf) "Wolf" else "not Wolf"
            println(stringCheck)
        }
        //is operator performs a smart cast
        if (x is Wolf){
            println(x.name)
            x.makeNoise()
        }
        //as operator for explicit cast
        //var xyz = x as Cheetah
        //xyz.makeNoise()
        /* if (x is Wolf){
            val xyz = x as Wolf
            xyz.eat()
        }*/


    //if variable type would be changed (example - Animal) code will not compile.
    }

    val animal: Animal = Wolf("Gray", "Ivan", 15)
    if (animal is Wolf) {
        animal.makeNoise()
    }
//Is operator check if underlying object is the specified type
    //also && and || can be used
    // if (testRoambles is Animal) && testRoambles.hunger < 5){
// }
    //if (testRoambles !is Animal || x.hunger >= 5){
// }
    //and while loop
    // while (animal is Wolf){
// }


    //When statement
    var u = Random.nextInt()
    when (u) {
        0 -> println("$u is zero")
        1,2 -> println("$u is 1 or 2")
        else -> {
            println("$u is neiher 0, 1 nor 2")
            println("$u is some other value")
        }
    }
    //examples
    //when (x){
// is Wolf ->
// }


    var whenTest = when (u){
        0 -> true
        else -> false
    }
    //return value can be used and stored



}

