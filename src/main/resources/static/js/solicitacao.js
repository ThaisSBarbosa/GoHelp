function aprovarSolicitacao(codSolicitacao){
    $.ajax({
        type: "POST",
        url: "/solicitacao",
        data: {cod: codSolicitacao},
        success: function () {
            //alert("Solicitação aprovada!");
            //alert(data);
        },
        dataType: "JSON"
      });
}