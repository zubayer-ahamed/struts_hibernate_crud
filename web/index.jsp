<%-- 
    Document   : index
    Created on : Aug 19, 2017, 5:39:56 AM
    Author     : cyclingbd007
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{
                border-collapse: collapse;
                margin: 0 auto;
            }
            th, td{padding: 10px;}
            tfoot{text-align: center;}
        </style>
    </head>
    <body>
        <h1 align="center" style="color: green">Struts2 Hibernate CRUD</h1>
        <p align="center">
            <s:if test="sm != null">
                <font color="green">
                <s:property value="sm"/>
                </font>
            </s:if>
            <s:if test="em != null">
                <font color="red">
                <s:property value="em"/>
                </font>
            </s:if>
        </p>
        <table border="1">
            <thead>
                <tr>
                    <th colspan="6">Product List</th>
                </tr>
                <tr>
                    <th>PID</th>
                    <th>PName</th>
                    <th>Price</th>
                    <th>Qty</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${productList}">
                    <tr>
                        <td>${row.pid}</td>
                        <td>${row.pname}</td>
                        <td>${row.price}</td>
                        <td>${row.qty}</td>
                        <td><a href="edit.html?pid=${row.pid}">Edit</a></td>
                        <td><a onclick="return confirm('Are you shure to delete this item?')" href="delete.html?pid=${row.pid}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="6">
                        <a href="insert.html">Insert Page</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
