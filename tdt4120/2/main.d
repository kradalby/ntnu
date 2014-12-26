import std.stdio;
import std.string;
import std.conv;
 
// node class
class Node {
    bool ratatosk;
    Node[] child;
    int next_child;
 
    this() {
        this.ratatosk = false;
        this.child.length = 0;
        this.next_child = 0;
    }
}
 
// depth first search function
int dfs(Node node) {
    Node[] stack = new Node[6];
    Node derp;
    stack[0] = node;
    int stackLength = 1;
    while(stackLength != 0) {
        derp = stack[stackLength - 1];
        if (derp.ratatosk == true) {
            return (stackLength - 1);
        }
        if (derp.next_child == derp.child.length) {
            stackLength--;
        } else {
            stackLength++;
            stack[stackLength-1] = derp.child[derp.next_child];
            derp.next_child += 1;
        }
    }
    return 0;
}



//int dfs_slowstack(Node node) {
//    Node[] stack;
//    Node derp;
//    stack ~= node;
//    while(stack.length != 0) {
//        derp = stack[stack.length - 1];
//        if (derp.ratatosk == true) {
//            return (to!int(stack.length - 1));
//        }
//        if (derp.next_child == derp.child.length) {
//            stack = stack[0..$-1];
//        } else {
//            stack ~= derp.child[derp.next_child];
//            derp.next_child += 1;
//        }
//    }
//    return 0;
//}
 
// breadth first search function
int bfs(Node node) {
    Node[] queue;
    int[] dybde_list;
    int start = 0;
    int queue_length = 1;
    Node derp;
    int dybde;
    queue ~= node;
    dybde_list ~= 0;
    while (queue_length > 0) {
        derp = queue[start]; start++; queue_length--;
        dybde = dybde_list[start];
        if (derp.ratatosk == true) {
            return dybde;
        }
        for (int i = 0; i < derp.child.length; i++) {
            queue ~= derp.child[i];
            queue_length++;
            dybde_list ~= dybde++;
        }
    }
    return 0;
}

 
int main() {
 
    string buf;
    // get function
    string func = to!string(stdin.readln());
    // get range of nodes
    int node_range = to!int(strip(stdin.readln()));
 
    Node[] nodes;
    // create node objects for all nodes
    for (int i = 0; i < node_range; i++) {
        nodes ~= new Node();
    }
    // get start node
    Node start_node = nodes[to!int(strip(stdin.readln()))];
    // get goal node
    Node ratatosk_node = nodes[to!int(strip(stdin.readln()))];
    ratatosk_node.ratatosk = true;
 
    string[] numbers;
    Node temp_node;
 
    // add information to node objects
    while(stdin.readln(buf)) {
        numbers = split(buf);
        temp_node = nodes[to!int(numbers[0])];
        for (int i = 1; i < numbers.length; i++) {
            temp_node.child ~= nodes[to!int(numbers[to!int(i)])]; 
        }
    }


    switch(func) {
        case "dfs":
            writeln(dfs(start_node));
            break;
        case "bfs":
            writeln(bfs(start_node));
            break;
        default:
            writeln(dfs(start_node));
            break;
    }
 
    return 0;
 
}
