function carregarParceiro(){
    var parceiro = localStorage.getItem("parceiro");
    
    if(parceiro == null){
        window.location="agentesParceiros.html";
    }
    else {
        // Obter novamente as informações daquele parceiro
        var parceiroJson = JSON.parse(parceiro);

        fetch("http://localhost:8080/agente/" + parceiroJson.id)
        .then(res => res.json())
        .then(res => {
            // Preencher o card de parceiro
            document.getElementById("parceiro").innerHTML = res.nomeAgente + " / " + res.volumeTransacional
        })
        .catch(err => {
            window.alert("Não foi possível obter as informações do parceiro");
        });


        // Obter as infos dos dashs
        fetch("http://localhost:8080/totalTransacao/" + parceiroJson.id)
        .then(res => res.json())
        .then(res => {
            // Preencher o card de parceiro
            document.getElementById("sucessos").innerHTML = res[0];
            document.getElementById("falhas").innerHTML = res[1];
            document.getElementById("fraudes").innerHTML = res[2];
        })
        .catch(err => {
            window.alert("Não foi possível obter as informações das transações");
        });


    }
}