function carregarAgentes(){
    // Obter os dados do back
    fetch("http://localhost:8080/agentes")
    .then(res => res.json())
    .then( res => {
        // Colocar os dados na combo box
        var cmbAgentes="";
        for(contador=0; contador<res.length; contador++){
            cmbAgentes += "<option value='" + res[contador].idAgente + "'>" + res[contador].nomeAgente +"</option>";
        }
        document.getElementById("cmbartistas").innerHTML = cmbAgentes;

        // Colocar os dados na tabela
        var tabela=
        "<table border='1' align='center'>" 
        +"<tr>" 
        +"<th> Parceiro </th>"
        +"<th> Volume Transacional </th>"
        +"</tr>";
        for(contador = 0; contador<res.length; contador++){
            tabela +=
            "<tr>" + 
            "<td>" + res[contador].nomeAgente + "</td>" +
            "<td>" + res[contador].volumeTransacional + "</td>" +
            "</tr>"
        }
        tabela += "</table>";
        document.getElementById("tabela").innerHTML = tabela;
    });
    

    fetch("http://localhost:8080/agentes/" + document.getElementById("cmbartistas").value)
    .then(res => res.json())
    .then( res => {
        var tabela=
        "<table border='1' align='center'>" 
        +"<tr>" 
        +"<th> Música </th>"
        +"<th>Lançamentos</th>"
        +"<th>ID</th>"
        +"</tr>";
        for(contador = 0; contador<res.length; contador++){
            tabela +=
            "<tr>" + 
            "<td>" + res.musicas[contador].titulo + "</td>" +
            "<td>" + res.musicas[contador].lancamento + "</td>" +
            "<td>" + res.musicas[contador].id + "</td>" +
            "</tr>"
        }
        tabela += "</table>";
        document.getElementById("tabela").innerHTML = tabela;
    });
}

function dashCard(){
    var cb = document.getElementById("cmbartistas")

    var parceiro = {
        "id": cmbAgentes.value
    }
    localStorage.setItem("parceiro", JSON.stringify(parceiro));
}