<div id="grid_container"></div>
<div id="control_panel">
    <div class="button_container">
        <button id="execute" class="btn">Execute</button>
        <button id="new_game" class="btn btn-default" disabled>New game</button> 
    </div>
    <div id="timer_container">
        <span class="title">Timer</span><br>
        <span id="timer">00:00</span>
        <c:if test="${not empty object.bestTimeForLevel}">
        	<span style="margin-left:2rem"><b>your best time:</b> ${object.bestTimeForLevel}</span>
        </c:if>
    </div>
</div>