import std.stdio;
import std.string;
import std.conv;

void merge(string[][][] decks) {
     int decks_length = to!int(decks.length);
     int l_length;
     int r_length;
     int r_start;
     int l_start;
     int decks_start = 0;
     string[][] r;
     string[][] l;
     string[][] sorted;
     int i;
     while (decks_length > 1) {
        sorted = [];
        r_start = 0;
        l_start = 0;
        r = decks[decks_start];
        decks_start++;
        decks_length--;
        l = decks[decks_start];
        decks_start++;
        decks_length--;
        r_length = to!int(r.length);
        l_length = to!int(l.length);
        while(r_length > 0 && l_length > 0) {
            if (to!int(r[r_start][0]) > to!int(l[l_start][0])) {
                sorted ~= l[l_start];
                l_start++;
                l_length--;
            } else {
                sorted ~= r[r_start];
                r_start++;
                r_length--;
            }
        }
        //sorted ~= r[r_start..(r.length-1)];
        //sorted ~= l[l_start..(l.length-1)];
        
        for (i = l_start; i < l.length; i++) {
            sorted ~= l[i];
        }
        for (i = r_start; i < r.length; i++) {
            sorted ~= r[i];
        }

        decks ~= sorted;
        decks_length++;
     }
     for (i = 0; i < sorted.length; i++) {
        write(sorted[i][1]);
     }
     writeln();
}

void main() {
    
    string buf;
    string[] input;
    int i;
    int j;
    int index;
    string list;
    

    while(stdin.readln(buf)) {
        input ~= strip(buf);
    }
    int numberoflines = to!int(input.length);
    string[][][] derp = new string[][][](numberoflines);
    string value;
    string[] merp;
    string[] pos;

    for (i = 0; i < numberoflines; i++) {
        merp = split(input[i], ":");
        value = merp[0];
        pos = split(merp[1], ",");
        for (j = 0; j < pos.length; j++) {
            derp[i] ~= [pos[j], value];
        }
    }

    merge(derp);
}
