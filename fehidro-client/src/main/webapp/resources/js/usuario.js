$(document).ready(function () {

	if ($("#formUsuario\\:txtPerfilAcesso").val() == "3") {
		$("#infoCTPG").show();
	}
	
	$("#formUsuario\\:txtPerfilAcesso").on('change', function () {
    	if ($("#formUsuario\\:txtPerfilAcesso").val() == "3") {
    		$("#infoCTPG").show();
    	}
    	else {
    		$("#infoCTPG").hide();
    		$("#formUsuario\\:txtNascimento").val("");
    		$("#formUsuario\\:txtInstituicao").val("");
    		$("#formUsuario\\:txtDataInicioMandato").val("");
    	}
    });
	
	$('.alpha').keydown(function (e) {
        if (e.shiftKey || e.ctrlKey || e.altKey) {
            e.preventDefault();
        } else {
            var key = e.keyCode;
            if (!((key == 8) || (key == 9) || (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
                e.preventDefault();
            }
        }
    });

	$(document).on("input", ".numeric", function() {
	    this.value = this.value.replace(/\D/g,'');
	});
});