<?php function mergesort($arr){
	if(count($arr) == 1 ) return $arr;
	$mid = count($arr) / 2;
    $left = array_slice($arr, 0, $mid);
    $right = array_slice($arr, $mid);
	$left = mergesort($left);
	$right = mergesort($right);
	return merge($left, $right);
}
 
function merge($left, $right){
	$res = array();
	while (count($left) > 0 && count($right) > 0){
		if($left[0] > $right[0]){
			$res[] = $right[0];
			$right = array_slice($right , 1);
		}else{
			$res[] = $left[0];
			$left = array_slice($left, 1);
		}
	}
	while (count($left) > 0){
		$res[] = $left[0];
		$left = array_slice($left, 1);
	}
	while (count($right) > 0){
		$res[] = $right[0];
		$right = array_slice($right, 1);
	}
	return $res;
}
 
function customRandom($x)
{ $MAXI = 1000000 ; 
    return (floor($x*$x*$x*cos($x)*cos($x))) % $MAXI ;    

}

$n = ($argc > 1 ) ? $argv[1] : 100 ; 
$niters = ($argc > 2 ) ? $argv[2] : 1 ;  
for ($iter=0;$iter < $niters ;$iter++) {
	$arr = [] ; 
	for ($i=0; $i < $n ; $i++) {
	    $arr[$i]= customRandom($i);  
	
	}


	//echo implode(' ',$arr); echo "\n" ;
	$arr = mergesort($arr);
	//echo implode(' ',$arr); echo "\n" ;
}
?>