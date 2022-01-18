

package controllers
import akka.util.ByteString

import models.{UserItem, UserRepository}
import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec

import play.api.libs.json.JsValue
import play.api.libs.streams.Accumulator
import play.api.mvc.{AnyContent, Result, Results}
import play.api.test.{FakeRequest, Helpers}
import play.api.test.Helpers.{contentAsJson, defaultAwaitTimeout, status}
import play.libs.Json

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

class RegisterControllerSpec extends  PlaySpec with Results with MockitoSugar{
  "RegisterController#getById" should {
    "be valid" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("1"),"user1","12345")
      when(userRepository.getById("1")) thenReturn Future(Option(defaultUser))
      val controller = new RegisterController(userRepository,Helpers.stubControllerComponents())
      val result: Future[Result] = controller.getById("1").apply(FakeRequest())
      val userJson: JsValue = contentAsJson(result)
      userJson.equals(Json.toJson(defaultUser))
    }
  }
  "RegisterController#getAll" should {
    "be valid" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("2"),"user2","12345")
      when(userRepository.getAll) thenReturn Future(Seq(defaultUser))
      val controller = new RegisterController(userRepository,Helpers.stubControllerComponents())
      val result: Future[Result] = controller.getAll.apply(FakeRequest())
      val userJson: JsValue = contentAsJson(result)
      userJson.equals(Json.toJson(defaultUser))
    }
  }
  "RegisterController#delete" should {
    "be valid" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("3"),"user3","12345")
      when(userRepository.delete("3")) thenReturn Future(1)
      val controller = new RegisterController(userRepository,Helpers.stubControllerComponents())
      val result: Future[Result] = controller.delete("3").apply(FakeRequest())
      val userJson: JsValue = contentAsJson(result)
      userJson.equals(1)
    }
  }

  "RegisterController#addNewUser" should {
    "be valid" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("3"),"user3","12345")

      when(userRepository.add(defaultUser)) thenReturn Future(1)

      val controller = new RegisterController(userRepository,Helpers.stubControllerComponents())
      //when (controller.addNewUser) thenReturn Future()
      println(controller.addNewUser.apply(FakeRequest()))
     val result: Accumulator[ByteString, Result] =controller.addNewUser.apply(FakeRequest())
       result.equals(Ok)
      //val userJson: JsValue = contentAsJson(result)


    }
  }
  "RegisterController#update" should {
    "be valid" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("3"),"user3","12345")

      when(userRepository.update("3","user3","abcd") )thenReturn Future(1)

      val controller = new RegisterController(userRepository,Helpers.stubControllerComponents())
      //when (controller.addNewUser) thenReturn Future()
      println(controller.addNewUser.apply(FakeRequest()))
      val result: Accumulator[ByteString, Result] =controller.addNewUser.apply(FakeRequest())
      result.equals(Ok)
      //val userJson: JsValue = contentAsJson(result)


    }
  }
}