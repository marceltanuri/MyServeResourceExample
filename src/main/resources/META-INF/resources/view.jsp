<%@ include file="/init.jsp" %>

<h1>
	<liferay-ui:message key="myserveresourceexample.caption"/>
</h1>

<div id="myAjaxMessage"></div>

<button id="myAjaxAction">Ajax</button>

<script>

<liferay-portlet:resourceURL id="myHelloMessage" var="myHelloMessageURL">
<portlet:param name="username" value="PARAM_USER_NAME" />
</liferay-portlet:resourceURL>

$("#myAjaxAction").click(function(){
    var _username = themeDisplay.getUserEmailAddress()!=""?themeDisplay.getUserEmailAddress():"Guest User";
    var url = "<%= myHelloMessageURL %>".replace('PARAM_USER_NAME',_username);
    $.post(url, function(data){
    	console.log(data);
    	$('#myAjaxMessage').html('<h3>'+data.message+'</h3>');
    })
});
</script>