package controllers

import models.{NewUserItem, UserItem}
import play.api.libs.json.{Json, OFormat}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}
import scala.collection.mutable

  @Singleton
class RegisterController @Inject() (val controllerComponents: ControllerComponents) extends BaseController{

    private val userItemList = new mutable.ListBuffer[UserItem]
    userItemList += UserItem(1, "Priyanka", "abc")
   userItemList += UserItem(2, "Aarya", "123")
    userItemList += UserItem(3, "Snesha", "321")
//for json formatting of each user item
implicit val userListJson: OFormat[UserItem] = Json.format[UserItem]
    implicit val newUserListJson = Json.format[NewUserItem]


    def getById(id:Int): Action[AnyContent] =Action {
      val foundUserItem = userItemList.find(_.id == id)
      foundUserItem match {
        case Some(value) => Ok(Json.toJson(value))
        case None => NotFound
      }
    }

    //for getting all content
    def getAll:Action[AnyContent]=Action{
     if(userItemList.isEmpty)
      NoContent
     else
       Ok(Json.toJson(userItemList))

    }

    def delete(id:Int):Action[AnyContent] =Action{
    val foundUserItem = userItemList.find(_.id == id)
      foundUserItem match {
        case Some(value) => userItemList -=value
          Ok(Json.toJson(userItemList))
        case None => NotFound
      }

    }

    def addNewUser = Action { implicit request =>
      val content = request.body
      val jsonObject = content.asJson
      val userItemNew: Option[NewUserItem] =
        jsonObject.flatMap(
          Json.fromJson[NewUserItem](_).asOpt
        )
      userItemNew match {
        case Some(newItem) =>
          val nextId = userItemList.map(_.id).max + 1
          val toBeAdded = UserItem(nextId, newItem.name, newItem.password)
          userItemList += toBeAdded
          Created(Json.toJson(toBeAdded))
          Ok(Json.toJson(toBeAdded))
        case None =>
          Ok(Json.toJson(userItemNew))
          BadRequest("not created")
      }
    }
def update(id:Int,changedPassword:String): Action[AnyContent] =Action{
  val foundItem=userItemList.find(_.id==id)
  foundItem match {
    case Some(value) =>
      val newValue=value.copy(password=changedPassword)
      userItemList.dropWhileInPlace(_.id==id)
      userItemList+= newValue
      Accepted(Json.toJson(userItemList))
    case None => NotFound
  }

}


  }
