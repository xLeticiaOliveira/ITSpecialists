function carregarParceiro(){
    var parceiro = localStorage.getItem("parceiro");
    
    if(parceiro ==
         null){
        window.location="agentesParceiros.html";
    }
    else {
        // Obter novamente as informações daquele parceiro
        var parceiroJson = JSON.parse(parceiro);

        var cabecalho = {
            method: "POST",
            body: JSON.stringify(userjson),
            headers: {
                "Content-type": "application/json"
            }
        }

        fetch("http://localhost:8080/parceiro/" + parceiroJson.id, cabecalho)
        .then(res => res.json())
        .then(res => {
            // Preencher o card de parceiro
            
        })
        .catch(err => {
            window.alert("Não foi possível obter as informações desejadas");
        });


        // Obter as infos dos dashs







        
        document.getElementById("dados").innerHTML = 
        "<h4> " + parceiroJson.nome + "(" + userjson.id + ") <br>" + parceiroJson.email + "</h4>";

        document.getElementById("foto").innerHTML = 
        "<img width='200px' height='200px'  alt='Foto do usuário' src=../Imagens/" + userjson.foto + ">";
    }
}