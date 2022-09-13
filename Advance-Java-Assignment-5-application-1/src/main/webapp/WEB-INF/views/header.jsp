<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<header style="background-image: linear-gradient(#5a88c9, white);border-style: solid; border-color:#5a88c9;">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header" style="margin-left: 25%;padding-right: 10%;">
                <h2>Library Management System</h2>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <h5>Welcome ${usr}</h5>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form action="logout" method="POST">
                        <input type="submit" value="Logout" 
                        style="background-color:white; 
                                border-radius:8px ;
                                color: #0088ff;
                                font-weight: bold;
                                border-color:#0088ff ;">
                    </form>
                </li>
            </ul>
        </div>
    </nav>
</header>