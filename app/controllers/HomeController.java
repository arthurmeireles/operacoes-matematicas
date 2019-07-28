package controllers;
import java.util.Collections;
import play.mvc.*;
import models.*;
import java.util.*;

public class HomeController extends Controller {
  int valor1 = 0;
  int valor2 = 0;
  int totalSoma = 0;
  int produto = 0;
  int maior = 0;
  int menor = 0;
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result operacoes() {
    return ok(views.html.operacoes.render(valor1, valor2, totalSoma, produto, maior, menor));
    }

    public Result formOperacoes() {
      Map<String, String[]> r = request().body().asFormUrlEncoded();
      int valor1 = Integer.parseInt(r.get("a")[0]);
      int valor2 = Integer.parseInt(r.get("b")[0]);
      int totalSoma = valor1 + valor2;
      int produto = valor1*valor2;
      int maior;
      int menor; 
      if(valor1 > valor2){
        maior = valor1;
        menor = valor2;
      }else{
        maior = valor2;
        menor = valor1;
      }
      return ok(views.html.operacoes.render(valor1, valor2, totalSoma, produto, maior, menor));
    }

}