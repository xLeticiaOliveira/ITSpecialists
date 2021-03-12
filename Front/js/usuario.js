function logar(){
    var user = document.getElementById("username").value;
    var userjson = {};
    var loginType = "";


    if (user.includes("@")){
        loginType = "Email";
        userjson = {
            email: user, 
            senha: document.getElementById("password").value
        };
    }
    else {
        loginType = "Racf";
        userjson = {
            racf: user, 
            senha: document.getElementById("password").value
        };
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(userjson),
        headers: {
            "Content-type": "application/json"
        }
    }

    fetch("http://localhost:8080/login" + loginType, cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("userlogado", JSON.stringify(res));
            window.location="agentesParceiros.html"
        })
        .catch(err => {
            window.alert("Login não realizado");
        });
}

function verificarObterUsuario(){
    var user = localStorage.getItem("userlogado");
    if(user == null){
        window.location="index.html";
    }
    else{
        return user;
    }
}

function carregarusuario(){
    var user = verificarObterUsuario();
    var userjson = JSON.parse(user);
    document.getElementById("dados").innerHTML = 
    "<h4> " + userjson.nome + " (" + userjson.racf + ") <br>" + userjson.email + "</h4>";

    document.getElementById("foto").innerHTML = 
    "<img width='100%'  alt='Foto do usuário' src=../Imagens/" + userjson.foto + ">";
}


function logout(){
    localStorage.removeItem("userlogado")
    return true;
}