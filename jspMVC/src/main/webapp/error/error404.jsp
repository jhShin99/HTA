<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
      body {
          background: lightskyblue;
      }

      @keyframes textColorAnimation {
          0% {
              color: red;
          }
          20% {
              color: orange;
          }
          40% {
              color: yellow;
          }
          60% {
              color: green;
          }
          80% {
              color: blue;
          }
          100% {
              color: magenta;
          }
      }

      span {
          font-weight: bold;
          font-size: 40px;
          animation-name: textColorAnimation;
          animation-duration: 5s;
          animation-iteration-count: infinite;
          display: block;
          text-align: center;
          margin-top: 100px;
      }
  </style>
</head>
<body>
<span>404 error</span>
<strong>요청한 페이지는 존재하지 않습니다:</strong>
<br>
<br>주소를 올바르게 입력했는지 확인해 보시기 바랍니다.
</body>
</html>
