

#include <cstdlib>
#include <iostream>
#include <cmath>
#define MAXI 1000

typedef int DATATYPE;

void merge(DATATYPE a[], int left_low, int left_high, int right_low, int right_high);
void mergeSort(DATATYPE a[], int length);
void mergeSort(DATATYPE a[], int low, int high);

DATATYPE customRandom(int n) // pseudo random number generator
{
    return (DATATYPE)((int)floor(n * n * n * cos(n) * cos(n)) % MAXI);
}

void mergeSort(DATATYPE a[], int length)
{
    mergeSort(a, 0, length - 1);
}

void mergeSort(DATATYPE a[], int low, int high)
{
    if (low >= high) //Base case: 1 value to sort->sorted
        return;      //(0 possible only on initial call)
    else
    {
        int mid = (low + high) / 2;        //Approximate midpoint*
        mergeSort(a, low, mid);           //Sort low to mid part of array
        mergeSort(a, mid + 1, high);      //Sort mid+1 to high part of array
        merge(a, low, mid, mid + 1, high); //Merge sorted subparts of array
    }
}

void merge(DATATYPE a[], int left_low, int left_high, int right_low, int right_high)
{
    int length = right_high - left_low + 1;
    int temp[length];
    int left = left_low;
    int right = right_low;
    for (int i = 0; i < length; ++i)
    {
        if (left > left_high)
            temp[i] = a[right++];
        else if (right > right_high)
            temp[i] = a[left++];
        else if (a[left] <= a[right])
            temp[i] = a[left++];
        else
            temp[i] = a[right++];
    }

    for (int i = 0; i < length; ++i)
        a[left_low++] = temp[i];
}

//first 20 instances :[0 0 1 26 27 10 199 194 10 605 704 0 230 809 51 947 756 371 542 704]
// the sorted array   [0 0 0 1 10 10 26 27 51 194 199 230 371 542 605 704 704 756 809 947]

int main(int argc, char **argv)
{

    const int n = (argc > 1) ? std::atol(argv[1]) : 100;
    const int NITERS = (argc > 2) ? std::atol(argv[2]) : 1;
    for (int iter = 0; iter < NITERS; iter++)
    {
        DATATYPE a[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = customRandom(i);
        }
        mergeSort(a, n);
    }
}