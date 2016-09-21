package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/22.
  */
object CreateCollectionBaseType extends App{

  //create a few instances
  import section06._

  val kirk = new Officer with Captain
  val spock = new Officer with FirstOfficer
  val bones = new Officer with ShipsDoctor

  // create a collection of officers on a ship
  val officers = new Crew[Officer]()
  officers += kirk
  officers += spock
  officers += bones


  // those who are of type RedShirt won’t be allowed in the collection,
  //because they don’t extend Officer
  val redShirt = new RedShirt
  //officers += redShirt // ERROR: this won't compile


  //It also prevents you from writing code like this,
  // because String does not extend CrewMember
  // error: won't compile
  //val officers = new Crew[String]()

  //In addition to creating a collection of officers,
  //you can create a collection of RedShirts, if desired.
  val redshirts = new Crew[RedShirt]()

  //Discussion

  val kirk2 = new Officer with Captain with StarfleetTrained
  val spock2 = new Officer with FirstOfficer with StarfleetTrained
  val bones2 = new Officer with ShipsDoctor with StarfleetTrained

  val officers2 = new Crew2[Officer with StarfleetTrained]()
  officers2 += kirk2
  officers2 += spock2
  officers2 += bones2

  val kirk3 = new StarfleetOfficer with Captain
  officers2 += kirk3

  //Methods

  //With this behavior, you can write methods to work specifically on their types.
  // This method works for any CrewMember
  def beamDown[A <: CrewMember2](crewMember: Crew3[A]) {
    crewMember.foreach(_.beamDown)
  }

  //But this method will only work for RedShirt types
  def getReadyForDay[A <: RedShirt2](redShirt: Crew3[A]) {
    redShirt.foreach(_.putOnRedShirt)
  }

}


package section06{

  import scala.collection.mutable.ArrayBuffer

  //create a simple type hierarchy
  trait CrewMember

  class Officer extends CrewMember

  class RedShirt extends CrewMember

  trait Captain
  trait FirstOfficer
  trait ShipsDoctor

  trait StarfleetTrained

  //define it with an upper bound while extending ArrayBuffer
  class Crew[A <: CrewMember] extends ArrayBuffer[A]


  class Crew2[A <: CrewMember with StarfleetTrained] extends ArrayBuffer[A]
  //define a new StarfleetOfficer
  class StarfleetOfficer extends Officer with StarfleetTrained


  trait CrewMember2 {
    def beamDown { println("beaming down") }
  }
  class RedShirt2 extends CrewMember2 {
    def putOnRedShirt { println("putting on my red shirt") }
  }

  class Crew3[A <: CrewMember2] extends ArrayBuffer[A]
}

