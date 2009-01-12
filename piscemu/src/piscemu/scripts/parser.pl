#!/usr/bin/perl
use strict;
use warnings;

use constant VERSION => "0.1";

#Constantes das instrucoes:
use constant ADD_INST => 0x0100;
use constant SUB_INST => 0x0200;
use constant MOV_INST => 0x0300;
use constant CMP_INST => 0x0400;
use constant AND_INST => 0x0500;
use constant  OR_INST => 0x0600;
use constant NOT_INST => 0x0700;
use constant CLR_INST => 0x0800;
use constant NEG_INST => 0x0900;
use constant SHL_INST => 0x0A00;
use constant SHR_INST => 0x0B00;
use constant BRZ_INST => 0x0C00;
use constant BRN_INST => 0x0D00;
use constant BRE_INST => 0x0E00;
use constant BRL_INST => 0x0F00;
use constant BRG_INST => 0x1000;
use constant BRC_INST => 0x1100;
use constant JMP_INST => 0x1200;
use constant XOR_INST => 0x1300;
use constant INC_INST => 0x1400;
use constant DEC_INST => 0x1500;

#Constantes dos operandos FONTE:
use constant FONTE_R0_DIR => 0x00;
use constant FONTE_R1_DIR => 0x10;
use constant FONTE_R2_DIR => 0x20;
use constant FONTE_R3_DIR => 0x30;
use constant FONTE_R4_DIR => 0x40;
use constant FONTE_IM_DIR => 0x70;

use constant FONTE_R0_MEM => 0x80;
use constant FONTE_R1_MEM => 0x90;
use constant FONTE_R2_MEM => 0xA0;
use constant FONTE_R3_MEM => 0xB0;
use constant FONTE_R4_MEM => 0xC0;
use constant FONTE_IM_MEM => 0xF0;

#Constantes dos operandos DESTINO:
use constant DESTINO_R0_DIR => 0x00;
use constant DESTINO_R1_DIR => 0x01;
use constant DESTINO_R2_DIR => 0x02;
use constant DESTINO_R3_DIR => 0x03;
use constant DESTINO_R4_DIR => 0x04;
use constant DESTINO_IM_DIR => 0x07;

use constant DESTINO_R0_MEM => 0x08;
use constant DESTINO_R1_MEM => 0x09;
use constant DESTINO_R2_MEM => 0x0A;
use constant DESTINO_R3_MEM => 0x0B;
use constant DESTINO_R4_MEM => 0x0C;
use constant DESTINO_IM_MEM => 0x0F;



my $line;
my $mem_pos = 0x0000;
my %labels;
my %ltr;
my @mem = ();
my $inst;
my $offset;
my $com;
my $label;
my $op_a;
my $op_b;

print "DIGITE 'FIM' para encerrar o input do parser\n";

while($line = <>)
{

	$inst = 0;

	if($line =~ /^FIM$/) {last;}

	if($line =~ /^[:]((\s*\w*)+)$/i)
	{
		#Comentario de codigo

		$com = $1;
		chomp $com;

		print "Comentario: $com\n";

	}

	elsif($line =~ /^([A-Z]+)$/)
	{
		#Label

		$label = $1;
		chomp $label;
		print "Label = $label\n";

		$labels{"$label"} = $mem_pos;
	}

	elsif($line =~ /^(ADD|SUB|MOV|CMP|AND|OR|XOR)\s+(R[0-4]|\(R[0-4]\)|\d+|0x[0-9A-F]+)\s*,\s*(R[0-4]|\(R[0-4]\)|\d+|0x[0-9A-F]+)$/)
	{
		$offset = 0;
		$op_a = $2;
		$op_b = $3;

		#Instrucao de 2 operandos;
		if($1 eq "ADD")		{$inst += ADD_INST;}
		elsif($1 eq "SUB")	{$inst += SUB_INST;}
		elsif($1 eq "MOV")	{$inst += MOV_INST;}
		elsif($1 eq "CMP")	{$inst += CMP_INST;}
		elsif($1 eq "AND")	{$inst += AND_INST;}
		elsif($1 eq "OR" )	{$inst +=  OR_INST;}
		elsif($1 eq "XOR")	{$inst += XOR_INST;}
		#else{print "\$1 = $1\n";}


		if($op_a =~ /^\d+$/)	{$inst += FONTE_IM_DIR; $offset++; $mem[$mem_pos + $offset] = int($op_a);}
		elsif($op_a =~ /^0x[0-9A-F]+$/) {$inst += FONTE_IM_DIR; $offset++; $mem[$mem_pos + $offset] = hex($op_a);}
		elsif($op_a eq "R0")		{$inst += FONTE_R0_DIR;}
		elsif($op_a eq "R1")	{$inst += FONTE_R1_DIR;}
		elsif($op_a eq "R2")	{$inst += FONTE_R2_DIR;}
		elsif($op_a eq "R3")	{$inst += FONTE_R3_DIR;}
		elsif($op_a eq "R4")	{$inst += FONTE_R4_DIR;}
		elsif($op_a eq "(R0)")	{$inst += FONTE_R0_MEM;}
		elsif($op_a eq "(R1)")	{$inst += FONTE_R1_MEM;}
		elsif($op_a eq "(R2)")	{$inst += FONTE_R2_MEM;}
		elsif($op_a eq "(R3)")	{$inst += FONTE_R3_MEM;}
		elsif($op_a eq "(R4)")	{$inst += FONTE_R4_MEM;}
		#else{print "\$2 = $op_a\n";}

		if($op_b =~ /^\d+$/)	{$inst += DESTINO_IM_DIR; $offset++; $mem[$mem_pos + $offset] = int($op_b);}
		elsif($op_b =~ /^0x[0-9A-F]+$/) {$inst += DESTINO_IM_DIR; $offset++; $mem[$mem_pos + $offset] = hex($op_b);}
		elsif($op_b eq "R0")		{$inst += DESTINO_R0_DIR;}
		elsif($op_b eq "R1")	{$inst += DESTINO_R1_DIR;}
		elsif($op_b eq "R2")	{$inst += DESTINO_R2_DIR;}
		elsif($op_b eq "R3")	{$inst += DESTINO_R3_DIR;}
		elsif($op_b eq "R4")	{$inst += DESTINO_R4_DIR;}
		elsif($op_b eq "(R0)")	{$inst += DESTINO_R0_MEM;}
		elsif($op_b eq "(R1)")	{$inst += DESTINO_R1_MEM;}
		elsif($op_b eq "(R2)")	{$inst += DESTINO_R2_MEM;}
		elsif($op_b eq "(R3)")	{$inst += DESTINO_R3_MEM;}
		elsif($op_b eq "(R4)")	{$inst += DESTINO_R4_MEM;}
		#else{print "\$3 = $op_b\n";}

		$mem[$mem_pos] = $inst;
		$mem_pos += 1 + $offset;

		#printf ("Instrucao = 0x%.4X\n", $inst);
	}

	elsif($line =~ /^(NOT|CLR|NEG|SHL|SHR|INC|DEC)\s+(R[0-4]|\(R[0-4]\)|\d+|0x[0-9A-F]+)$/)
	{
		#Instrucao (logica) de 1 operando
	}

	elsif($line =~ /^(BR[ZNELGC]|JMP)\s+([A-Z]+)$/)
	{
		#Instrucao de desvio
	}

}

print "Mem dump:\n";

foreach (@mem)
{
	printf ("0x%.4X\n", $_);
}

print "\n\nFim. Have a nice day ;)\n";