package com.melcsii;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String WELCOME_MESSAGE = "This program reports information about DNA\n" +
            "nucleotide sequences that may encode proteins.";
    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final int MIN_CODON = 5;
    private static final int MIN_MASS_PERCENT = 30;
    private static final int UNIQUE_NUCLEOTIDES = 4;
    private static final int CODON_LENGTH = 3;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(WELCOME_MESSAGE);
        System.out.print("Input file name? ");
        File file = new File(CONSOLE.nextLine());
        Scanner input = new Scanner(file);
        System.out.print("Output file name? ");
        String output = CONSOLE.nextLine();
        DNA(input, output);
    }

    private static void DNA(Scanner input, String output) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new File(output));
        while (input.hasNextLine()) {
            String name = input.nextLine();
            printStream.println("Region Name: " + name);
            String sequence = input.nextLine().toUpperCase();
            printStream.println("Nucleotides: " + sequence);

            String nucleotides = sequence.replaceAll("-", "");
            String[] codon = getCodons(nucleotides);
            printStream.println("Codons List: " + Arrays.toString(codon));
            double[] mass = countMass(sequence, printStream);
            printStream.println("Is Protein?: " + isProtein(codon, mass) + "\n");
        }
    }

    private static double[] countMass(String line, PrintStream out) {
        int[] nucleotide = new int[UNIQUE_NUCLEOTIDES];
        double[] mass = new double[UNIQUE_NUCLEOTIDES + 1];

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'A') {
                nucleotide[0]++;
                mass[0] += 135.128;

            } else if (line.charAt(i) == 'C') {
                nucleotide[1]++;
                mass[1] += 111.103;

            } else if (line.charAt(i) == 'G') {
                nucleotide[2]++;
                mass[2] += 151.128;

            } else if (line.charAt(i) == 'T') {
                nucleotide[3]++;
                mass[3] += 125.107;

            }else if (line.charAt(i) == '-') {
                mass[4] += 100;
            }
        }
        out.println("Nuc. Counts: " + Arrays.toString(nucleotide));
        return totalMassPercent(mass, out);
    }

    private static double[] totalMassPercent(double[] mass, PrintStream out) {
        double totalMass = Math.round((mass[0] + mass[1] + mass[2] + mass[3] + mass[4]) * 10) / 10.0; // TODO: use for loop

        double[] massPercent = new double[mass.length - 1];
        for (int i = 0; i < massPercent.length; i++) {
            massPercent[i] = Math.round(mass[i] / totalMass * 1000) / 10.0;
        }
        out.println("Total Mass%: " + Arrays.toString(massPercent) + " of " + totalMass);
        return massPercent;
    }

    private static String[] getCodons(String nucleotides) {
        String[] codons = new String[nucleotides.length() / CODON_LENGTH];
        for (int i = 0; i < nucleotides.length(); i += CODON_LENGTH) {
            codons[i / CODON_LENGTH] = nucleotides.substring(i, i + CODON_LENGTH);
        }

        return codons;
    }

    private static String isProtein(String[] codonList, double[] mass){
        if (codonList[0].equals("ATG") && (codonList[codonList.length - 1].equals("TAA") || codonList[codonList.length - 1].equals("TAG") || codonList[codonList.length - 1].equals("TGA")) && (mass[1] + mass[2] >= MIN_MASS_PERCENT) && (codonList.length >= MIN_CODON)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}