from math import cos
import sys




def merge(left, right):
    result = []
    left_idx, right_idx = 0, 0
    while left_idx < len(left) and right_idx < len(right):
        # change the direction of this comparison to change the direction of the sort
        if left[left_idx] <= right[right_idx]:
            result.append(left[left_idx])
            left_idx += 1
        else:
            result.append(right[right_idx])
            right_idx += 1
 
    if left_idx < len(left):
        result.extend(left[left_idx:])
    if right_idx < len(right):
        result.extend(right[right_idx:])
    return result


def merge_sort(m):
    if len(m) <= 1:
        return m
 
    middle = len(m) // 2
    left = m[:middle]
    right = m[middle:]
 
    left = merge_sort(left)
    right = merge_sort(right)
    return list(merge(left, right))


def random(x, maxi=1000000):
   return (int(x*x*x* cos(x)*cos(x) ))  % maxi 


def printi(l):
    for i in l : 
        print(str(i)+" " ,end="")
    print("\n")

if __name__ == '__main__':
    N = int(sys.argv[1]) if len(sys.argv) > 1 else 100 # taille de notre tableau
    Niters = int(sys.argv[2]) if len (sys.argv) >2 else  1  # nombre d'iterations qu'on veut faire ( 1 par defeault)
    
    for i in range(Niters): 
        l=[random(i) for i in range(N)]
        #printi(l)
        l=merge_sort(l)
        #printi(l)