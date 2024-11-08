<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!--
  link랑 script 는 template 하나에만 작성해야함
  안그랬더니 !important 작성했던 css가 안먹음
  위에서 아래로 읽어가면서 덮어씌워짐
  -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <title>Title</title>
</head>
<script>
  let result = '${message}';
  if (result != '') {
      alert(result);
      <%session.removeAttribute("message");%>
  }
</script>
<body>
<header>
  <div class="jumbotron text-center" style="margin-bottom: 0">
    <h1>상품목록(${pageFile}.jsp)</h1>
  </div>
</header>
<nav>
  <jsp:include page="top.jsp"/>
  <br><br>
</nav>
<div class="container" style="margin-top: 10px">
  <div class="row">
    <div class="col-sm-4">
      <aside>
        <jsp:include page="left.jsp"/>
      </aside>
    </div>
    <div class="col-sm-8" style="margin-bottom: 5rem">
      <section>
        <jsp:include page='${pageFile}.jsp'/>
      </section>
    </div>
  </div>
</div>
<footer>
  <jsp:include page="bottom.jsp"/>
</footer>
<script>
   const pageFile = '${pageFile}';
   const fileList = ["newItem", "bestItem", "usedItem"];
   /**
    * toggleClass() 메서드는 선택한 요소에 지정한 클래스를 추가하거나 제거하는 역할을 합니다.
    * 클래스가 이미 존재하면 제거하고 존재하지 않으면 추가하는 방식으로 동작합니다.
    * 1. 매개변수 한 개
    *    형식) $(selector).toggleClass(className);
    *         className: 추가하거나 제거할 클래스 이름
    *
    *    예) $('.my-element').toggleClass('active');
    *    의미) .my-element 요소에 active 클래스를 추가하거나 제거합니다.
    *          active 클래스가 있으면 제거되고 없으면 추가됩니다.
    *
    * 2. 매개변수 두 개
    *    형식) $(selector).toggleClass(className, boolean);
    *         boolean : true(클래스를 추가) 또는 false(클래스를 제거)
    *    예)$('.my-element').toggleClass('active', true); // 클래스 추가
    *      $('.my-element').toggleClass('active', false); //클래스 제거
    */
   fileList.forEach((file, index) => {
       $('.nav-pills > .nav-item > .nav-link').eq(index)
           .toggleClass('active', pageFile === file);
   })
</script>
</body>
</html>

