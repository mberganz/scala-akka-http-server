// akka
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
// akka http
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
// spray (JSON)
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport.*
import spray.json.DefaultJsonProtocol.*
// Cross Origin Resource Sharing (CORS)
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.*

final case class User(id: Long, name: String, email: String)

@main def httpserver: Unit =
  // var
  implicit val actorSystem = ActorSystem(Behaviors.empty, "akka-http")
  implicit val userMarshaller: spray.json.RootJsonFormat[User] = jsonFormat3(User.apply)
  
  // route getUser
  val getUser = get {
    path("user" / LongNumber) {
      userId => complete(User(userId, "TestUser", "test@test.com"))
    }
  }

  // route createUser
  val createUser = post {
    path("user") {
      entity(as[User]) {
        user => complete(user)
      }
    }
  }

  // route updateUser
  val updateUser = put {
    path("user") {
      entity(as[User]) {
        user => complete(user)
      }
    }
  }

  // route deleteUser
  val deleteUser = delete {
    path("user" / LongNumber) {
      userId => complete(User(userId, "DeleteTestUser", "test@test.com"))
    }
  }

  // merge routes
  val routes = cors() {
    concat(getUser, createUser, updateUser, deleteUser)
  }

  // bind routes to the server
  Http().newServerAt("127.0.0.1", 8080).bind(routes)