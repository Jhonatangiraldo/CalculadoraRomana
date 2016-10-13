(function() {
  var app = angular.module('gemStore', []);

app.controller('StoreController',['$http', function($http){
    var store = this;
    store.numero1 = '';
    store.numero2 = '';
    store.contenido = '';
    store.mostrarDatos = false;
    //var x2js = new X2JS(); Se usa para convertir de xml a json

    this.consultar = function(){
    	if (store.numero1 == '' || store.numero2 ==''){
    		alert("Error, ingrese un valor romano");
    	}else{
	    	$http.get('http://localhost:8080/ProjectNormal/rs/service2/hola?numero1='+store.numero1+
	    			 "&numero2="+store.numero2)
	        .success(function(data){
	        	store.contenido = data;
	      	  store.mostrarDatos = true;
	        });
    	}
    }
      
  }]);

})();