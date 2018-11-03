<c:choose>
<c:when test="${not empty users}"> 
	<div id="leaderboard">
		<table class="table table-striped table-hover">
		  <caption>List of users (who completed all levels)</caption>
		  <thead>
		    <tr>
		      <th scope="col">Username</th>
		      <c:forEach begin="1" end="${count}" varStatus="loop">
			    <th scope="col">Level${loop.index}</th>
			</c:forEach>
		      <th scope="col">Total</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${users}" var="user" varStatus="loop">
		   		<tr>
		      		<th scope="row">
		      			<c:choose>
			      			<c:when test="${loop.index == 0}">
			      				<i class="fas fa-trophy text-warning"></i> 
			      			</c:when>
			      			<c:when test="${loop.index == 1}">
			      				<i class="fas fa-trophy text-secondary"></i> 
			      			</c:when>
			      			<c:when test="${loop.index == 2}">
			      				<i class="fas fa-trophy" style="color:#cd7f32"></i> 
			      			</c:when>
			      			<c:otherwise>
			      				<i class="fas fa-trophy" style="visibility:hidden"></i> 
			      			</c:otherwise>
			      		</c:choose>
		      			&nbsp; ${user.username}
		      		</th>
		      		<c:forEach items="${user.timesPerLevel}" var="time" varStatus="loop">
		      			<td>${time}</td>
		      		</c:forEach>
		      		<td>${user.totalTime}</td>
		    	</tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
</c:when>
<c:otherwise>
	<div id="leaderboard" style="text-align:center">
		<h3>It seems no one has completed all the levels yet ...</h3><br>
		<h1><i class="fas fa-sad-tear"></i></h1>
	</div>
</c:otherwise>
</c:choose>