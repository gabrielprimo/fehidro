$(document).ready(function () {

	$("#lstMenus li").removeClass("active");
	var menuAtual = $("#menuAtual").val();
	$("#menu" + menuAtual).addClass("active");
	
	$("#txtPesquisa").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#tabela tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
		});
	});
	
	$('.alpha').keydown(function (e) {
        if (e.shiftKey || e.ctrlKey || e.altKey) {
            e.preventDefault();
        } else {
            var key = e.keyCode;
            if (!((key == 8) || (key == 9) || (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90) 
            		|| (key == 186))) {
                e.preventDefault();
            }
        }
    });

	$(document).on("input", ".numeric", function() {
	    this.value = this.value.replace(/\D/g,'');
	});

});