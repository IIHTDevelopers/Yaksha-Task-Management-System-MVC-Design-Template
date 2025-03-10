package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.yaksha.assignment.utils.CustomParser;

public class TaskControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testJstlTagPresenceInTaskListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/task-list.jsp";

		// Ensure the presence of JSTL c:forEach tag and a closing </td> tag
		boolean hasForEachTag = CustomParser.checkJspTagPresence(filePath, "<c:forEach");
		boolean hasTdClosingTag = CustomParser.checkJspTagPresence(filePath, "</td>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasForEachTag && hasTdClosingTag, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInAddTaskJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/add-task.jsp";

		// Check for form submission and input elements in add-task.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<form");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<input");
		boolean hasTextareaTags = CustomParser.checkJspTagPresence(filePath, "<textarea");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags && hasTextareaTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInEditTaskJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/edit-task.jsp";

		// Check for form submission and input elements in edit-task.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<form");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<input");
		boolean hasTextareaTags = CustomParser.checkJspTagPresence(filePath, "<textarea");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags && hasTextareaTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInEditTaskJspForClosure() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/edit-task.jsp";

		// Ensure that edit-task.jsp contains the correct JSP tags and HTML closure
		boolean hasFormClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "form");
		boolean hasInputClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "input");
		boolean hasTextareaClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "textarea");

		// Verify the page includes the correct JSP expression for closure
		yakshaAssert(currentTest(), hasFormClosingTag && hasInputClosingTag && hasTextareaClosingTag, businessTestFile);
	}

	@Test
	public void testTaskListPageDynamicContent() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/task-list.jsp";

		// Check that the JSP dynamically renders task data by ensuring presence of
		// dynamic content like task name and task description
		boolean hasDynamicTaskName = CustomParser.checkJspTagPresence(filePath, "${task.name}");
		boolean hasDynamicTaskDescription = CustomParser.checkJspTagPresence(filePath, "${task.description}");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasDynamicTaskName && hasDynamicTaskDescription, businessTestFile);
	}

	@Test
	public void testTaskDeleteUrlPresenceInTaskListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/task-list.jsp";

		// Check if the delete URL is present for each task
		boolean hasDeleteUrl = CustomParser.checkJspTagPresence(filePath, "/task/delete");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasDeleteUrl, businessTestFile);
	}

	@Test
	public void testTaskEditUrlPresenceInTaskListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/task-list.jsp";

		// Check if the edit URL is present for each task
		boolean hasEditUrl = CustomParser.checkJspTagPresence(filePath, "/task/edit");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasEditUrl, businessTestFile);
	}
}
