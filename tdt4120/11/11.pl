#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

my $inf = 1000000000;

sub main
{
    my @input = <STDIN>;
    my @coins = split(" ", $input[0]);
    @coins = sort {$b <=> $a} @coins;
    my $method = $input[1];
    my @amounts = @input[2 .. $#input];

    print &can_be_greedy(\@coins), "\n";
    if (($method eq "graadig\n") or ($method eq "velg\n" and &can_be_greedy(\@coins))) {
        foreach my $amount (@amounts) {
            print &minimum_coins_greedy(\@coins, $amount), "\n";
        } 
    } else {
        #foreach my $amount (@amounts) {
        #    print &minimum_coins_dynamic(\@coins, $amount), "\n";
        #} 
        return 0
    }
}

sub minimum_coins_greedy
{
    my $rcoins = shift;
    my @coins = @{$rcoins};
    my $amount = shift;
    my $count = 0;

    while ($amount > 0) {
        if ($amount >= $coins[0]) {
            #Possible edgecase
            my $derp = int($amount / $coins[0]);
            $amount -= ($derp * $coins[0]);
            $count += $derp;
        }
        @coins = @coins[1 .. $#coins];
        #print $count, "\n";
    }
    return $count;


}

#sub minimum_coins_dynamic
#{
#    my $rcoins = shift;
#    my @coins = @{$rcoins};
#    my $amount = shift;
#    my $count = 0;
#
#    my @array = 0 x ($amount + 1);
#    my @array2;
#    $array[0] = \@array2;
#    
#    for (my $i = 1; $i < ($amount + 1); $i++) {
#        foreach my $coin (@coins) {
#            if ($coin > $i) {
#                continue;
#            } else if (not @array[$i] or ($#array[$i - $coin] + 1) < $#array[$i]) {
#                if ($array[$i - $coin] != 0) {
#                
#                }
#            }
#        }
#    }
#
#}

sub can_be_greedy
{
    my $rcoins = shift;
    my @coins = @{$rcoins};
    for (my $i = 0; $i < ($#coins-1); $i++) {
        if ($coins[$i] < ($coins[$i+1]*2)) {
            return 0;
        }
    }
    return 1;

}

main()
