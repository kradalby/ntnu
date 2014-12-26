import std.stdio;
import std.string;
import std.conv;

//string merge(decks) {
//
//
//}

void main() {
    
    string buf;
    string[] input;
    int i;
    int j;
    int index;
    string list;

    writeln(stdin.length);
    while(stdin.readln(buf)) {
        input ~= strip(buf);
    }
    int numberoflines = to!int(input.length);

    //char[][int] = new char[][int] (numberoflines)();
    string[int] derps;
    string[][] keys;
    string value;
    int keyslength;
    string[] derp;


    for (i = 0; i < numberoflines; i++) {
        derp = split(input[i], ":");
        value = (derp[0]);
        keys ~= split(derp[1], ",");
        keyslength = to!int(keys[i].length);
        for (j = 0; j < keyslength; j++) {
            derps[to!int(keys[i][j])] = value;
        }
    }

    for (i = 0; i < derps.keys.length; i++) {
        write(derps[derps.keys.sort[i]]);
    }
    writeln();
}
