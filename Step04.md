## What You Will Learn during this Step:
- Your first Mockito code! Hurrah!!!
- Lets use Mockito to mock TodoService

## Useful Snippets and References
Easier Static Imports
```
Window > Preferences > Java > Editor > Content Assist > Favorites
org.junit.Assert
org.mockito.BDDMockito
org.mockito.Mockito
org.hamcrest.Matchers
org.hamcrest.CoreMatchers
```
## Exercises
- Play around with code
- Think what JUnit best practises we are NOT adhering to
- Visit Mockito Official Documentation - [Mockito Documentation] (http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)

## Files List
### /pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.biswaljava.mockito</groupId>
	<artifactId>mockito-tutorial</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-all</artifactId>
			<version>1.10.19</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
</project>
```
### /src/main/java/com/biswaljava/business/TodoBusinessImpl.java
```
package com.biswaljava.business;

import java.util.ArrayList;
import java.util.List;

import com.biswaljava.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}
```
### /src/main/java/com/biswaljava/data/api/TodoService.java
```
package com.biswaljava.data.api;

import java.util.List;

// External Service - Lets say this comes from WunderList
public interface TodoService {
	public List<String> retrieveTodos(String user);
}
```
### /src/test/java/com/biswaljava/business/TodoBusinessImplMockitoTest.java
```
package com.biswaljava.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.biswaljava.data.api.TodoService;

public class TodoBusinessImplMockitoTest {

	@Test
	public void usingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}
```
### /src/test/java/com/biswaljava/business/TodoBusinessImplStubTest.java
```
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
```
### /src/test/java/com/biswaljava/data/stub/TodoServiceStub.java
```
package com.biswaljava.data.stub;

import java.util.Arrays;
import java.util.List;

import com.biswaljava.data.api.TodoService;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}
}
```
### /src/test/java/com/biswaljava/mockito/FirstMockitoTest.java
```
package com.biswaljava.mockito;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FirstMockitoTest {

	@Test
	public void test() {
		assertTrue(true);
	}

}
```
