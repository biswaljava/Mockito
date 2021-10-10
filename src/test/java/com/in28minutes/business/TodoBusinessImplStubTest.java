package com.biswaljava.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.biswaljava.data.api.TodoService;
import com.biswaljava.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}
