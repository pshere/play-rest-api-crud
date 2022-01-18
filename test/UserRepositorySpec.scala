
import models.{UserItem, UserRepository}
import org.mockito.Mockito.when
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class UserRepositorySpec extends PlaySpec with MockitoSugar {

  "UserRepository#getById" should {
    "be true when the ID is provided" in {
      val userRepository = mock[UserRepository]
      val defaultUser = UserItem(Some("1"),"user1","12345")
      when(userRepository.getById("1")) thenReturn Future(Option(defaultUser))


      val actual = userRepository.getById("1")
      actual.equals(defaultUser)
    }
  }
  "UserRepository#getAll" should {
   "be true when getAll method is called" in {
     val userRepository = mock[UserRepository]
    val defaultUser = UserItem(Some("2"),"user2","12345")
      when(userRepository.getAll) thenReturn Future(Seq(defaultUser))

     val actual = userRepository.getAll
     actual.equals(Future(Seq(Some("2"),"user2","12345")))
    }
  }
  "UserRepository#delete" should {
    "be true when the ID is provided" in {
     val userRepository = mock[UserRepository]

      when(userRepository.delete("3")) thenReturn Future(1)

     val actual = userRepository.delete("3")
   actual.equals(Future(1))
    }
 }
  "UserRepository#update" should {
   "be true when the user is provided" in {
      val userRepository = mock[UserRepository]

     when(userRepository.update("4","user4","12345")) thenReturn Future(1)

     val actual = userRepository.update("4","user4","12345")
      actual.equals(Future(1))
   }
  }
 "UserService#add" should {
    "be true when the UserItem is provided" in {
     val userRepository = mock[UserRepository]
     val defaultUser = UserItem(Some("5"),"user4","12345")
     when(userRepository.add(defaultUser)) thenReturn Future(1)
      val actual = userRepository.add(defaultUser)
     actual.equals(Future(1))
    }
  }

}
