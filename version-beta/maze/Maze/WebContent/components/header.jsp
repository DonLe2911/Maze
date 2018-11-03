<div class="kainos_header">
     <a id="logo" href="<%=Tag.path_root%>"><img src="resources/img/logorgbonline.png"/></a>
     <div id="toolbar">
     <c:if test="${not empty sessionScope.username}">
	     <div id="profile" class="dropdown">
	      	<button class="btn btn-lg btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      		<i class="fas fa-user-circle"></i>
	      		<span class="caret"></span>
	      	</button>
	      	<div class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="profile">
	      		<button class="dropdown-item">${username}</button>
	      		<button id="signout" class="dropdown-item">Sign out</button>
	      	</div>
	      </div>
      </c:if>
      <div>
      	<a href="<%=Tag.path_board%>">
	      	<button class="btn btn-lg btn-default" type="button">
	      		<i class="fas fa-trophy text-warning"></i>
	      	</button> 
	    </a>
      </div>
   </div>
 </div>