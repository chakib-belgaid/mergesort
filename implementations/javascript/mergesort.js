function merge(left, right, arr) {
    var a = 0;

    while (left.length && right.length) {
        arr[a++] = (right[0] < left[0]) ? right.shift() : left.shift();
    }
    while (left.length) {
        arr[a++] = left.shift();
    }
    while (right.length) {
        arr[a++] = right.shift();
    }
}

function mergeSort(arr) {
    var len = arr.length;

    if (len === 1) { return; }

    var mid = Math.floor(len / 2),
        left = arr.slice(0, mid),
        right = arr.slice(mid);

    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);
}

function customRandom(x)
{
    var maxi=1000000; 
    return Math.floor(x*x*x*Math.cos(x)*Math.cos(x)) % maxi ; 
}


/***************************getting arguments ***************************/
var n = (process.argv.length > 2 ) ? parseInt(process.argv[2]):100; 
var niters = (process.argv.length > 3 ) ? parseInt(process.argv[3]):1; 
/***************************main loop ***************************/
for (var iter = 0; iter < niters; iter++) {
    var arr =[];
    for (var i = 0; i < n; i++) {
        arr[i] = customRandom(i); 
    }
    
    mergeSort(arr); 
      
}
