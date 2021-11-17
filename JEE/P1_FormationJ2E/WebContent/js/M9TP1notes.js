$(function() {
	loadNotes();
});

function loadNotes() {
	$.getJSON("http://localhost:8080/P1_FormationJ2E/rest/notes",
			  function(data) {
		
		$.each(data, function() {
			ajouterBaliseNote(this);
		});		
		
	});
}

function ajouterBaliseNote(note) {
	var newContent = '<div class="col-md-4 note" id="card' + note.id + '">' +
	 '	<div class="card">' +
	 '		<div class="card-header">' +
	 '			<h3>Note du ' + note.date + '</h3>' +
	 '		</div>' +
	 '		<div class="card-body">' +
	 '			<textarea id="txt' + note.id + '" class="col-12" onkeyup="updateNote(' + note.id + ')">'  + note.contenu + '</textarea>' +
	 '		</div>' +
	 '		<div class="card-footer">' +
	 '			<button class="btn btn-danger" onclick="supprimerNote(' + note.id + ')">Supprimer</button>' +
	 '		</div>' +
	 '	</div>' +
	 '</div>';

	$("#notes").append(newContent);
}

function updateNote(id) {
	var contenu = $("#txt".concat(id)).val();
	
	$.ajax({
		type:"PUT",
		url:"http://localhost:8080/P1_FormationJ2E/rest/notes/".concat(id),
		data: {paramContenu: contenu}
	});
}


function supprimerNote(id) {
	$.ajax({
		type:"DELETE",
		url:"http://localhost:8080/P1_FormationJ2E/rest/notes/".concat(id),
		success: function(result) {
			$("#card".concat(id)).remove();
		}
	});
}

function ajouterNote() {
	var contenu = $("#txtNewCard").val();
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/P1_FormationJ2E/rest/notes/",
		data: {paramContenu: contenu},
		success: function(result) {
			loadNotes();
		}
	});
	
	$(".note").remove();
	$("#txtNewCard").val("");
	
}



