$(document).ready(function(){
	
	getAllData();
	
});

	function getAllData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/movie-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].movieId + "</td><td>" + response[res].title + "</td><td>" + response[res].description + "</td><td>" + response[res].duration + "</td><td>" + response[res].language + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].movieId + ")' data-toggle='modal' style='margin-right: 5px;' data-target='#exampleModal'><i class='fa fa-edit'></i></button><button type='button' class='btn btn-danger' data-toggle='modal'  data-target='#confirm-delete' id='deleteData' onclick='deleteData(" + response[res].movieId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
				}
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	}
	
	
function editData(id) {
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/movie/" + id,
		type: "GET",
		success: function(res) {
			$('#movieid').val(res.movieId);
			$('#title').val(res.title);
			$('#description').val(res.description);
			$('#duration').val(res.duration);
			$('#language').val(res.language);
			$('#releaseDate').val(res.releaseDate);
			$('#genre').val(res.genre);
			$('#country').val(res.countryName);
			$('#imageUrl').val(res.imageUrl);
		},
		failure: function() {title
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(response) {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
}




$("#Movie").on("click", function() {
	var movie = {}
	movie.movieId = $('#movieid').val();
	movie.title = $('#title').val();
	movie.description = $('#description').val();
	movie.duration = $('#duration').val();
	movie.language = $('#language').val();
	movie.releaseDate = $('#releaseDate').val();
	movie.genre = $('#genre').val();
	movie.countryName = $('#country').val();
	movie.imageUrl = $('#imageUrl').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/movie",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function() {
			$("#user-table").html("");
			getAllData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function() {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function() {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
});
	
	

function deleteData(id) {

	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/delete-movie/" + id,
			type: "DELETE",
			success: function() {
				$("#user-table").html("");
				getAllData();
				$('#deleteSuccess').show();
				$("#deleteSuccess").delay(8000).fadeOut("slow");
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	});
}


function resetAllFiled(){
	$('#movieid').val('');
	$('#title').val('');
	$('#description').val('');
	$('#duration').val('');
	$('#language').val('');
	$('#releaseDate').val('');
	$('#genre').val('');
	$('#country').val('');
	$('#imageUrl').val('');
	
}


