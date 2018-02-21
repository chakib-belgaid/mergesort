package main

import (
	"flag"
	"math"
	"strconv"
)

//first 20 instances :[0 0 1 26 27 10 199 194 10 605 704 0 230 809 51 947 756 371 542 704]
// the sorted array   [0 0 0 1 10 10 26 27 51 194 199 230 371 542 605 704 704 756 809 947]

func main() {
	var n = 100
	var niters = 1
	flag.Parse()
	if flag.NArg() > 0 {
		n, _ = strconv.Atoi(flag.Arg(0))
		if flag.NArg() > 1 {
			niters, _ = strconv.Atoi(flag.Arg(1))
		}
	}
	for iter := 0; iter < niters; iter++ {

		var a = make([]int, n)
		var s = make([]int, n/2+1) // scratch space for merge step
		for i := 0; i < n; i++ {
			a[i] = customRandom(i)
		}
		//fmt.Println(a)
		mergeSort(a, s)
		//fmt.Println(a)

	}
}

func customRandom(n int) int {
	x := float64(n)
	MAXI := 1000000 //2147483647

	return int(x*x*x*math.Cos(x)*math.Cos(x)) % MAXI
}

func mergeSort(a, s []int) {
	if len(a) < 2 {
		return
	}
	mid := len(a) / 2
	mergeSort(a[:mid], s)
	mergeSort(a[mid:], s)
	if a[mid-1] <= a[mid] {
		return
	}
	// merge step, with the copy-half optimization
	copy(s, a[:mid])
	l, r := 0, mid
	for i := 0; ; i++ {
		if s[l] <= a[r] {
			a[i] = s[l]
			l++
			if l == mid {
				break
			}
		} else {
			a[i] = a[r]
			r++
			if r == len(a) {
				copy(a[i+1:], s[l:mid])
				break
			}
		}
	}
	return
}
