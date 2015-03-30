<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 23.03.15
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>CaxapOK</title>
  </head>
  <body>
  <c:if test="${client==null}">
        <form:form modelAttribute="loginDto" action="/login" method="post">
        Login: <form:input path="login" type="text"/>
        Pass:  <form:input path="pass" type="password"/>
        <input type="submit"/>
        <a href="/registration">registration</a>
        </form:form>
  </c:if>
  <c:if test="${client!=null}">
      <h1><c:out value="${client.login}"/></h1>
  </c:if>
  <c:out value="men:"/>
  <c:forEach items="${productTypes}" var="type">
      <spring:url value="/{slug}" var="articleUrl">
          <spring:param name="slug" value="${type}" />
      </spring:url>
    <a href="${articleUrl}"><c:out value="${type}"/></a>
  </c:forEach>
  <c:out value="women:"/>
  <c:forEach items="${productTypes}" var="type">
      <spring:url value="/{slug}" var="articleUrl">
          <spring:param name="slug" value="${type}" />
      </spring:url>
      <a href="${articleUrl}"><c:out value="${type}"/></a>
  </c:forEach>
  </body>
</html>
