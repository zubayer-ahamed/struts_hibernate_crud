<%-- 
    Document   : insert
    Created on : Aug 19, 2017, 9:43:53 AM
    Author     : cyclingbd007
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            body{
                text-align: center;
            }
            table{
                border-collapse: collapse;
                margin: 0 auto;
            }
            th, td{padding: 10px;}
            input{padding: 10px;}
            tfoot{text-align: center;}
        </style>
    </head>
    <body>
        <h1 align="center">Insert Product</h1>
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
        <s:form action="insertProduct" method="post">
            <s:textfield name="product.pname" label="Product Name: "/>
            <s:textfield name="product.price" label="Product Price: "/>
            <s:textfield name="product.qty" label="Product Quantity: "/>
            <s:submit value="Save"></s:submit>
        </s:form>
            <a href="index.html">Product List Page</a>
    </body>
</html>
