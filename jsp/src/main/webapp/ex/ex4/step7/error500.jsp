<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
      body {
          background: lightgreen;
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
<span>500 error</span>
<strong>요청한 페이지에 서버 내부 에러 발생</strong>
</body>
</html>
