$(document).ready(function(){
	
	getAllData();
	
});

	function getAllData() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/movie-list",
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
		url: "http://127.0.0.1:8080/MovieTickectBooking/movie/" + id,
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


function check(filed, message) {
	if (filed == "" || filed == null) {
		$("#" + message + "Error").html(message + " Filed is Required");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
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
	

	var Title = check(movie.title, "Title");
	var Description = check(movie.description, "Description");
	var Duration = check(movie.duration, "Duration");
	var Language = check(movie.language, "Language");
	var Release = check(movie.releaseDate, "ReleaseDate");
	var Genre = check(movie.genre, "Genre");
	var Country = check(movie.countryName, "Country");
	var Image = check(movie.imageUrl, "ImageUrl");
	
	
	if(Title && Description && Duration && Language && Release && Genre && Country && Image){
	restAllError();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/movie-detail",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function() {
			$('.close').click();
			$("#user-table").html("");
			getAllData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function() {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(message) {
			$('#TitleError').html(message.responseJSON.title);
			$('#TitleError').show();
			$('#DescriptionError').html(message.responseJSON.description);
			$('#DescriptionError').show();
			$('#DurationError').html(message.responseJSON.duration);
			$('#DurationError').show();
			$('#LanguageError').html(message.responseJSON.language);
			$('#LanguageError').show();
			$('#ReleaseDateError').html(message.responseJSON.releaseDate);
			$('#ReleaseDateError').show();
			$('#GenreError').html(message.responseJSON.genre);
			$('#GenreError').show();
			$('#CountryError').html(message.responseJSON.countryName);
			$('#CountryError').show();
			$('#ImageUrlError').html(message.responseJSON.imageUrl);
			$('#ImageUrlError').show();
			
		}
	});
	}
});
	
	

function deleteData(id) {

	$("#delete").on("click", function() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/delete-movie/" + id,
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

function restAllError(){
	$('#TitleError').html("");
	$('#DescriptionError').html("");
	$('#DurationError').html("");
	$('#LanguageError').html("");
	$('#ReleaseDateError').html("");
	$('#GenreError').html("");
	$('#CountryError').html("");
	$('#ImageUrlError').html("");
}


