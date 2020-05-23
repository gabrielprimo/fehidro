$(document).ready(function () {

	$("#lstMenus li").removeClass("active");
	var menuAtual = $("#menuAtual").val();
	$("#menu" + menuAtual).addClass("active");
	
	$("#txtPesquisa").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#tabela tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
		});
	});

});