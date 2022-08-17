<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="/MovieTickectBooking/adminDashboardPage">Admin Dashboard</a>
      </div>
      <ul class="nav navbar-nav">
         <li><a href="#">Profile</a></li>
			<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown">Admin Page<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/MovieTickectBooking/bookingPage">Booked Customer</a></li>
					<li><a href="/MovieTickectBooking/Movie">Movie</a></li>
					<li><a href="/MovieTickectBooking/movieShow">Movie Show</a></li>
					<li><a href="/MovieTickectBooking/cinemaHall">Cinema Hall</a></li>
					<li><a href="/MovieTickectBooking/cinemaSeat">Cinema Seat</a></li>
					<li><a href="/MovieTickectBooking/showSeat">Show Seat</a></li>
					
				</ul></li>
		</ul>
      <ul class="nav navbar-nav navbar-right">
       <li><a href=""><span class="glyphicon glyphicon-user"></span> ${username}</a></li>
      <%--   <li><span class="glyphicon glyphicon-user"></span></li> --%>
        <li><a href="/MovieTickectBooking/LoginPage"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </nav>