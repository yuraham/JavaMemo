package mymemo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymemo.MemoDao;
import mymemo.MemoInfo;

class UpdateTest {

	@Test
	void test() {
		MemoInfo memo = new MemoInfo();
		memo.setContent("수정된 텍스트");
		int num = memo.getIdx();
		MemoDao data = new MemoDao();
		data.updateMemo(memo, num);
		assertEquals("수정된 텍스트", memo.getContent());
	}

}
