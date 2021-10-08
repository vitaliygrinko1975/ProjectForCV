<%@ include file="/WEB-INF/views/page.jspf" %>
<%@ include file="/WEB-INF/views/taglib.jspf" %>

<html>

<c:set var="title" value="Settings" scope="page" />
<%@ include file="/WEB-INF/views/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/views/header.jspf" %>

		<tr>
			<td class="content">
				<%-- CONTENT --%>

				<form id="settings_form" action="controller" method="post">
					<input type="hidden" name="command" value="updateSettings" />

					<div>
						<p>Language</p>
						<select name="locale">
							<option value="ru">Russian</option>
							<option value="en">English</option>
						</select>
					</div>
					
					<div>
						<p>First name</p>
						<input name="firstName">
					</div>
					
					<div>
						<p>Last name</p>
						<input name="lastName">
					</div>
					
					<input type="submit" value="Update"><br/>
				</form> 
				
				<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/WEB-INF/views/footer.jspf" %>
		
	</table>
</body>
</html>