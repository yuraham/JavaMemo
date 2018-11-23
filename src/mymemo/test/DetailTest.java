package mymemo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymemo.MemoDao;
import mymemo.MemoInfo;

class DetailTest {

	@Test
	void test() {
		MemoDao data = new MemoDao();
		MemoInfo mymemo = data.detailPost(14);
		assertEquals("테스트", mymemo.getName());
	}

}
