#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAXI 1000000
//2147483647

typedef  int DATATYPE ;// incase if we want to change it for later testes 

DATATYPE customRandom(int n) // pseudo random number generator 
{
    return (DATATYPE) ((int) floor(n * n * n * cos(n) * cos(n)) % MAXI);
}

void merge(DATATYPE *a, int n, int m)
{
    int i, j, k;
    DATATYPE *x =(DATATYPE *) malloc(n * sizeof(DATATYPE));
    for (i = 0, j = m, k = 0; k < n; k++)
    {
        x[k] = j == n ? a[i++]
                      : i == m ? a[j++]
                               : a[j] < a[i] ? a[j++]
                                             : a[i++];
    }
    for (i = 0; i < n; i++)
    {
        a[i] = x[i];
    }
    free(x);
}

void merge_sort(DATATYPE *a, int n)
{
    if (n < 2)
        return;
    int m = n / 2;
    merge_sort(a, m);
    merge_sort(a + m, n - m);
    merge(a, n, m);
}



//first 20 instances :[0 0 1 26 27 10 199 194 10 605 704 0 230 809 51 947 756 371 542 704]
// the sorted array   [0 0 0 1 10 10 26 27 51 194 199 230 371 542 605 704 704 756 809 947]

void fill(DATATYPE * array, int size )
{
    int i ; 
    for (i=0;i<size;i++)
    {
        array[i] = customRandom(i);
   }
}

void print(DATATYPE * array,int size)
{
    for (size_t i = 0; i < size; i++)
    {
        printf("%d ",array[i]); 
    }
    printf("\n");
}
int main(int argc, char **argv)
{
    int n = (argc > 1) ? atoi(argv[1]) : 100;
    int NITERS = (argc > 2) ? atoi(argv[2]) : 1;
    int i =0,j; 
    for (i=0 ; i< NITERS; i++)
    {
        DATATYPE * array = (DATATYPE *) malloc(sizeof (DATATYPE )*n); 
        
        fill(array,n); 
       // print(array,n);
        merge_sort(array,n);      
       // print(array,n);
        free(array);
    }
    
    return 0;
}