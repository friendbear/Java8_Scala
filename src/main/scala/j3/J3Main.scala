package j3


/**
  * Created by kumagai on 2017/04/23.
  */
object J3Main extends App {

  val point1 = new Point(3, 2)
  val point2 = new Point(3, 2)

  println(point1)
  println(point2)
  println(point1.hashCode())
  println(point2.hashCode())
  println(point1.eq(point2))
  println(point1.toString)

  val point3 = new PointBean
  val xBean = point3.x
  val yBean = point3.y


  // Task
  val task = new Task(TaskType.PRIVATE, "buy milk")
  val taskType = task.getType

  println(TaskType.PRIVATE.equals(taskType)) // trueが帰る

  def getTaskTypeString(taskType: TaskType): String = {
    taskType match {
      case TaskType.PRIVATE => s"プライベート${TaskType.PRIVATE.getValue}"
      case TaskType.WORK => s"作業中${taskType.getValue}"
      case _ => "その他"
    }

  }
  println(getTaskTypeString(TaskType.PRIVATE))
  println(getTaskTypeString(TaskType.WORK))
  println(getTaskTypeString(TaskType.SLEEP))

  // StringStack

  val stringStack = new StringStack

  println(stringStack.pop.orElse("値がないはずだよ"))
  stringStack.push("値を詰めるよ")
  println(stringStack.pop.orElse("null"))

}
