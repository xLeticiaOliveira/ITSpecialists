function carregarAgentes(){
    // Obter os dados do back
    fetch("http://localhost:8080/agentes")
    .then(res => res.json())
    .then( res => {
        // Colocar os dados na combo box
        var cmbAgentes="<option disabled selected value> -- Selecione uma opção -- </option>";
        for(contador=0; contador<res.length; contador++){
            cmbAgentes += "<option value='" + res[contador].idAgente + "'>" + res[contador].nomeAgente +"</option>";
        }
        document.getElementById("cmbartistas").innerHTML = cmbAgentes;

        // Colocar os dados na tabela
        var tabela=
        "<thead class='thead-light'>" 
        +"<tr>" 
        +"<th scope='col'> # </th>"
        +"<th scope='col'> Parceiro </th>"
        +"<th scope='col'> Volume Transacional </th>"
        +"</tr>"
        + "</thead>";
        tabela += "<tbody>";
        for(contador = 0; contador<res.length; contador++){
            tabela +=
            "<tr scope='row'>" + 
            "<td>" + (contador+1) + "</td>" +
            "<td>" + res[contador].nomeAgente + "</td>" +
            "<td>" + res[contador].volumeTransacional + "</td>" +
            "</tr>"
        }
        tabela += "</tbody>";
        document.getElementById("tabela").innerHTML = tabela;
    });
}

function dashCard(){
    var cb = document.getElementById("cmbartistas")

    var parceiro = {
        "id": cb.value
    }
    localStorage.setItem("parceiro", JSON.stringify(parceiro));
    window.location = "dash.html"
}