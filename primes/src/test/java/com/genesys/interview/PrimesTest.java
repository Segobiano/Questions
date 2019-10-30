package com.genesys.interview;

import org.junit.Test;

import com.genesys.interview.Primes;

public class PrimesTest {
  @Test
  public void testIsPrime() {
    assert Primes.isPrime(97);
    assert Primes.isPrime(5);
    assert !Primes.isPrime(49);
  }
}
