object mergesort {

def mergeSort(input: List[Int]) = {
  def merge(left: List[Int], right: List[Int]): Stream[Int] = (left, right) match {
    case (x :: xs, y :: ys) if x <= y => x #:: merge(xs, right)
    case (x :: xs, y :: ys) => y #:: merge(left, ys)
    case _ => if (left.isEmpty) right.toStream else left.toStream
  }

  
  def sort(input: List[Int], length: Int): List[Int] = input match {
    case Nil | List(_) => input
    case _ =>
      val middle = length / 2
      val (left, right) = input splitAt middle
      merge(sort(left, middle), sort(right, middle + length % 2)).toList
  }
  sort(input, input.length)
}

  def customRandom(x:Int) :Int = {
    (x*x*x*Math.cos(x)*Math.cos(x)).toInt
  }


  def main(args: Array[String]): Unit =
  {
    val n = if (args.length > 0) args(0).toInt  else 20 
    val niters = if (args.length > 1 ) args(1).toInt  else 1
    var iter = 0 
	while ( iter < niters ) {
    	var i = n-1
    	var arr = List[Int]() 
    
		while (i >= 0) {
    	  arr =  customRandom(i) :: arr
    	  i -= 1 
    	}
		arr foreach (x => print(s"$x "))
      	val arr1 = mergeSort(arr)  
		println
      	arr1 foreach (x => print(s"$x "))
		println
		iter+=1
    }
  }

}