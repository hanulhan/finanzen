<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
    </head>
<body>

    <div class="x_panel">

        <div class="x_title">
            <h2>ACS Module</h2>
            <div class="clearfix"></div>
        </div>

        <div class="x_content">
            <br>
            <s:a action="getCountries" namespace="/ems">get countries</s:a>
            <br>
            <s:a action="getHotels" namespace="/ems">get hotels</s:a>
        </div>
    </div>

</body>

</html>
