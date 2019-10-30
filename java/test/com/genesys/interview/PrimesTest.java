package com.genesys.interview;

import org.junit.Test;

public class PrimesTest {
  @Test
  public void testIsPrime() {
    assert Primes.isPrime(97);
    assert Primes.isPrime(5);
    assert !Primes.isPrime(49);
  }
}
