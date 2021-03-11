function carregarParceiro(){
    var parceiro = localStorage.getItem("parceiro");
    
    if(parceiro == null){
        window.location="agentesParceiros.html";
    }
    else {
        // Obter novamente as informações daquele parceiro
        var parceiroJson = JSON.parse(parceiro);

        var cabecalho = {
            method: "GET"
        }

        fetch("http://localhost:8080/agente/" + parceiroJson.id, cabecalho)
        .then(res => res.json())
        .then(res => {
            // Preencher o card de parceiro
            document.getElementById("parceiro").innerHTML = res.nomeAgente + " / " + res.volumeTransacional
        })
        .catch(err => {
            window.alert("Não foi possível obter as informações desejadas");
        });


        // Obter as infos dos dashs
    }
}