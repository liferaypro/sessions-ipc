<%@ include file="init.jsp" %>

<portlet:actionURL var="sendDataURL" name="sendData"></portlet:actionURL>

<aui:form action="${sendDataURL}">
	<aui:fieldset>
		<aui:input name="data"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="send"></aui:button>
	</aui:button-row>
</aui:form>