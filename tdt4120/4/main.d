import std.stdio;
import std.string;
import std.conv;
import std.format;

real sgt(bool[][] nmatrix, int startnode, int n) {
    real nodes = 0;
    real edges = 0;
    bool[] plausible;
    for (int i = 0; i < n; i++) { plausible ~= false;}
    plausible[startnode] = true;
    int queue[];
    queue ~= startnode;
    int queue_start = 0;
    int queue_length = 1;

    while (queue_length > 0) {
        int derp = queue[queue_start]; queue_start++; queue_length--;
        for (int merp = 0; merp < n; merp++) {
            if (nmatrix[derp][merp] && !plausible[merp]) {
                plausible[merp] = true;
                queue_length++;
                queue ~= merp;
            }
        }
    }
    
    
    for (int derp = 0; derp < n; derp++) {
        if (!plausible[derp]) {
            nodes++;
            for (int merp = 0; merp < n; merp++) {
                if (nmatrix[derp][merp] && !plausible[merp]) {
                    edges++;
                }
            }
        }
    }
    if (nodes == 0) {
        return 0.000;
    } else {
        return to!real(edges) / to!real(nodes * nodes);
    }
}

void main() {

    int n = to!int(strip(stdin.readln()));
    bool[][] nmatrix;
    string derp;
    for (int i = 0; i < n; i++) {
        bool[] a;
        for (int j = 0; j < n; j++) {
            a ~= false;
        }
        nmatrix ~= a;
        string line = stdin.readln();
        for (int j = 0; j < n; j++) {
            nmatrix[i][j] = (line[j] == '1');
        }
    }
    while(stdin.readln(derp)) {
        int start = to!int(strip(derp));
        real result = (sgt(nmatrix, start, n) + cast(real)1E-12);
        writefln("%.3f", result);
    }
}

