package com.biswaljava.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.biswaljava.junit.helper.ArraysTest;
import com.biswaljava.junit.helper.StringHelperTest;

@RunWith(Suite.class)
@SuiteClasses({ArraysTest.class,StringHelperTest.class})
public class DummyTestSuite {

}
