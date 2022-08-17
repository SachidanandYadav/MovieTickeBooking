$(document).ready(function(){
	
	getAllData();
	
});

	function getAllData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/movieList",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].movie_id + "</td><td>" + response[res].title + "</td><td>" + response[res].description + "</td><td>" + response[res].duration + "</td><td>" + response[res].language + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].movie_id + ")' data-toggle='modal' style='margin-right: 5px;' data-target='#exampleModal'><i class='fa fa-edit'></i></button><button type='button' class='btn btn-danger' data-toggle='modal'  data-target='#confirm-delete' id='deleteData' onclick='deleteData(" + response[res].movie_id + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
				}
			},
			failure: function(response) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(response) {
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
			$('#movieid').val(res[0].movie_id);
			$('#title').val(res[0].title);
			$('#description').val(res[0].description);
			$('#duration').val(res[0].duration);
			$('#language').val(res[0].language);
			$('#releaseDate').val(res[0].releaseDate);
			$('#genre').val(res[0].genre);
			$('#country').val(res[0].country_name);
			$('#imageUrl').val(res[0].imageUrl);
		},
		failure: function(response) {title
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
	movie.movie_id = $('#movieid').val();
	movie.title = $('#title').val();
	movie.description = $('#description').val();
	movie.duration = $('#duration').val();
	movie.language = $('#language').val();
	movie.releaseDate = $('#releaseDate').val();
	movie.genre = $('#genre').val();
	movie.country_name = $('#country').val();
	movie.imageUrl = $('#imageUrl').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/Movie",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function(response) {
			$("#user-table").html("");
			getAllData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function(response) {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(response) {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
});
	
	

function deleteData(id) {

	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/DeleteMovie/" + id,
			type: "DELETE",
			success: function(response, status) {
				$("#user-table").html("");
				getAllData();
				$('#deleteSuccess').show();
				$("#deleteSuccess").delay(8000).fadeOut("slow");
			},
			failure: function(response) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(response) {
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


