<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Fleamarket/css/header.css" type="text/css">
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Merriweather|Metamorphous" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
  <div id="topmenu">
    <ul>
    <li>
    <a href="#" id="notice">NOTICE</a>
    </li>
      <c:if test="${member != null }">
        <li> [${member.name }] </li>
      </c:if>
      <c:choose>
        <c:when test="${member.name == null }">
          <li class="detailmenu" ><a href="/Fleamarket/memmanage/login.do">LOGIN</a></li>
          <li class="detailmenu"><a href="/Fleamarket/memmanage/joinform.do">JOIN</a></li>
        </c:when>
        <c:when test="${member.name != null }">
          <li class="detailmenu"><a href="/Fleamarket/memmanage/logout.do">LOGOUT</a></li>
        </c:when>
      </c:choose>
    </ul>
  </div>

  <div id="bottommenu">
    <ul>
      <li id="market"><a
        href="http://localhost:8081/Fleamarket/maindetail/main.do">FleaMarket</a>
      </li>
      <li>
        <form action="/Fleamarket/product/searchall.do" id="searchForm">
          <input type="text" placeholder="상품명" class="search-box-input"
            name="searchSubj"> <input type="submit" value="검 색"
            class="icon-search" id="subbtn">
        </form>
      </li>
      <div id="secondmenu">
        <c:if test="${member != null }">
          <li class="detailmenu"><a
            href="/Fleamarket/product/productlist.do?email=${member.email }"
            class="btn">MYSTORE</a></li>

          <li class="detailmenu"><a
            href="/Fleamarket/memmanage/detailAction.do?email=${member.email }"
            class="btn">MYINFO</a></li>
        </c:if>
      </div>
      <!--       secondmenu -->
    </ul>
  </div>
  <!--   bottommenu -->
</body>
</html>