package com.genesys.interview;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Method returns the greater version number.
 * A normal version number MUST take the form X.Y.Z where X, Y, Z are non-negative integer
 * Values increase numerically. For instance: 1.9.0 -> 1.10.0 -> 1.11.0.
 * If the input is invalid we should raise a VersionMismatchException exception
 * Must not contain leading zeroes
 * If the inputs are the same return that version
 *
 */


public class SemanticVersionQuestion {


    public static String getGreaterVersion(String firstVersion, String secondVersion) {
        ArrayList<String> firstVersionList = new ArrayList<>(Arrays.asList(firstVersion.split("\\.")));
        ArrayList<String> secondVersionList = new ArrayList<>(Arrays.asList(secondVersion.split("\\.")));

        for (int i=0; i <= firstVersionList.size()-1; i++) {
            if (Integer.parseInt(firstVersionList.get(i)) > Integer.parseInt(secondVersionList.get(i))) {
                return firstVersion;
            } else if (Integer.parseInt(firstVersionList.get(i)) < Integer.parseInt(secondVersionList.get(i))) {
                return secondVersion;
            } else {
                continue;
            }
        }
        return "0.0.0";
    }

    public static class VersionMismatchException extends RuntimeException {

    }



    public static void main(String[] args) {
        if (getGreaterVersion("1.1.0", "1.2.0").equals("1.2.0")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        if (getGreaterVersion("1.2.0", "1.2.0").equals("1.2.0")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        try {
            getGreaterVersion("1.a.0", "1.2.0");

        } catch (NumberFormatException e) {
            System.out.println("FAIL "+ e.getClass() + "  " + e.getMessage());
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }

        try {
            getGreaterVersion("", "1.2.0");

        } catch (NumberFormatException e) {
            System.out.println("FAIL "+ e.getClass() + "  " + e.getMessage());
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }

        try {
            getGreaterVersion(null, "1.2.0");

        } catch (NullPointerException e) {
            System.out.println("FAIL "+ e.getClass() + "  " + e.getMessage());
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }


        try {
            getGreaterVersion("1.2.3.4.5.6", "1.2.0");
            System.out.println("FAIL ");
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }

        try {
            getGreaterVersion("1..6", "1.2.0");
        } catch (NumberFormatException e) {
            System.out.println("FAIL "+ e.getClass() + "  " + e.getMessage());
        }
            catch (VersionMismatchException e){
            System.out.println("PASS");
        }

        try {
            getGreaterVersion("1.6", "1.2.0");
            System.out.println("FAIL");
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }

        try {
            getGreaterVersion("001.6.1", "1.2.0");
            System.out.println("FAIL");
        }
        catch (VersionMismatchException e){
            System.out.println("PASS");
        }

    }
}

