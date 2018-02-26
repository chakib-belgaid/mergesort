import std.stdio, std.algorithm, std.array, std.range, std.math, std.conv,
    std.getopt;

T[] mergeSorted(T)(in T[] D) /*pure nothrow @safe*/
{
    if (D.length < 2)
        return D.dup;
    return merge(D[0 .. $ / 2].mergeSorted, D[$ / 2 .. $].mergeSorted).array;
}

T[] merge(T)(in T[] D1, in T[] D2)
{
    if (D1 == null)
        return D2.dup;
    if (D2 == null)
        return D1.dup;
    if (D1[0] < D2[0])
        return join([[D1[0]], merge(D1[1 .. $], D2)]).dup;
    return join([[D2[0]], merge(D1, D2[1 .. $])]).dup;

}

int customRandom(int x)
{
    const MAXI = 1000000;
    return to!int(x * x * x * cos(float(x)) * cos(float(x))) % MAXI;
}

void main(string[] args)
{
    int n = (args.length > 1) ? to!int(args[1]) : 100;
    int niters = (args.length > 2) ? to!int(args[2]) : 1;

    foreach (int iter ; 0 .. niters)
    {
        int[] arr;
        arr.length = n;
        foreach (int i ; 0 .. n)
        {
            arr[i] = customRandom(i);
        }
        
        arr.mergeSorted;

    }

    //merge([1, 3, 6], [2, 5, 4]).writeln; //auto num = iota(1, 11).filter!(x => x % 2 == 0).reduce!((a, b) => a + b);

}
