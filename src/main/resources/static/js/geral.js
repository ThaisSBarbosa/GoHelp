var usuario;

function formataCampos() {

	var usuario = document.getElementById("tipoUsuario").value;

	if (usuario == "doador") {
		document.getElementById("aceiteSolicitante").style.visibility = "hidden";
		document.getElementById("dadosCartao").style.visibility = "visible";
		document.getElementById("dadosPrestador").style.visibility = "hidden";
	} else if (usuario == "solicitante") {
		document.getElementById("aceiteSolicitante").style.visibility = "visible";
		document.getElementById("dadosCartao").style.visibility = "hidden";
		document.getElementById("dadosPrestador").style.visibility = "hidden";
	} else if (usuario == "prestador") {
		document.getElementById("aceiteSolicitante").style.visibility = "hidden";
		document.getElementById("dadosCartao").style.visibility = "visible";
		document.getElementById("dadosPrestador").style.visibility = "visible";
	} else if (usuario == "empty") {
		document.getElementById("aceiteSolicitante").style.visibility = "hidden";
		document.getElementById("dadosCartao").style.visibility = "hidden";
		document.getElementById("dadosPrestador").style.visibility = "hidden";
	}
}

function cadastraUsuario() {
	usuario = new Object();
	usuario.nome = document.getElementById("nome").value;
	usuario.cpf = document.getElementById("cpf").value;
	usuario.email = document.getElementById("email").value;
	usuario.confirmaEmail = document.getElementById("confirmaEmail").value;
	usuario.senha = document.getElementById("senha").value;
	usuario.confirmaSenha = document.getElementById("confirmaSenha").value;
	usuario.endereco = document.getElementById("endereco").value;
	usuario.cep = document.getElementById("cep").value;
	usuario.tipoUsuario = document.getElementById("cbTipoUsuario").value;
	usuario.consultaCadUnico = document.getElementById("consultaCadUnico").checked;
	usuario.numeroCartao = document.getElementById("numeroCartao").value;
	usuario.validade = document.getElementById("validade").value;
	usuario.codigoSeguranca = document.getElementById("codigoSeguranca").value;
	usuario.diaSemana = document.getElementById("diaSemana").value;
	usuario.numeroCNH = document.getElementById("numeroCNH").value;
	usuario.periodo = document.getElementById("periodo").value;
	usuario.aceitaTermos = document.getElementById("aceitaTermos").checked;

	console.log(usuario);

	exibirHome();
}

function exibirHome() {
	window.location.href = "index";
}

// region Maps

// Initialize and add the map

let map;
let marker;
let geocoder;

let indexItem = 0;
let lista;

let cepAtual ;

window.initMap = initMap;

function initMap() {
	map = new google.maps.Map(document.getElementById("map"), {
		zoom: 16,
		mapTypeControl: false,
	});

	marker = new google.maps.Marker({
		map,
	});

	lista = [
		{'localizacao': '09855200'},
		{'localizacao': '09855250'},
		{'localizacao': '09750902'},
		{'localizacao': '09721180'}
	];
	getCEP();
	geocode({ address: cepAtual });
	console.log(cepAtual);
	clear();
}

function clear() {
	marker.setMap(null);
}

function geocode(cep) {
	geocoder = new google.maps.Geocoder();
	request = cep;
	clear();
	geocoder
		.geocode(request)
		.then((result) => {
			const { results } = result;

			map.setCenter(results[0].geometry.location);
			marker.setPosition(results[0].geometry.location);
			marker.setMap(map);

			console.log(results[0].geometry.viewport.Va.lo);
			console.log(results[0].geometry.viewport.Bb.lo);

			return results;
		})
		.catch((e) => {
			console.log("Geocode was not successful for the following reason: " + e);
		});
}

document.getElementById("proximo").onclick = proximoItem;

function proximoItem() {
	indexItem++;
	if (indexItem==Object.keys(lista).length){
		indexItem=0;
	}
	initMap();
}

function getCEP(){
	cepAtual = lista[indexItem].localizacao;
	//cepAtual = "09855200";
}
// end region