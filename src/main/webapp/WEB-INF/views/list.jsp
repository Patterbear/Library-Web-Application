<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>Libraries:</h2>
<ul>
<c:forEach items="${libraries}" var="library">
		<li>${library}</li>
</c:forEach>
</ul>

<h2>Patrons:</h2>
<ul>
<c:forEach items="${patrons}" var="patron">
	<li>${patron}</li>
</c:forEach>
</ul>

<h2>Items:</h2>
<ul>
<c:forEach items="${items}" var="item">
	<li>${item}</li>
</c:forEach>
</ul>

</body>
</html>