#!/usr/bin/perl
use strict;
use warnings;

my $inf = 99**1024;

sub main 
{
    my @input = <STDIN>;
    my $testcases = $input[0];
    my $i;
    my $line = 1;

    for ($i = 0; $i < $testcases; $i++) {
        my $cities = $input[$line];
        $line++;
        my @order = split(' ', $input[$line]);
        $line++;
        my @am;
        for (my $j = 0; $j < $cities; $j++) {
            my @nr = split(' ', $input[$line]);
            $line++;
            push @am, \@nr;
        }
        
        for (my $j = 0; $j < $cities; $j++) {
            for (my $k = 0; $k < $cities; $k++) {
                if ($am[$j][$k] == -1) {
                    $am[$j][$k] = $inf;    
                }
            }
        }
    print &shortest_route(\@am, \@order, $cities);
    }
}


sub shortest_route
{
    my $refam = shift;
    my $reforder = shift;
    my $cities = shift;
    my @am = @{$refam};
    my @order = @{$reforder};

    
    push @order, $order[0];
    @am = &floydwarshall(\@am);
    my $tot = 0;
    my $current = $order[0];
    foreach my $city (@order[1 .. $#order]) {
        my $cost = $am[$current][$city];
        if ($cost == $inf) {
            return "umulig\n"
        }
        $tot += $cost;
        $current = $city;
    }
    return $tot, "\n"
    
}

sub floydwarshall
{
    my $rmatrix = shift;
    my @matrix = @{$rmatrix};
    my $n = $#matrix + 1;
    for (my $k = 0; $k < $n; $k++) {
        for (my $i = 0; $i < $n; $i++) {
            for (my $j = 0; $j < $n; $j++) {
                if (($matrix[$i][$k] + $matrix[$k][$j]) < $matrix[$i][$j]) {
                    $matrix[$i][$j] = $matrix[$i][$k] + $matrix[$k][$j];
                }
            }
        }
    }    
    return @matrix;

}

main();
