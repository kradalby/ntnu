#!/usr/bin/perl
use strict;
use warnings;

sub main
{
    my @input = <STDIN>;
    my $n = $input[0];
    my @prob = split(' ', $input[1]);
    my @am;

    foreach my $derp (@input[2 .. $#input]) {
        my @nr = (0) x $n;
        my @neis = split(' ', $derp);
        foreach my $nei (@neis) {
            $nr[$nei] = 1;   
        }
        push @am, \@nr;
    }

    #for (my $i = 0; $i < $n; $i++) {
    #    for (my $j = 0; $j < $n; $j++) {
    #        print($am[$i][$j]);
    #    }
    #    print "\n";
    #}
    
   print &best_path(\@am, \@prob, $n); 


}

sub best_path
{
    
    my $refam = shift;
    my $refprob = shift;
    
    my @am = @{$refam};
    my @prob = @{$refprob};
    my $n = shift;

    my @finished = (0) x $n;
    my @derp = (0.0) x $n;
    $derp[0] = $prob[0];
    my $bnode = 0;
    my @past = (0..$n-1);

    for (my $i = 0; $i < $n; $i++) {
        my $node = $bnode;
        $finished[$node] = 1;
        my $hk = -1.0;
        for (my $nei = 0; $nei < $n; $nei++) {
            if (!$finished[$nei]) {
                if ($am[$node][$nei]) {
                    my $offer = $derp[$node] * $prob[$nei];
                    if ($offer > $derp[$nei]) {
                        $past[$nei] = $node;
                        $derp[$nei] = $offer;
                    }
                }    
                if ($derp[$nei] > $hk) {
                    $bnode = $nei;
                    $hk = $derp[$nei];
                
                }
            }
        }
    }

    if ($derp[-1] == 0.0) {
        return '0', "\n";
    }
    
    my $i = $n - 1;
    my @path;

    while ($i != 0) {
        push @path, $i;
        $i = $past[$i];
    }
    push @path, 0;

    #print join(",", @past), "\n";
    #print join(",", @derp), "\n";

    return join("-", reverse(@path)), "\n";

}


main();
