package com.genesys.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
  private static List<Integer> primeList = findPrimes();

  public static List<Integer> findPrimes() {
    List<Integer> integerList = Arrays.asList(2);

    for (int i = 3; i < 100; i++) {
      for (int j = 0; j <= integerList.size(); j++) {
        if (i % j == 0) {
          break;
        } else if (j == integerList.size()) {
          integerList.add(i);
        }
      }
    }

    return integerList;
  }

  public static boolean isPrime(int number) {
    return Primes.primeList.contains(number);
  }
}
