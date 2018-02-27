def merge_sort(m)
    return m if m.length <= 1
    middle = m.length / 2
    left = merge_sort(m[0...middle])
    right = merge_sort(m[middle..-1])
    merge(left, right)
end
   
def merge(left, right)
	result = []
	until left.empty? || right.empty?
		result << (left.first<=right.first ? left.shift : right.shift)
	end
	result + left + right
end
   
def customRandom(x)
	maxi = 1000000
	(x*x*x*Math.cos(x)*Math.cos(x)).floor % maxi	
end

n = ARGV.length >0 ? ARGV[0].to_i : 20 
niters = ARGV.length >1 ? ARGV[1].to_i : 1 
  
for iter in 1..niters 
	arr = []
	for i in 1..n 
		arr << customRandom(i)
	end 
	p arr 
	p merge_sort(arr)                  #

end 
