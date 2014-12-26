#!/usr/bin/perl
    prinlech);

package Node;

sub new
{
    my $class = shift;
    my $self = {
        _child => shift,
        _pos => shift,
    };
    bless $self, $class;
    return $self;
}

sub build
{
    $topnode = new Node({},undef);
    foreach my $key (keys %wordlist) {
        my $node = $topnode;
        foreach my $letter ($key) {
                
            }
        }
    }


}

sub position
{
    
}


my @input = <STDIN>;
my @word = split(" ", $input[0]);
#print(@word[2]);
my %wordlist;
my $pos = 0;
foreach my $word (@word) {
    push(@wordlist, ($word, $pos));
    $pos += (length($word) + 1);
    %wordlist{$word} = (length($word) + 1);
}
#print(@wordlist);
$topenode = build($wordlist);
foreach my $line (1..$#input) {
    my $word = chomp($input[$line]);
    @position = position($word, 0, $topnode);
    @position = sort { $a <=> $b } @position;
    $positions = join(" ", @position);
    print($word, ": ", $positions);
}
