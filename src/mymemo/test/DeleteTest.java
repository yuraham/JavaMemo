package mymemo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymemo.MemoDao;

class DeleteTest {

	@Test
	void test() {
		MemoDao data = new MemoDao();
		assertEquals(1, data.deletePost(13));
	}

}
