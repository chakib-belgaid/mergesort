//first 20 instances :[0 0 1 26 27 10 199 194 10 605 704 0 230 809 51 947 756 371 542 704]
// the sorted array   [0 0 0 1 10 10 26 27 51 194 199 230 371 542 605 704 704 756 809 947]

use std::f32;

fn custom_random(n: i32) -> i32 {
	const  MAXI:i32 =1000000;// 2147483647 ; //std::i32::MAX;
	let x :f32 = n as f32;
	return ((x * x * x *x.cos() * x.cos() )as i32 )  % MAXI;
}


fn main() {
	let n = std::env::args_os()
		.nth(1)
		.and_then(|s| s.into_string().ok())
		.and_then(|n| n.parse().ok())
		.unwrap_or(100)  ;
	let niters = std::env::args_os()
		.nth(2)
		.and_then(|s| s.into_string().ok())
		.and_then(|n| n.parse().ok())
		.unwrap_or(1)  ;
	for _ in 0..niters {
		let mut a :Vec<i32>= Vec::new() ;
		for i in 0..n {
			a.push( custom_random(i as i32)); 
		}
		//println!("{:?}",a);
		merge_sort_rec(a.as_mut_slice());
		//println!("{:?}",a);
	}
}

fn merge(x1: &[i32], x2: &[i32], y: &mut [i32]) {
	assert_eq!(x1.len() + x2.len(), y.len());
	let mut i = 0;
	let mut j = 0;
	let mut k = 0;
	while i < x1.len() && j < x2.len() {
		if x1[i] < x2[j] {
			y[k] = x1[i];
			k += 1;
			i += 1;
		} else {
			y[k] = x2[j];
			k += 1;
			j += 1;
		}
	}
	if i < x1.len() {
		y[k..].copy_from_slice(&x1[i..]);
	}
	if j < x2.len() {
		y[k..].copy_from_slice(&x2[j..]);
	}
}

fn merge_sort_rec(x: &mut [i32]) {
	let n = x.len();
	let m = n / 2;

	if n <= 1 {
		return;
	}

	merge_sort_rec(&mut x[0..m]);
	merge_sort_rec(&mut x[m..n]);

	let mut y: Vec<i32> = x.to_vec();

	merge(&x[0..m], &x[m..n], &mut y[..]);

	x.copy_from_slice(&y);
}
