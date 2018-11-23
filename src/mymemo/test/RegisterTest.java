package mymemo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymemo.MemoInfo;

class RegisterTest {

	@Test
	void test() {
		MemoInfo memo = new MemoInfo();
		assertNotNull(memo);
	}

}
