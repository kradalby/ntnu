import std.stdio;
import std.string;
import std.conv;

void main() {

    string buf;
    string[] input;
    int i;
    int j;
    string[2] ph;
    string[] index2;
    string[int] dicks;

    while(stdin.readln(buf)) {
        input ~= strip(buf);
    }


    for (i = 0; i < input.length; i++) {
        ph = split(input[i], ":");
        index2 = split(ph[1], ",");
        for (j = 0; j < index2.length; j++) {
            dicks[to!int(index2[j])] = ph[0];
        }
    }
    
    //string derp;
    int[] sorted = new int[](dicks.length); 
    sorted = dicks.keys.sort;

    //for (i = 0; i < dicks.length; i++) {
    //    derp ~= dicks[sorted[i]];

    //}

    foreach(int h; sorted) {
      write(dicks[h]);
    }

    writeln();

}
